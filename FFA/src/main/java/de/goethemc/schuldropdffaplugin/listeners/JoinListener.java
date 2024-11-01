package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnInv;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class JoinListener implements Listener {
    PvpTag taggerino = new PvpTag();
    SpawnInv inv = new SpawnInv();
    String tag = taggerino.getTag();

    private final SchulDropDffaPlugin plugin;
    public JoinListener(SchulDropDffaPlugin plugin){this.plugin = plugin;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        int xCord = plugin.getConfig().getInt("SpawnX");
        int yCord = plugin.getConfig().getInt("SpawnY");
        int zCord = plugin.getConfig().getInt("SpawnZ");

        Player player = event.getPlayer();
        //Teleport player
        player.teleport(new Location(player.getWorld(),xCord,yCord,zCord));
        //Set global Join-Message
        event.setJoinMessage(tag + ChatColor.GREEN + " >>> " +  ChatColor.GOLD + player.getName()  + ChatColor.GREEN + " hat den Server betreten! Hi! " );
        //Set "private" Join-Message
        player.sendMessage(tag + ChatColor.YELLOW + " Willkommen auf dem PVP-Server vom GGL!");

        player.sendTitle(ChatColor.YELLOW + "PVP", tag);
        player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, 1,1);

        Inventory inventory = player.getInventory();
        inventory.clear();
        //Set inventory
        inv.setPlayerInv(inventory);
    }

}
