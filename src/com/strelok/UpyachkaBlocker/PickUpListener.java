package com.strelok.UpyachkaBlocker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.util.List;

/**
 * Listener which checks pickings from ground.
 */
public class PickUpListener implements Listener {

    List<Integer> restrictedItems;

    public PickUpListener(UpyachkaBlocker upchk) {
        restrictedItems = upchk.getConfig().getIntegerList("BanItems");
    }

    @EventHandler
    public void pickUpThing(PlayerPickupItemEvent e) {
        if (!e.getPlayer().hasPermission("upyachka.blocker.fuckthepolisy") && restrictedItems.contains(e.getItem().getItemStack().getTypeId())) {
            e.getPlayer().sendMessage("You tried to pick up zashkvared item #" + e.getItem().getItemStack().getTypeId() + " but it is forbidden, so item is deleted.");
            e.setCancelled(true);
            e.getItem().remove();
            //e.getItem().getItemStack().setAmount(0);
        }
    }
}
