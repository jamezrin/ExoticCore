package me.jaime29010.work.exoticcore.manager;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonBooster;
import me.jaime29010.work.exoticcore.utils.ItemCreator;
import me.jaime29010.work.exoticcore.utils.Messager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

public class BoosterManager implements Listener {
    public static final ItemStack GLOBAL_BOOSTER_ITEM = ItemCreator.create(Material.EMERALD, "&l&bExotic&fMC&r &7Global Booster", 1);
    public static final ItemStack PERSONAL_BOOSTER_ITEM = ItemCreator.create(Material.DIAMOND, "&l&bExotic&fMC&r &7Personal Booster", 1);

    private final Main main;
    public BoosterManager(Main main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);

        main.getServer().getScheduler().runTaskTimer(main, () -> {
            Iterator<Entry<UUID, JsonBooster>> iterator = main.getDataPool().getBoosters().entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<UUID, JsonBooster> entry = iterator.next();
                UUID uuid = entry.getKey();
                JsonBooster booster = entry.getValue();

                if (booster.isActive()) {
                    booster.setTime(booster.getSecondsRemaining() - 1);
                }

                if (booster.getSecondsRemaining() <= 0) {
                    booster.setActive(false);
                    iterator.remove(); //remove from map
                    if (uuid == null) {
                        main.getServer().getOnlinePlayers().forEach(player -> {
                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-expired")
                                    .replace("%type%", "global")
                            ));

                            JsonBooster personal = main.getDataPool().getBoosters().get(player.getUniqueId());
                            if (personal != null) {
                                personal.setActive(true);
                                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-resumed")));
                            }
                        });
                    } else {
                        Player player = main.getServer().getPlayer(uuid);
                        if (player != null) {
                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-expired")
                                    .replace("%type%", "personal")
                            ));
                        }
                    }
                }
            }
        }, 0, 20);
    }

    public JsonBooster getBooster(Player player) {
        JsonBooster booster = main.getDataPool().getBoosters().get(null);
        if (isActive(booster)) {
            return booster;
        }

        booster = main.getDataPool().getBoosters().get(player.getUniqueId());
        if (isActive(booster)) {
            return booster;
        }

        return null;
    }

    public boolean isActive(JsonBooster booster) {
        return (booster != null && booster.isActive());
    }

    @EventHandler
    public void on(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack item = event.getItem();
            if (hasSameName(item, GLOBAL_BOOSTER_ITEM)) {
                JsonBooster booster = this.getBooster(player);
                if (booster == null) {
                    if (item.getItemMeta() != null && item.getItemMeta().hasLore()) {
                        List<String> lore = item.getItemMeta().getLore();
                        int multiplier = Integer.valueOf(ChatColor.stripColor(lore.get(0).split("\\s+")[1]));
                        int minutes = Integer.valueOf(ChatColor.stripColor(lore.get(1).split("\\s+")[1]));
                        booster = new JsonBooster(player, multiplier, minutes);
                    } else {
                        booster = new JsonBooster(player, 2, 45);
                    }

                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1);
                    } else {
                        item.setType(Material.AIR);
                    }

                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-activated")
                            .replace("%type%", "global")
                            .replace("%multiplier%", String.valueOf(booster.getMultiplier()))
                            .replace("%minutes%", String.valueOf(booster.getMinutesRemaining()))
                    ));

                    for (Player other : main.getServer().getOnlinePlayers()) {
                        if (player != other) {
                            other.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-activated-others")
                                    .replace("%player%", player.getName())
                                    .replace("%type%", "global")
                                    .replace("%multiplier%", String.valueOf(booster.getMultiplier()))
                                    .replace("%minutes%", String.valueOf(booster.getMinutesRemaining()))
                            ));
                        }
                    }
                    main.getDataPool().getBoosters().put(null, booster);
                    player.setItemInHand(item);
                } else {
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-active")));
                }
            } else if (hasSameName(item, PERSONAL_BOOSTER_ITEM)) {
                JsonBooster booster = this.getBooster(player);
                if (booster == null) {
                    if (item.getItemMeta() != null && item.getItemMeta().hasLore()) {
                        List<String> lore = item.getItemMeta().getLore();
                        int multiplier = Integer.valueOf(ChatColor.stripColor(lore.get(0).split("\\s+")[1]));
                        int minutes = Integer.valueOf(ChatColor.stripColor(lore.get(1).split("\\s+")[1]));
                        booster = new JsonBooster(player, multiplier, minutes);
                    } else {
                        booster = new JsonBooster(player, 2, 30);
                    }

                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1);
                    } else {
                        item.setType(Material.AIR);
                    }

                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-activated")
                            .replace("%type%", "personal")
                            .replace("%multiplier%", String.valueOf(booster.getMultiplier()))
                            .replace("%minutes%", String.valueOf(booster.getMinutesRemaining()))
                    ));

                    main.getDataPool().getBoosters().put(player.getUniqueId(), booster);
                    player.setItemInHand(item);
                } else {
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-active")));
                }
            }
        }
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        JsonBooster global = main.getDataPool().getBoosters().get(null);
        JsonBooster personal = main.getDataPool().getBoosters().get(player.getUniqueId());
        if (personal != null && global == null) {
            personal.setActive(true);
        }
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        JsonBooster global = main.getDataPool().getBoosters().get(null);
        JsonBooster personal = main.getDataPool().getBoosters().get(player.getUniqueId());
        if (personal != null && global == null) {
            personal.setActive(false);
        }
    }

    private boolean hasSameName(ItemStack item1, ItemStack item2) {
        String name1 = String.valueOf(getCustomName(item1));
        String name2 = String.valueOf(getCustomName(item2));
        return name1.equals(name2);
    }

    private String getCustomName(ItemStack item) {
        if (item == null) return null;
        if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
            return item.getItemMeta().getDisplayName();
        }
        return null;
    }
}
