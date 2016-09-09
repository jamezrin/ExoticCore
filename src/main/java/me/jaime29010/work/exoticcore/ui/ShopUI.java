package me.jaime29010.work.exoticcore.ui;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonBooster;
import me.jaime29010.work.exoticcore.data.JsonPlayer;
import me.jaime29010.work.exoticcore.manager.EcononyManager;
import me.jaime29010.work.exoticcore.utils.ItemCreator;
import me.jaime29010.work.exoticcore.utils.Messager;
import me.jaime29010.work.exoticcore.utils.SkullType;
import me.jaime29010.work.exoticcore.utils.UUIDFetcher;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static org.bukkit.entity.EntityType.*;

public class ShopUI {
    public static final List<EntityType> TYPES = Arrays.asList(CHICKEN, OCELOT, SHEEP, PIG, WOLF, COW, MUSHROOM_COW, CAVE_SPIDER, SPIDER,
            SKELETON, ZOMBIE, SLIME, ENDERMAN, PIG_ZOMBIE, CREEPER, BLAZE, IRON_GOLEM, SILVERFISH);
    private static final List<Player> viewers = new LinkedList<>();

    public static void open(Player player, Main main) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 2, ItemCreator.color("&l&bExotic&fMC &7Head Selling"));
        viewers.add(player);
        player.openInventory(inventory);
    }

    public static List<Player> getViewers() {
        return viewers;
    }

    public static void init(Main main) {
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryListener(main), main);
    }

    public static class InventoryListener implements Listener {
        private final Main main;

        public InventoryListener(Main main) {
            this.main = main;
        }

        @EventHandler
        public void on(InventoryCloseEvent event) {
            Player player = (Player) event.getPlayer();
            viewers.remove(player);
        }

        @EventHandler
        public void on(InventoryClickEvent event) {
            Inventory inventory = event.getClickedInventory();
            Player player = (Player) event.getWhoClicked();
            if (viewers.contains(player)) {
                ItemStack item = null;
                if (inventory instanceof PlayerInventory) {
                    if (event.isShiftClick()) {
                        item = event.getCurrentItem();
                    }
                } else if (inventory != null) {
                    item = event.getCursor();
                }
                if (item == null) return;
                if (item.getType() == Material.SKULL_ITEM) {
                    SkullType type = SkullType.from(item);
                    if (type != null && main.canEntity(type.getEntityType(), player)) {
                        JsonPlayer wrapper = main.getDataPool().getPlayers().get(player.getUniqueId());
                        if (inventory instanceof PlayerInventory) {
                            if (event.isShiftClick()) {
                                player.getInventory().clear(event.getSlot());
                            }
                        } else {
                            main.getServer().getScheduler().runTask(main, inventory::clear);
                        }

                        int points = main.getHeadPrice(type.getEntityType()) * (item.getAmount() != 0 ? item.getAmount() : 1);

                        JsonBooster booster = main.getBoosterManager().getBooster(player);
                        if (booster != null) {
                            points *= booster.getMultiplier();
                        }

                        wrapper.setPoints(wrapper.getPoints() + points);
                        player.sendMessage(Messager.colorize(main.getConfig().getString("messages.gained-points")
                                .replace("%points%", String.valueOf(points))
                        ));
                    } else {
                        SkullMeta meta = (SkullMeta) item.getItemMeta();
                        if (meta.hasOwner()) {
                            try {
                                UUID uuid = UUIDFetcher.getUUIDOf(meta.getOwner());
                                if (!uuid.equals(player.getUniqueId())) {
                                    OfflinePlayer target = main.getServer().getOfflinePlayer(uuid);
                                    JsonPlayer wrapper = main.getDataPool().getPlayers().get(uuid);
                                    if (target != null && wrapper != null && wrapper.getBounty() != 0) {
                                        if (inventory instanceof PlayerInventory) {
                                            if (event.isShiftClick()) {
                                                player.getInventory().clear(event.getSlot());
                                            }
                                        } else {
                                            main.getServer().getScheduler().runTask(main, inventory::clear);
                                        }

                                        EconomyResponse response = EcononyManager.getEconomy().depositPlayer(player, wrapper.getBounty());
                                        if (response.transactionSuccess()) {
                                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.bounty-reward")
                                                    .replace("%bounty%", String.valueOf(wrapper.getBounty()))
                                            ));
                                            wrapper.setBounty(0);
                                        }
                                    } else {
                                        player.sendMessage(Messager.colorize(main.getConfig().getString("messages.not-bounty-reward")));
                                    }
                                } else {
                                    player.sendMessage(ChatColor.RED + "You cannot sell your own head");
                                    event.setCancelled(true);
                                    player.closeInventory();
                                    viewers.remove(player);
                                }
                            } catch (Exception e) {
                                player.sendMessage(ChatColor.RED + "An error occurred while doing this operation");
                                e.printStackTrace();
                            }
                        } else {
                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.invalid-head")));
                            event.setCancelled(true);
                            player.closeInventory();
                            viewers.remove(player);
                        }
                    }
                } else {
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.only-heads")));
                    event.setCancelled(true);
                    player.closeInventory();
                    viewers.remove(player);
                }
            }
        }
    }
}
