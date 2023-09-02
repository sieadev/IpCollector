package dev.siea.ipcollector.listeners;

import dev.siea.ipcollector.util.ConfigUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class playerJoin implements Listener {

    private final Plugin plugin;

    public playerJoin(Plugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // Get the player's UUID
        String uuid = p.getUniqueId().toString();

        // Get today's date
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");

        // Get the player's IP address
        String ip = String.valueOf(p.getAddress().getAddress());

        // Save the Data
        ConfigUtil config = new ConfigUtil(plugin, "ips.yml");
        config.getConfig().set(uuid + "." + format.format(now), ip);
        config.save();
    }
}
