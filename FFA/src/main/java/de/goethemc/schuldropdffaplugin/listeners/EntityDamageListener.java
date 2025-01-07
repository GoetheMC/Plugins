package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnIsland;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageListener implements Listener {

    private final SchulFFA ffa;

    public EntityDamageListener(SchulFFA ffa){
        this.ffa = ffa;
    }

    @EventHandler
    public void onPVP(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player p){
            if(ffa.getSpawnIsland().isSpawnIsland(p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ())){
                e.setCancelled(true);
                p.sendMessage(ffa.getTag() + ChatColor.RED+"Kämpfen, darf man nur unten in der Arena!");
            }
        }
    }
}
