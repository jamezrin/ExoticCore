package me.jaime29010.work.exoticcore.commands;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonPlayer;
import me.jaime29010.work.exoticcore.manager.ExperienceManager;
import me.jaime29010.work.exoticcore.utils.Messager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelUpCommand implements CommandExecutor {
    private final Main main;

    public LevelUpCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            JsonPlayer wrapper = main.getDataPool().getPlayers().get(player.getUniqueId());
            int level = wrapper.getLevel();
            if (level == 18) {
                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.level-maxed")));
                return true;
            }

            int next = level + 1;
            int points = main.getConfig().getInt("levels" + "." + next + "." + "points");
            if (wrapper.getPoints() >= points) {
                int cost = main.getConfig().getInt("levels" + "." + next + "." + "exp");
                int exp = ExperienceManager.getTotalExperience(player);
                if (exp >= cost) {
                    ExperienceManager.setTotalExperience(player, exp - cost);
                    wrapper.setPoints(wrapper.getPoints() - points);
                    wrapper.setLevel(next);
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.level-upgrade")
                            .replace("%level%", String.valueOf(wrapper.getLevel()))
                    ));
                } else {
                    player.sendMessage(Messager.colorize(main.getConfig().getString("messages.required-exp")
                            .replace("%exp%", String.valueOf(cost))
                    ));
                }
            } else {
                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.required-points")
                        .replace("%points%", String.valueOf(points))
                ));
                return true;
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }
        return true;
    }
}
