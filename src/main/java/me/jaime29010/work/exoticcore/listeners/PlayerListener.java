package me.jaime29010.work.exoticcore.listeners;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonLocation;
import me.jaime29010.work.exoticcore.data.JsonPlayer;
import me.jaime29010.work.exoticcore.data.JsonSpawner;
import me.jaime29010.work.exoticcore.ui.ShopUI;
import me.jaime29010.work.exoticcore.ui.SpawnerUI;
import me.jaime29010.work.exoticcore.utils.Messager;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

import java.util.Arrays;
import java.util.List;

public class PlayerListener implements Listener {
    private final Main main;

    public PlayerListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void on(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = event.getClickedBlock();
            if (block.getType() == Material.ENDER_CHEST) {
                if (main.getDataPool().getShops().containsValue(new JsonLocation(
                        block.getWorld().getName(),
                        block.getX(),
                        block.getY(),
                        block.getZ())
                )) {
                    event.setCancelled(true);
                    ShopUI.open(player, main);
                }
            } else if (block.getType() == Material.MOB_SPAWNER) {
                JsonLocation wrapper = new JsonLocation(
                        block.getWorld().getName(),
                        block.getX(),
                        block.getY(),
                        block.getZ());
                JsonSpawner spawner = main.getDataPool().getSpawners().get(wrapper);
                if (spawner == null) {
                    spawner = new JsonSpawner(86400, 1);
                    main.getDataPool().getSpawners().put(wrapper, spawner);
                }
                event.setCancelled(true);
                SpawnerUI.open(player, spawner, ((CreatureSpawner) block.getState()).getSpawnedType(), main);
            }
        }
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        main.getDataPool().getPlayers().putIfAbsent(player.getUniqueId(), new JsonPlayer(1, 0));
    }

    @EventHandler
    public void on(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location location = block.getLocation();
        if (block.getType() == Material.MOB_SPAWNER) {
            ItemStack item = event.getItemInHand();
            CreatureSpawner spawner = (CreatureSpawner) block.getState();
            if (main.canEntity(spawner.getSpawnedType(), player)) {
                JsonSpawner wrapper;
                if (item.getItemMeta().hasLore()) {
                    List<String> lore = item.getItemMeta().getLore();
                    int tier = Integer.valueOf(ChatColor.stripColor(lore.get(0).split("\\s+")[1]));
                    int fuel = Integer.valueOf(ChatColor.stripColor(lore.get(1).split("\\s+")[1]));
                    wrapper = new JsonSpawner(fuel * 1000, tier);
                } else {
                    wrapper = new JsonSpawner(86400, 1);
                }
                main.getDataPool().getSpawners().put(new JsonLocation(
                        location.getWorld().getName(),
                        location.getBlockX(),
                        location.getBlockY(),
                        location.getBlockZ()
                ), wrapper);
                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.spawner-placed")));
            } else {
                player.sendMessage(Messager.colorize(main.getConfig().getString("messages.spawner-denied")));
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void on(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (block.getType() == Material.MOB_SPAWNER) {
            JsonSpawner wrapper = main.getDataPool().getSpawners().remove(new JsonLocation(
                    block.getWorld().getName(),
                    block.getX(),
                    block.getY(),
                    block.getZ()
            ));

            if (player.getItemInHand().containsEnchantment(Enchantment.SILK_TOUCH)) {
                if (player.getGameMode() != GameMode.CREATIVE && wrapper != null) {
                    ItemStack item = new ItemStack(Material.MOB_SPAWNER);
                    BlockStateMeta meta = (BlockStateMeta) item.getItemMeta();
                    CreatureSpawner state = (CreatureSpawner) meta.getBlockState();
                    EntityType type = ((CreatureSpawner) block.getState()).getSpawnedType();
                    state.setSpawnedType(type);
                    meta.setBlockState(state);
                    meta.setLore(Arrays.asList(
                            ChatColor.RED + "Tier:" + " " + ChatColor.GRAY + wrapper.getTier(),
                            ChatColor.RED + "Fuel:" + " " + ChatColor.GRAY + wrapper.getFuelSeconds()));
                    meta.setDisplayName(Messager.colorize(main.getConfig().getString("messages.spawner-name")
                            .replace("%type%", main.getAlias(type))
                    ));
                    item.setItemMeta(meta);
                    block.getWorld().dropItemNaturally(block.getLocation(), item);
                }
            }
        }
    }
}
