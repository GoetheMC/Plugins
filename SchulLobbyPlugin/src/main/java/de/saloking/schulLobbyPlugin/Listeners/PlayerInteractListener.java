package de.saloking.schulLobbyPlugin.Listeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PlayerInteractListener implements Listener {


    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){


        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(!p.hasPermission("interact.use") && !p.hasPermission("build.use")) {
                if (e.getClickedBlock().getType() != Material.DARK_OAK_BUTTON) {
                    //p.sendMessage("funzt");
                    e.setCancelled(true);
                }
            }
        }

        if(e.getAction().isRightClick()){
            //Menü Leiste das in HotBar
            if(e.getItem() == null) return;

            if(e.getItem().getType() == Material.COMPASS){
                p.performCommand("openMenu");
            }
            else if(e.getItem().getType() == Material.LIME_DYE){
                Inventory playerInv = p.getInventory();

                ItemStack grayDye = new ItemStack(Material.GRAY_DYE);
                ItemMeta graYDyeMeta = grayDye.getItemMeta();
                graYDyeMeta.setDisplayName(org.bukkit.ChatColor.GRAY+""+ ChatColor.BOLD+"Spielersichtbarkeit:"+ChatColor.RED+" AUS");
                graYDyeMeta.setLore(List.of(ChatColor.GRAY+"Stelle die Spielersichtbarkeit ein"));
                grayDye.setItemMeta(graYDyeMeta);

                playerInv.setItem(6, grayDye);

                p.performCommand("hidePlayers");
            }else if(e.getItem().getType() == Material.GRAY_DYE){
                Inventory playerInv = p.getInventory();
                ItemStack limeDye = new ItemStack(Material.LIME_DYE);

                ItemMeta limeDyeMeta = limeDye.getItemMeta();
                limeDyeMeta.setDisplayName(org.bukkit.ChatColor.GREEN+""+ChatColor.BOLD+"Spielersichtbarkeit: AN");
                limeDyeMeta.setLore(List.of(ChatColor.GREEN+"Stelle die Spielersichtbarkeit ein"));
                limeDye.setItemMeta(limeDyeMeta);

                playerInv.setItem(6, limeDye);

                p.performCommand("showPlayers");
            }
            else if(e.getItem().getType() == Material.BLAZE_POWDER){
                p.performCommand("partikel");
            }
        }
    }
}
