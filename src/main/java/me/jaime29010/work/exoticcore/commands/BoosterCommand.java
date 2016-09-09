package me.jaime29010.work.exoticcore.commands;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonBooster;
import me.jaime29010.work.exoticcore.manager.BoosterManager;
import me.jaime29010.work.exoticcore.utils.Messager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BoosterCommand implements CommandExecutor {
    private final Main main;

    public BoosterCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 0) {
            switch (args[0].toLowerCase()) {
                case "activate": {
                    if (sender.hasPermission("exoticcore.admin")) {
                        if (args.length >= 3) {
                            int multiplier = Integer.valueOf(args[1]);
                            int minutes = Integer.valueOf(args[2]);

                            JsonBooster booster = new JsonBooster(sender, multiplier, minutes);
                            if (args.length == 4) {
                                Player player = main.getServer().getPlayer(args[3]);
                                if (player != null) {
                                    JsonBooster current = main.getBoosterManager().getBooster(player);
                                    if (current == null) {
                                        main.getDataPool().getBoosters().put(player.getUniqueId(), booster);
                                        player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-activated")
                                                .replace("%type%", "personal")
                                                .replace("%multiplier%", String.valueOf(booster.getMultiplier()))
                                                .replace("%minutes%", String.valueOf(booster.getMinutesRemaining()))
                                        ));
                                    } else {
                                        player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-active")));
                                    }
                                } else {
                                    sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-offline")));
                                }
                            } else {
                                JsonBooster global = main.getDataPool().getBoosters().get(null);
                                if (global == null) {
                                    main.getDataPool().getBoosters().forEach((uuid, personal) -> {
                                        if (uuid != null) {
                                            personal.setActive(false);

                                            Player player = main.getServer().getPlayer(uuid);
                                            if (player != null) {
                                                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-paused")));
                                            }
                                        }
                                    });
                                    main.getDataPool().getBoosters().put(null, booster);
                                    sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-activated")
                                            .replace("%type%", "global")
                                            .replace("%multiplier%", String.valueOf(booster.getMultiplier()))
                                            .replace("%minutes%", String.valueOf(booster.getMinutesRemaining()))
                                    ));
                                } else {
                                    sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-active")));
                                }
                            }
                        } else break;
                    } else {
                        sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.no-permission")));
                    }
                    return true;
                }

                case "give": {
                    if (sender.hasPermission("exoticcore.admin")) {
                        if (args.length == 5) {
                            Player player = main.getServer().getPlayer(args[1]);
                            if (player != null) {
                                int multiplier = Integer.valueOf(args[2]);
                                int minutes = Integer.valueOf(args[3]);

                                final ItemStack item;
                                if (args[4].equalsIgnoreCase("personal")) {
                                    item = BoosterManager.PERSONAL_BOOSTER_ITEM;
                                } else if (args[4].equalsIgnoreCase("global")){
                                    item = BoosterManager.GLOBAL_BOOSTER_ITEM;
                                } else break;

                                ItemMeta meta = item.getItemMeta();
                                meta.setLore(Arrays.asList(
                                        ChatColor.AQUA + "Multiplier:" + " " + ChatColor.GRAY + multiplier,
                                        ChatColor.AQUA + "Minutes:" + " " + ChatColor.GRAY + minutes)
                                );
                                item.setItemMeta(meta);
                                player.getInventory().addItem(item);
                                player.updateInventory();
                                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.gave-booster")
                                        .replace("%player%", player.getName())
                                        .replace("%multiplier%", String.valueOf(multiplier))
                                        .replace("%minutes%", String.valueOf(minutes))
                                ));
                            } else {
                                sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-offline")));
                            }
                        } else break;
                    } else {
                        sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.no-permission")));
                    }
                    return true;
                }
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                JsonBooster booster = main.getBoosterManager().getBooster(player);
                if (booster != null) {
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.current-booster")
                            .replace("%minutes%", String.valueOf(booster.getMinutesRemaining()))
                            .replace("%multiplier%", String.valueOf(booster.getMultiplier()))
                            .replace("%owner%", booster.getOwner())
                    ));
                } else {
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.booster-inactive")));
                }
            } else {
                sender.sendMessage("This command can only be executed by a player");
                if (sender.hasPermission("exoticcore.admin")) {
                    sender.sendMessage("You can execute these commands:");
                    Messager.send(sender, "&b/booster activate <multiplier> <minutes> [player] &7- &cActivates a booster, global if no player specified");
                    Messager.send(sender, "&b/booster give <player> <multiplier> <minutes> <personal:global> &7- &cGives an item to the player given, type is personal or global");
                }
            }
            return true;
        }

        if (sender.hasPermission("exoticcore.admin")) {
            Messager.send(sender, "&b/booster activate <multiplier> <minutes> [player] &7- &cActivates a booster, global if no player specified");
            Messager.send(sender, "&b/booster give <player> <multiplier> <minutes> <personal:global> &7- &cGives an item to the player given, type is personal or global");
        }
        Messager.send(sender, "&b/booster &7- &cShows the current booster");
        return true;
    }
}
