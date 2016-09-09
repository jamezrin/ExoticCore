package me.jaime29010.work.exoticcore.data;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class JsonDataPool {
    private final Map<JsonLocation, JsonSpawner> spawners;
    private final Map<UUID, JsonPlayer> players;
    private final Map<String, JsonLocation> shops;
    private final Map<UUID, JsonBooster> boosters; //null key is the global booster

    public JsonDataPool() {
        spawners = new HashMap<>();
        players = new HashMap<>();
        shops = new HashMap<>();
        boosters = new HashMap<>();
    }

    public Map<JsonLocation, JsonSpawner> getSpawners() {
        synchronized (spawners) {
            return spawners;
        }
    }

    public Map<UUID, JsonPlayer> getPlayers() {
        return players;
    }

    public Map<String, JsonLocation> getShops() {
        return shops;
    }

    public Map<UUID, JsonBooster> getBoosters() {
        synchronized (boosters) {
            return boosters;
        }
    }
}
