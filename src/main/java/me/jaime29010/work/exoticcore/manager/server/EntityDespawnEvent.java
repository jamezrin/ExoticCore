package me.jaime29010.work.exoticcore.manager.server;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EntityDespawnEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Entity entity;
    private final DespawnCause cause;

    public EntityDespawnEvent(Entity entity, DespawnCause cause) {
        this.entity = entity;
        this.cause = cause;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Entity getEntity() {
        return entity;
    }

    public EntityType getEntityType() {
        return entity.getType();
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public DespawnCause getCause() {
        return cause;
    }

    public enum DespawnCause {
        DEATH, SERVER
    }
}