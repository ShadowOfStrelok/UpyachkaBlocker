package com.strelok.UpyachkaBlocker;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by Admin on 12.08.2015.
 */
public class UpyachkaBlocker extends JavaPlugin {

    @Override
    public void onEnable(){
        Bukkit.getServer().getLogger().info("GSOM GSOM!1");
        this.saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new PickUpListener(this), this);
    }



    @Override
    public void onDisable(){

    }

}
