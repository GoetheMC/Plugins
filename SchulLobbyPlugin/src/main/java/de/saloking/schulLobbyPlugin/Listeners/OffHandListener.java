package de.saloking.schulLobbyPlugin.Listeners;

import io.papermc.paper.event.player.PlayerArmSwingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OffHandListener implements Listener {

    @EventHandler
    public void onSwitchHand(PlayerArmSwingEvent e){
        e.setCancelled(true);
    }
}
