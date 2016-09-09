package me.jaime29010.work.exoticcore.data;

import org.bukkit.command.CommandSender;

public final class JsonBooster {
    private final String owner;
    private final int multiplier;
    private long time;
    private boolean active;

    public JsonBooster(CommandSender owner, int multiplier, int minutes) {
        this.owner = owner.getName();
        this.multiplier = multiplier;
        this.time = minutes * 60;
        this.active = true;
    }

    public String getOwner() {
        return owner;
    }

    public long getSecondsRemaining() {
        return time;
    }

    public int getMinutesRemaining() {
        return (int) Math.ceil(time / 60);
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
