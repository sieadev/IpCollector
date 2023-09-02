package dev.siea.ipcollector;

import dev.siea.ipcollector.listeners.playerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class IpCollector extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new playerJoin(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
