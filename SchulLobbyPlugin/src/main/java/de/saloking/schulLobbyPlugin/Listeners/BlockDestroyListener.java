package de.saloking.schulLobbyPlugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockDestroyListener implements Listener {

    @EventHandler
    public void onBlockDestroy(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!p.hasPermission("mine.use")){
            e.setCancelled(true);
            p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.RED+"Du darfst keine Blöcke abbauen!");
        }
    }
}
