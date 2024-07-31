package de.saloking.schulLobbyPlugin.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SignEvents implements Listener {

    @EventHandler
    public void onSignChange(SignChangeEvent e){
        if(e.getLine(0).equalsIgnoreCase("[secret]")){
            e.setLine(0,"");
            e.setLine(1, ChatColor.DARK_AQUA + ""+ChatColor.BOLD +"[SECRET]");
            e.setLine(2,ChatColor.RED+"---");
        }
    }
    @EventHandler
    public void onRightClick(PlayerInteractEvent e){

        if(e.getPlayer() instanceof Player p){
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock().getState() instanceof Sign s){
                if(s.getLine(1).equalsIgnoreCase(ChatColor.DARK_AQUA + ""+ChatColor.BOLD +"[SECRET]")){
                    p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.DARK_AQUA+""+ ChatColor.BOLD+"Herzlichen Glückwunsch!"+ChatColor.AQUA+ " du hast ein Secret gefunden.");
                }
            }
        }
    }
}
