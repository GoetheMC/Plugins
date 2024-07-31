package de.saloking.schulLobbyPlugin.Listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;

public class InventoryDragListener implements Listener {

    @EventHandler
    public void inventoryDragEvent(InventoryDragEvent e){
        Player p = (Player) e.getWhoClicked();

        if(!p.hasPermission("inventory.use")){
            e.setCancelled(true);
        }
        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
        }
    }
}
