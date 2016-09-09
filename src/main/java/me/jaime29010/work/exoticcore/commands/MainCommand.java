package me.jaime29010.work.exoticcore.commands;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonLocation;
import me.jaime29010.work.exoticcore.utils.Messager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.util.Set;

public class MainCommand implements CommandExecutor {
    private final Main main;

    public MainCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0) {
            switch (args[0].toLowerCase()) {
                case "addshop": {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        if (args.length == 2) {
                            String name = args[1];
                            Block block = player.getTargetBlock((Set<Material>) null, 5);
                            if (block != null && block.getType() == Material.ENDER_CHEST) {
                                JsonLocation location = new JsonLocation(
                                        block.getWorld().getName(),
                                        block.getX(),
                                        block.getY(),
                                        block.getZ()
                                );

                                if (main.getDataPool().getShops().containsKey(name)) {
                                    player.sendMessage(ChatColor.RED + "An shop with that name already exists");
                                    return true;
                                }

                                if (main.getDataPool().getShops().containsValue(location)) {
                                    player.sendMessage(ChatColor.RED + "That block is already an shop");
                                    return true;
                                }

                                main.getDataPool().getShops().put(name, location);
                                player.sendMessage(ChatColor.GREEN + "Successfully added the shop");
                            } else {
                                player.sendMessage(ChatColor.RED + "You are not looking at an enderchest");
                            }
                        } else break;
                    } else {
                        sender.sendMessage("This command can only be executed by a player");
                    }
                    return true;
                }

                case "removeshop": {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        if (args.length == 2) {
                            String name = args[1];
                            if (main.getDataPool().getShops().remove(name) != null) {
                                player.sendMessage(ChatColor.GREEN + String.format("Successfully removed the shop named %s", name));
                            } else {
                                player.sendMessage(ChatColor.RED + String.format("There is no shop named %s", name));
                            }
                        } else break;
                    } else {
                        sender.sendMessage("This command can only executed by a player");
                    }
                    return true;
                }

                case "listshops": {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        main.getDataPool().getShops().forEach((name, wrapper) -> {
                            player.sendMessage(Messager.colorize(main.getConfig().getString("messages.shop-entry")
                                    .replace("%name%", name)
                                    .replace("%x%", String.valueOf(wrapper.getX()))
                                    .replace("%y%", String.valueOf(wrapper.getY()))
                                    .replace("%z%", String.valueOf(wrapper.getZ()))
                            ));
                        });
                    } else {
                        sender.sendMessage("This command can only executed by a player");
                    }
                    return true;
                }

                case "give": {
                    if (sender instanceof Player) {
                        if (args.length >= 3) {
                            Player target = main.getServer().getPlayer(args[1]);
                            if (target != null) {
                                try {
                                    EntityType type = EntityType.valueOf(args[2]);
                                    int amount = 1;
                                    if (args.length == 4) {
                                        try {
                                            amount = Integer.parseInt(args[3]);
                                        } catch (NumberFormatException e) {
                                            sender.sendMessage(ChatColor.RED + "The number you specified is invalid");
                                        }
                                    }

                                    ItemStack item = new ItemStack(Material.MOB_SPAWNER);
                                    item.setAmount(amount);
                                    BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
                                    CreatureSpawner state = (CreatureSpawner) meta.getBlockState();
                                    state.setSpawnedType(type);
                                    meta.setBlockState(state);
                                    item.setItemMeta(meta);
                                    target.getInventory().addItem(item);

                                    target.sendMessage(ChatColor.GREEN + String.format("You gave %s an spawner of type %s", target.getName(), type.name()));
                                } catch (IllegalArgumentException e) {
                                    sender.sendMessage(ChatColor.RED + "The type you specified is invalid");
                                }
                            } else {
                                sender.sendMessage(ChatColor.RED + "The player you specified is not online");
                            }
                        } else break;
                    } else {
                        sender.sendMessage("This command can only executed by a player");
                    }
                    return true;
                }
            }
        }

        if (sender instanceof Player) {
            Messager.send(sender,
                    "&e=====================================================",
                    "&7Commands for ExoticCore:",
                    "&3/.. addshop <id> &7- &cCreate a shop with the ender chest you are looking at",
                    "&3/.. removeshop <id> &7- &cRemove the shop with the name specified",
                    "&3/.. listshops &7- &cLists all the shops created",
                    "&3/.. give <player> <type> [amount] &7- &cGive a specific type of spawner to a player",
                    "&e=====================================================");
        } else {
            sender.sendMessage(ChatColor.RED + "You are not eligible to use this command");
        }
        return true;
    }
}
