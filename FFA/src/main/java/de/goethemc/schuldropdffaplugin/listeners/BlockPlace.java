package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockPlace implements Listener {

    private SchulFFA plugin;

    public BlockPlace(SchulFFA plugin){
        this.plugin = plugin;
    }
    @EventHandler
    public void bukcetEmpty(PlayerBucketEmptyEvent e){
        Location loc = e.getBlock().getLocation();

        new BukkitRunnable() {
            @Override
            public void run() {
                //Bukkit.getConsoleSender().sendMessage("BlockPlaced: " + loc.getBlock().getType());
                replaceBlock(loc.getBlock());
            }
        }.runTaskLater(plugin, 1);

    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Block block = e.getBlockPlaced();

        if(e.getPlayer().getGameMode() != GameMode.CREATIVE)
            replaceBlock(block);
    }
    @EventHandler
    public void blockForm(BlockFromToEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void blockFormE(BlockFormEvent e){
        //Bukkit.getConsoleSender().sendMessage(e.getBlock()+"");
        replaceBlock(e.getBlock());
        new BukkitRunnable() {
            @Override
            public void run() {
                replaceBlock(e.getBlock());
            }
        }.runTaskLater(plugin, 1);
    }

    public void replaceBlock(Block block){
        Location loc = block.getLocation();
        Material blockType = block.getType();

        new BukkitRunnable(){
            @Override
            public void run(){
                replaceBlockk(blockType, loc);
            }
        }.runTaskLater(plugin, 20*10);
    }

    public void replaceBlockk(Material block, Location location){
        if(location.getBlock().getType() == block){
            location.getBlock().setType(Material.REDSTONE_BLOCK);
            new BukkitRunnable(){
                @Override
                public void run(){
                    location.getBlock().setType(Material.AIR);
                }
            }.runTaskLater(plugin, 20);
        }else{
            //Bukkit.getConsoleSender().sendMessage("Nicht gleich! ");
        }
    }
}
