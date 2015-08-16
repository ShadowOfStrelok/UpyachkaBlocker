package com.strelok.UpyachkaBlocker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

/**
 * Created by voldemarich on 16.08.15.
 */
public class InteractsListener implements Listener {

    List<Integer> restrictedItems;

    public InteractsListener(UpyachkaBlocker upchk) {
        restrictedItems = upchk.getConfig().getIntegerList("BanItems");
    }

    @EventHandler
    public void simpleInteract(PlayerInteractEvent e) {
        int nr = e.getPlayer().getItemInHand().getTypeId();
        if(restrictedItems.contains(nr)){
                e.setCancelled(true);
                e.getPlayer().getInventory().remove(nr);
        }
    }

    @EventHandler
    public void entityInteract(PlayerInteractEntityEvent e){
        int nr = e.getPlayer().getItemInHand().getTypeId();
        if(restrictedItems.contains(nr)){
            e.setCancelled(true);
            e.getPlayer().getInventory().remove(nr);
        }
    }
}
