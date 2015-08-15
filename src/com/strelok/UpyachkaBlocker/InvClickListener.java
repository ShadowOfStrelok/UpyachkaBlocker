package com.strelok.UpyachkaBlocker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

/**
 * Created by Admin on 15.08.2015.
 */
public class InvClickListener implements Listener {

    List<Integer> restrictedItems;

    public InvClickListener(UpyachkaBlocker upchk){
        restrictedItems = upchk.getConfig().getIntegerList("BanItems");
    }

    @EventHandler
    public void clickListner(InventoryClickEvent event){
        if(event.getCurrentItem() != null){
            if(!event.getWhoClicked().hasPermission("upyachka.blocker.fuckthepolisy") && restrictedItems.contains(event.getCurrentItem().getTypeId())){
                event.setCancelled(true);
                event.getInventory().removeItem(event.getCurrentItem());
                event.getInventory().removeItem(event.getCursor());
                ((Player)(event.getWhoClicked())).sendMessage(""+event.getCursor().getTypeId());
                ((Player)(event.getWhoClicked())).sendMessage(""+event.getCurrentItem().getTypeId());
            }
        }

    }


}
