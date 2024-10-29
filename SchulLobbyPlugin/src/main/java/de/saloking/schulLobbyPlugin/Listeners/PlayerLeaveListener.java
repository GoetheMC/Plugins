package de.saloking.schulLobbyPlugin.Listeners;

import de.saloking.schulLobbyPlugin.SchulLobbyPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener implements Listener {

    private final SchulLobbyPlugin plugin;
    public PlayerLeaveListener(SchulLobbyPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){

        String message = this.plugin.getConfig().getString("leave-message");
        if(message != null){
            message = message.replace("%Player%",e.getPlayer().getDisplayName());
            e.setQuitMessage(org.bukkit.ChatColor.GOLD+"[Lobby] "+ ChatColor.translateAlternateColorCodes('&',message));
        }
    }
}
