package me.jaime29010.work.exoticcore.commands;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonPlayer;
import me.jaime29010.work.exoticcore.utils.Messager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand implements CommandExecutor {
    private final Main main;

    public LevelCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1) {
                String name = args[0];
                Player target = main.getServer().getPlayer(name);
                if (target != null) {
                    JsonPlayer wrapper = main.getDataPool().getPlayers().get(target.getUniqueId());
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-level-other")
                            .replace("%player%", name)
                            .replace("%level%", String.valueOf(wrapper.getLevel())
                            )));
                } else {
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-offline")));
                }
                return true;
            } else if (args.length == 0) {
                JsonPlayer wrapper = main.getDataPool().getPlayers().get(player.getUniqueId());
                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.player-level")
                        .replace("%level%", String.valueOf(wrapper.getLevel())
                        )));
                return true;
            }
            player.sendMessage(ChatColor.RED + "Usage: /level [player]");
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }
        return true;
    }
}
