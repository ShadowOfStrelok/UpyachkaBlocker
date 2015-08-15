package com.strelok.UpyachkaBlocker;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

/**
 * Listener which encounters and processes inventory picks of either player or chest inventory.
 */
public class InvClickListener implements Listener {

    List<Integer> restrictedItems;

    public InvClickListener(UpyachkaBlocker upchk) {
        restrictedItems = upchk.getConfig().getIntegerList("BanItems");
    }

    @EventHandler
    public void clickListener(InventoryClickEvent event) {
        if (event.getCurrentItem() != null) {
            if (!event.getWhoClicked().hasPermission("upyachka.blocker.fuckthepolisy") && restrictedItems.contains(event.getCurrentItem().getTypeId())) {
                event.setCancelled(true);
                int nm = event.getCurrentItem().getTypeId();
                boolean isPlayer = event.getInventory().getHolder() instanceof Player;
                if (isPlayer) { //For some reason, getInventory() returns inventory.crafting on player's inventory, but not player's inventory itself
                    event.getWhoClicked().getInventory().remove(event.getCurrentItem().getTypeId()); //here we get player's inventory explicitly
                } else
                    event.getInventory().remove(event.getCurrentItem().getTypeId()); //if not player's, an inventory is got normally
                if (isPlayer) {
                    ((Player) (event.getWhoClicked())).sendMessage("You have clicked on a zashkvared item #" + nm + " which is forbidden. Not to make you an opushenny one, we have deleted it from ur inventory");
                }
            }
        }

    }
}
