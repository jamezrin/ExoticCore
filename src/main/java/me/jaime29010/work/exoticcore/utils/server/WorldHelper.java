package me.jaime29010.work.exoticcore.utils.server;

import me.jaime29010.work.exoticcore.Main;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldHelper implements Listener {
    private static final Map<World, WorldAccessor> worlds = new HashMap<>();
    private static Field list;

    static {
        try {
            Field field = net.minecraft.server.v1_8_R3.World.class.getDeclaredField("u");
            field.setAccessible(true);
            list = field;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final Main main;

    public WorldHelper(Main main) {
        this.main = main;
        main.getServer().getPluginManager().registerEvents(this, main);
    }

    public static void linkWorld(World world) {
        WorldAccessor accessor = new WorldAccessor();
        worlds.put(world, accessor);
        ((CraftWorld) world).getHandle().addIWorldAccess(accessor);
    }

    public static void unlinkWorld(World world) {
        try {
            ((List) list.get(((CraftWorld) world).getHandle())).remove(worlds.get(world));
            worlds.remove(world);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        EntityDespawnEvent target = new EntityDespawnEvent(event.getEntity(), EntityDespawnEvent.DespawnCause.DEATH);
        main.getServer().getPluginManager().callEvent(target);
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldLoad(WorldLoadEvent event) {
        linkWorld(event.getWorld());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldUnload(WorldUnloadEvent event) {
        unlinkWorld(event.getWorld());
    }

}
