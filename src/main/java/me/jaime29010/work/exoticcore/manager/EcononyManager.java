package me.jaime29010.work.exoticcore.manager;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public class EcononyManager {
    private static Economy economy;
    static {
        RegisteredServiceProvider<Economy> service = Bukkit.getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        economy = service.getProvider();
    }

    public static Economy getEconomy() {
        return economy;
    }
}
