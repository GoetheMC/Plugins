package de.saloking.schulLobbyPlugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (!p.hasPermission("build.use")) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.RED+"Du hast keine Berechtigung Blöcke zu platzieren!");
        }
    }
}
