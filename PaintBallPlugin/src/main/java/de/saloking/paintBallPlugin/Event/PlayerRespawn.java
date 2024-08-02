package de.saloking.paintBallPlugin.Event;

import de.saloking.paintBallPlugin.Items.DefaultItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {
    DefaultItems inv = new DefaultItems();
    @EventHandler
    public void onRespawn(PlayerRespawnEvent e){
        inv.setInv(e.getPlayer());
    }
}
