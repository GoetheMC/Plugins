package de.goethemc.schuldropdffaplugin.listeners;

import com.sun.tools.javac.Main;
import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnIsland;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DisablePvpOnSpawnListener implements Listener {
    PvpTag taggerino = new PvpTag();
    String tag = taggerino.getTag();
    private final SpawnIsland spawnIsland;
    public DisablePvpOnSpawnListener(SchulDropDffaPlugin plugin){
        this.spawnIsland = new SpawnIsland(plugin);
    }

    @EventHandler
    public void onPVP(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Player p){
            if(spawnIsland.isSpawnIsland(p.getLocation().getX(),p.getLocation().getY(),p.getLocation().getZ())){
                e.setCancelled(true);
                p.sendMessage(tag + ChatColor.RED+"Kämpfen, darf man nur unten in der Arena!");
            }
        }
    }
}
