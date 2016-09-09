package me.jaime29010.work.exoticcore.data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class JsonSpawner {
    private long fuel;
    private int tier;
    private List<UUID> entities;

    public JsonSpawner(long fuel, int tier) {
        this.fuel = fuel;
        this.tier = tier;
        this.entities = new ArrayList<>();
    }

    public long getFuelMillis() {
        return fuel;
    }

    public double getFuelHours() {
        return (int) Math.ceil(fuel / 3600);
    }

    public void setFuel(long fuel) {
        this.fuel = fuel;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        if (tier < 1) fuel = 1;
        this.tier = tier;
    }

    public List<UUID> getEntities() {
        return entities;
    }
}
