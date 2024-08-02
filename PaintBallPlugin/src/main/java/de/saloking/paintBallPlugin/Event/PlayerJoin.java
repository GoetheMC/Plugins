package de.saloking.paintBallPlugin.Event;

import de.saloking.paintBallPlugin.Items.DefaultItems;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerJoin implements Listener {

    DefaultItems inv = new DefaultItems();
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        //Inventar setzen
        inv.setInv(p);
        //
        p.performCommand("openscoreboard");


    }
}
