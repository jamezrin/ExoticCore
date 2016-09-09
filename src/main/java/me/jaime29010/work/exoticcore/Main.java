package me.jaime29010.work.exoticcore;

import be.maximvdw.placeholderapi.PlaceholderAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.stream.JsonReader;
import me.jaime29010.work.exoticcore.commands.*;
import me.jaime29010.work.exoticcore.data.JsonDataPool;
import me.jaime29010.work.exoticcore.data.JsonPlayer;
import me.jaime29010.work.exoticcore.listeners.EntityListener;
import me.jaime29010.work.exoticcore.listeners.PlayerListener;
import me.jaime29010.work.exoticcore.ui.ShopUI;
import me.jaime29010.work.exoticcore.ui.SpawnerUI;
import me.jaime29010.work.exoticcore.utils.BoosterManager;
import me.jaime29010.work.exoticcore.utils.ConfigurationManager;
import me.jaime29010.work.exoticcore.utils.server.WorldHelper;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.*;
import java.util.UUID;

public final class Main extends JavaPlugin {
    public static int SAVE_INTERVAL = 10;
    private FileConfiguration config;
    private JsonDataPool database;
    private BoosterManager manager;
    private Economy economy;
    private Gson gson;

    @Override
    public void onEnable() {
        //Loading config
        config = ConfigurationManager.loadConfig("config.yml", this);

        //Loading economy
        RegisteredServiceProvider<Economy> service = getServer().getServicesManager().getRegistration(Economy.class);
        economy = service.getProvider();

        //Setting up gson
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.enableComplexMapKeySerialization();

        //fix for map key that is null
        builder.registerTypeAdapter(UUID.class, (JsonDeserializer<UUID>) (element, type, context) -> {
            if (element.isJsonNull() || element.getAsString().equals("null")) {
                return null;
            }

            return UUID.fromString(element.getAsString());
        });
        gson = builder.create();

        //Loading database
        File file = new File(getDataFolder(), "data.json");
        if (file.exists()) {
            getLogger().info("Database exists, reading data...");
            try (JsonReader reader = new JsonReader(new FileReader(file))) {
                database = gson.fromJson(reader, JsonDataPool.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            getLogger().fine("Database does not exist, it will be created on server shutdown");
            database = new JsonDataPool();
        }


        //Database save task
        getLogger().info(String.format("The database will be saved every %s minutes", SAVE_INTERVAL));
        new BukkitRunnable() {
            @Override
            public void run() {
                getLogger().info("Periodically saving database...");
                saveDatabase();
            }
        }.runTaskTimerAsynchronously(this, SAVE_INTERVAL * 60 * 20, SAVE_INTERVAL * 60 * 20);

        //Spawner timer task
        new BukkitRunnable() {
            @Override
            public void run() {
                database.getSpawners().values().forEach(wrapper -> {
                    long fuel = wrapper.getFuelMillis();
                    if (fuel > 0) {
                        wrapper.setFuel(--fuel);
                    }
                });
            }
        }.runTaskTimerAsynchronously(this, 0, 20);

        //Loading placeholder
        if (getServer().getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")) {
            getLogger().info("PlaceholderAPI has been found, registering the placeholder...");
            PlaceholderAPI.registerPlaceholder(this, "exotic_level", event -> {
                if (event.isOnline()) {
                    JsonPlayer wrapper = database.getPlayers().get(event.getPlayer().getUniqueId());
                    return Integer.toString(wrapper.getLevel());
                }
                return "Unknown";
            });
        }

        //Register user interfaces
        SpawnerUI.init(this);
        ShopUI.init(this);

        //Setup booster manager
        manager = new BoosterManager(this);

        //Register world helper
        new WorldHelper(this);

        //Registering events
        getServer().getPluginManager().registerEvents(new EntityListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        //Registering commands
        getCommand("exoticcore").setExecutor(new MainCommand(this));
        getCommand("levelup").setExecutor(new LevelUpCommand(this));
        getCommand("points").setExecutor(new PointsCommand(this));
        getCommand("level").setExecutor(new LevelCommand(this));
        getCommand("booster").setExecutor(new BoosterCommand(this));
    }

    @Override
    public void onDisable() {
        getServer().getScheduler().cancelTasks(this);
        if (database != null) {
            getLogger().info("Saving database...");
            saveDatabase();
        } else {
            getLogger().info("Database is null, not saving database...");
        }
    }

    private void saveDatabase() {
        try (Writer writer = new FileWriter(new File(getDataFolder(), "data.json"))) {
            String output = gson.toJson(database, JsonDataPool.class);
            writer.write(output);
        } catch (IOException e) {
            getLogger().severe("Something went terribly wrong, couldn't save the database");
            e.printStackTrace();
        }
    }

    public boolean canEntity(EntityType type, Player player) {
        JsonPlayer wrapper = database.getPlayers().get(player.getUniqueId());
        for (int index = wrapper.getLevel(); index >= 1; index--) {
            if (config.getString("levels" + "." + index + "." + "type").equals(type.name())) {
                return true;
            }
        }
        return false;
    }

    public int getHeadPrice(EntityType type) {
        String path = "prices.types" + "." + type.name();
        if (config.isInt(path)) {
            return config.getInt(path);
        }
        return config.getInt("prices.default");
    }

    public String getAlias(EntityType type) {
        return config.getString("alias" + "." + type.name());
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public JsonDataPool getDataPool() {
        return database;
    }

    public BoosterManager getBoosterManager() {
        return manager;
    }

    public Economy getEconomy() {
        return economy;
    }
}
