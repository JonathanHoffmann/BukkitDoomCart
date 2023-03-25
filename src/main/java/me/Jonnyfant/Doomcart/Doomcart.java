package me.Jonnyfant.Doomcart;

import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class Doomcart extends JavaPlugin {
    String pathKillDestroyedMinecart ="Kill people in minecarts that get destroyed?";
    @Override
    public void onEnable() {
        loadConfig();
        getServer().getPluginManager().registerEvents(new ExitDoomcartListener(), this);

        if(getConfig().getBoolean(pathKillDestroyedMinecart));
        {
            getServer().getPluginManager().registerEvents(new KillOnDestroyedMinecartListener(), this);
        }
    }

    public void loadConfig() {
        getConfig().addDefault(pathKillDestroyedMinecart, false);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
