package de.saloking.schulLobbyPlugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayDropItemListener implements Listener {
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e){

        Player p = (Player) e.getPlayer();
        if(!p.hasPermission("inventory.use")){
            e.setCancelled(true);
            p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.RED + "Du darfst keine Items droppen!");
        }
        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
            p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.RED + "Du darfst keine Items droppen!");
        }

    }
}
