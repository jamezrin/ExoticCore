package me.jaime29010.work.exoticcore.listeners;

import me.jaime29010.work.exoticcore.Main;
import me.jaime29010.work.exoticcore.data.JsonLocation;
import me.jaime29010.work.exoticcore.data.JsonSpawner;
import me.jaime29010.work.exoticcore.manager.server.EntityDespawnEvent;
import me.jaime29010.work.exoticcore.manager.server.EntityDespawnEvent.DespawnCause;
import me.jaime29010.work.exoticcore.utils.SkullType;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;

public class EntityListener implements Listener {
    private final Main main;

    public EntityListener(Main main) {
        this.main = main;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(SpawnerSpawnEvent event) {
        Entity entity = event.getEntity();
        CreatureSpawner spawner = event.getSpawner();
        JsonSpawner wrapper = main.getDataPool().getSpawners().get(new JsonLocation(
                spawner.getWorld().getName(),
                spawner.getX(),
                spawner.getY(),
                spawner.getZ()
        ));
        if (wrapper != null) {
            if (wrapper.getFuelMillis() > 0) {
                wrapper.getEntities().add(entity.getUniqueId());
            } else {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void on(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        for (JsonSpawner wrapper : main.getDataPool().getSpawners().values()) {
            if (wrapper.getEntities().contains(entity.getUniqueId())) {
                event.getDrops().clear();
                event.getDrops().add(SkullType.from(event.getEntityType()).getItemStack());
                double exp = event.getDroppedExp();
                switch (wrapper.getTier()) {
                    case 2: {
                        exp = exp * 1.2;
                        break;
                    }
                    case 3: {
                        exp = exp * 1.5;
                        break;
                    }
                    case 4: {
                        exp = exp * 2;
                        break;
                    }
                    case 5: {
                        exp = exp * 2.5;
                        break;
                    }
                }
                event.setDroppedExp((int) exp);
                wrapper.getEntities().remove(entity.getUniqueId());
                break;
            }
        }
    }

    @EventHandler
    public void on(EntityDespawnEvent event) {
        if (event.getCause() == DespawnCause.SERVER) {
            Entity entity = event.getEntity();
            for (JsonSpawner wrapper : main.getDataPool().getSpawners().values()) {
                if (wrapper.getEntities().remove(entity.getUniqueId())) {
                    break;
                }
            }
        }
    }
}
