package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;

public class PlayerJoinListener implements Listener {

    private final SchulFFA ffa;
    public PlayerJoinListener(SchulFFA ffa){this.ffa = ffa;}

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        player.teleport(ffa.getSpawnLocation(player));

        event.setJoinMessage(ffa.getTag() + ChatColor.GREEN + " >>> "
                +  ChatColor.GOLD + player.getName()  + ChatColor.GREEN + " hat den Server betreten! Hi! " );

        player.sendMessage(ffa.getTag() + ChatColor.YELLOW + " Willkommen auf dem PVP-Server vom GGL!");

        player.sendTitle(ChatColor.YELLOW + "PVP", ffa.getTag());
        player.playSound(player.getLocation(), Sound.BLOCK_BELL_USE, 1,1);

        Inventory inventory = player.getInventory();
        inventory.clear();

        ffa.getSpawnInv().setPlayerInv(inventory);
    }

}
