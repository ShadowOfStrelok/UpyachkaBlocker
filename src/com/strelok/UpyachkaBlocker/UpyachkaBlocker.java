package com.strelok.UpyachkaBlocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * The main UpyachkaBlocker Class
 */
public class UpyachkaBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getServer().getLogger().info("GSOM GSOM!1");
        this.saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new PickUpListener(this), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InvClickListener(this), this);
    }


    @Override
    public void onDisable() {

    }

}
