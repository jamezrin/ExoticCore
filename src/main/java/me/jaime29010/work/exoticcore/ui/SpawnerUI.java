package me.jaime29010.work.exoticcore.ui;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonSpawner;
import me.jaime29010.work.exoticcore.manager.ExperienceManager;
import me.jaime29010.work.exoticcore.utils.ItemCreator;
import me.jaime29010.work.exoticcore.utils.Messager;
import me.jaime29010.work.exoticcore.utils.NumberFormatter;
import me.jaime29010.work.exoticcore.utils.TimeUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SpawnerUI {
    private static int REFUEL_COST = 5000;
    private static Map<Player, UIContext> viewers = new HashMap<>();
    private static ItemStack[] contents = new ItemStack[9 * 3];

    public static void open(Player player, JsonSpawner wrapper, EntityType type, Main main) {
        Inventory inventory = Bukkit.createInventory(null, 9 * 3, "{type} Spawner".replace("{type}", ItemCreator.color(main.getAlias(type))));
        inventory.setContents(contents);

        int price = getUpgradePrice(wrapper.getTier());
        String cost = price != -999 ? NumberFormatter.format(price) : "Max";

        inventory.setItem(12, ItemCreator.create(Material.EMERALD, "&cUpgrade Spawner", Arrays.asList(
                "&7Current Tier: &c{tier}".replace("{tier}", String.valueOf(wrapper.getTier())),
                "&7Cost to upgrade: &c{cost}".replace("{cost}", wrapper.getTier() != 5 ? cost + " xp" : "Max Tier")), 1));
        inventory.setItem(13, ItemCreator.create(Material.CHEST, "&cSpawner Info", Arrays.asList(
                "&7Current Tier: &c{tier}".replace("{tier}", String.valueOf(wrapper.getTier())),
                "&7Spawner Type: &c{type}".replace("{type}", ItemCreator.color(main.getAlias(type))),
                "&7Price per head: &c{price}".replace("{price}", String.valueOf(main.getHeadPrice(type)))), 1));
        viewers.put(player, new UIContext(wrapper, main.getServer().getScheduler().scheduleSyncRepeatingTask(main, () -> {
            inventory.setItem(14, ItemCreator.create(Material.COAL, "&cFuel Spawner", Arrays.asList(
                    "&7Duration: &c1 day",
                    "&7Fueled for: &c{fuel}".replace("{fuel}", TimeUtils.convert(wrapper.getFuel())),
                    "&7Cost to refuel: &c{cost} xp".replace("{cost}", NumberFormatter.format(REFUEL_COST))), 1));
        }, 0, 20)));
        player.openInventory(inventory);
    }

    public static Map<Player, UIContext> getViewers() {
        return viewers;
    }

    private static void applyItems(Item... items) {
        for (Item item : items) {
            for (int slot : item.getSlots()) {
                contents[slot] = item.getItemStack();
            }
        }
    }

    public static void init(Main main) {
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryListener(main), main);
        applyItems(
                new Item(ItemCreator.create(Material.STAINED_GLASS_PANE, " ", null, 1, (short) 14), 0, 3, 4, 5, 8, 9, 17, 18, 21, 22, 23, 26),
                new Item(ItemCreator.create(Material.STAINED_GLASS_PANE, " ", null, 1, (short) 15), 1, 2, 6, 7, 10, 11, 15, 16, 19, 20, 24, 25)
        );
    }

    private static int getUpgradePrice(int current) {
        switch (current) {
            case 1: {
                return 2500;
            }
            case 2: {
                return 5000;
            }
            case 3: {
                return 10000;
            }
            case 4: {
                return 25000;
            }
            default: {
                return -999;
            }
        }
    }

    private static final class Item {
        private final ItemStack item;
        private final int[] slots;

        public Item(ItemStack item, int... slots) {
            this.item = item;
            this.slots = slots;
        }

        public ItemStack getItemStack() {
            return item;
        }

        public int[] getSlots() {
            return slots;
        }
    }

    public static class InventoryListener implements Listener {
        private final Main main;

        public InventoryListener(Main main) {
            this.main = main;
        }

        @EventHandler
        public void on(InventoryCloseEvent event) {
            Player player = (Player) event.getPlayer();
            UIContext context = viewers.remove(player);
            if (context == null) return;

            main.getServer().getScheduler().cancelTask(context.getTaskId());
        }

        @EventHandler
        public void on(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();
            UIContext context = viewers.get(player);
            if (context == null) return;

            JsonSpawner wrapper = context.getWrapper();
            event.setCancelled(true);
            int slot = event.getSlot();
            switch (slot) {
                case 12: {
                    //Upgrade
                    int price = getUpgradePrice(wrapper.getTier());
                    if (price != -999) {
                        int exp = ExperienceManager.getTotalExperience(player);
                        if (exp >= price) {
                            ExperienceManager.setTotalExperience(player, exp - price);
                            player.updateInventory();
                            wrapper.setTier(wrapper.getTier() + 1);
                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.spawner-upgraded")
                                    .replace("%level%", String.valueOf(wrapper.getTier()))
                            ));
                        } else {
                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.required-exp-upgrade")));
                        }
                    } else {
                        player.sendMessage(Messager.colorize(main.getConfig().getString("messages.spawner-maxed")));
                    }
                    player.closeInventory();
                    break;
                }
                case 14: {
                    //Fuel
                    int exp = ExperienceManager.getTotalExperience(player);
                    if (exp >= REFUEL_COST) {
                        ExperienceManager.setTotalExperience(player, exp - REFUEL_COST);
                        player.updateInventory();
                        wrapper.setFuel(wrapper.getFuel() + 86400);
                        player.sendMessage(Messager.colorize(main.getConfig().getString("messages.spawner-refuel")));
                    } else {
                        player.sendMessage(Messager.colorize(main.getConfig().getString("messages.required-exp-refuel")));
                    }
                    player.closeInventory();
                    break;
                }
            }
        }
    }
    private static class UIContext {
        private final JsonSpawner wrapper;
        private final int taskId;
        private UIContext(JsonSpawner wrapper, int taskId) {
            this.wrapper = wrapper;
            this.taskId = taskId;
        }

        public JsonSpawner getWrapper() {
            return wrapper;
        }

        public int getTaskId() {
            return taskId;
        }
    }
}
