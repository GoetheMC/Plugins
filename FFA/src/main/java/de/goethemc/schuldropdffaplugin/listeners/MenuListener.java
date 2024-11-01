package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListener implements Listener {

    private final Map<Player, Particle> playerParticleSelections = new HashMap<>();

    private final SchulDropDffaPlugin plugin;
    public MenuListener(SchulDropDffaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(!p.hasPermission("inventory.use")){
            e.setCancelled(true);
        }
        if(!p.getGameMode().equals(GameMode.CREATIVE)) {
            e.setCancelled(true);
        }
        //Kit Selector

    }


}


