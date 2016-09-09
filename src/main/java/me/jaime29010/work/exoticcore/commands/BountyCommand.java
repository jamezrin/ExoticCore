package me.jaime29010.work.exoticcore.commands;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonPlayer;
import me.jaime29010.work.exoticcore.manager.EcononyManager;
import me.jaime29010.work.exoticcore.utils.Messager;
import me.jaime29010.work.exoticcore.utils.PluginUtils;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class BountyCommand implements CommandExecutor {
    private final Main main;

    public BountyCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 0) {
            switch (args[0].toLowerCase()) {
                case "add": {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        String name = args[1];
                        Player target = main.getServer().getPlayer(name);
                        if (target != null) {
                            JsonPlayer wrapper = main.getDataPool().getPlayers().get(target.getUniqueId());
                            try {
                                int amount = Integer.parseInt(args[2]);
                                if (amount >= main.getConfig().getInt("minimum-bounty")) {
                                    if (EcononyManager.getEconomy().has(player, amount)) {
                                        EconomyResponse response = EcononyManager.getEconomy().withdrawPlayer(player, amount);
                                        if (response.transactionSuccess()) {
                                            wrapper.setBounty(wrapper.getBounty() + amount);
                                            main.getServer().getOnlinePlayers().forEach(other -> {
                                                other.sendMessage(Messager.colorize(main.getConfig().getString("messages.bounty-added")
                                                        .replace("%player%", player.getName())
                                                        .replace("%amount%", String.valueOf(amount))
                                                        .replace("%target%", target.getName())
                                                ));
                                            });
                                        } else {
                                            player.sendMessage(ChatColor.RED + "The transaction was not successful");
                                        }
                                    } else {
                                        player.sendMessage(ChatColor.RED + "You don't have enough balance to do this action");
                                    }
                                } else {
                                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.not-enough-bounty")));
                                }
                            } catch (NumberFormatException e) {
                                sender.sendMessage(ChatColor.RED + "The number you specified is invalid");
                            }
                        } else {
                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-offline")));
                        }
                    } else {
                        sender.sendMessage("This command can only be executed by a player");
                    }
                    return true;
                }
                case "top": {
                    Map<UUID, JsonPlayer> output = PluginUtils.sortByValue(main.getDataPool().getPlayers(), (first, second) -> Integer.compare(second.getValue().getBounty(), first.getValue().getBounty()));
                    int index = 1;
                    for (Map.Entry<UUID, JsonPlayer> entry : output.entrySet()) {
                        OfflinePlayer player = main.getServer().getOfflinePlayer(entry.getKey());
                        JsonPlayer wrapper = entry.getValue();
                        if (player == null || wrapper == null) continue;
                        sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.bounty-top-entry")
                                .replace("%pos%", String.valueOf(index))
                                .replace("%bounty%", String.valueOf(wrapper.getBounty()))
                                .replace("%player%", player.getName())
                        ));
                        if (++index >= 10) {
                            return true;
                        }
                    }
                    if (index != 10) {
                        sender.sendMessage(ChatColor.RED + "These results may not be complete");
                    }
                    return true;
                }
                default: {
                    if (args.length == 1) {
                        String name = args[0];
                        Player target = main.getServer().getPlayer(name);
                        if (target != null) {
                            JsonPlayer wrapper = main.getDataPool().getPlayers().get(target.getUniqueId());
                            sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-bounty-other")
                                    .replace("%player%", name)
                                    .replace("%bounty%", String.valueOf(wrapper.getBounty()))
                            ));
                        } else {
                            sender.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-offline")));
                        }
                        return true;
                    }
                }
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                JsonPlayer wrapper = main.getDataPool().getPlayers().get(player.getUniqueId());
                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-bounty")
                        .replace("%bounty%", String.valueOf(wrapper.getBounty()))
                ));
            }
            return true;
        }
        Messager.send(sender, "&b/bounty [player] &7- &cShows the bounty of that player");
        Messager.send(sender, "&b/bounty add <player> <amount> &7- &cAdds bounty to a player");
        Messager.send(sender, "&b/bounty top &7- &cShows the top ten players with most bounty of the server");
        return true;
    }
}
