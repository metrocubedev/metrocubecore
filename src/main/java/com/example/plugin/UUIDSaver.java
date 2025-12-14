package com.example.plugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class UUIDSaver extends JavaPlugin implements Listener {

    private File dataFolder;
    private Logger logger = getLogger();

    @Override
    public void onEnable() {
        // Create data folder if it doesn't exist
        dataFolder = new File(getDataFolder(), "uuid_data");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        
        // Register events
        getServer().getPluginManager().registerEvents(this, this);
        
        logger.info("UUIDSaver has been enabled! Data will be saved to: " + dataFolder.getAbsolutePath());
    }

    @Override
    public void onDisable() {
        logger.info("UUIDSaver has been disabled!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        String playerUuid = event.getPlayer().getUniqueId().toString();
        
        // Save to file
        savePlayerData(playerName, playerUuid);
    }

    private void savePlayerData(String playerName, String playerUuid) {
        try {
            File playerFile = new File(dataFolder, playerName + ".txt");
            
            // Write UUID and nickname to the file
            FileWriter writer = new FileWriter(playerFile);
            writer.write("Nickname: " + playerName + "\n");
            writer.write("UUID: " + playerUuid + "\n");
            writer.close();
            
            logger.info("Saved player data: " + playerName + " (" + playerUuid + ")");
        } catch (IOException e) {
            logger.severe("Could not save player data for " + playerName + ": " + e.getMessage());
        }
    }
}