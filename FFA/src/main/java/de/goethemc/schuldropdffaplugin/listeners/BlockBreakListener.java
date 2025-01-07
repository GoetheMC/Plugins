package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnIsland;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
public class BlockBreakListener implements Listener {
    private final SchulFFA ffa;

    public BlockBreakListener(SchulFFA ffa){
        this.ffa = ffa;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        if(ffa.getSpawnIsland().isSpawnIsland(player.getLocation().getX(),player.getLocation().getY(),player.getLocation().getZ())){

            e.setCancelled(true);
            player.sendMessage(ffa.getTag() + ChatColor.RED + "Du darfst hier keine Blöcke abbauen!");
        }
    }
}
