package de.saloking.schulLobbyPlugin.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e){
        e.setCancelled(true);
    }
}
