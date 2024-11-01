package de.goethemc.schuldropdffaplugin.listeners;


import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.Kits;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnIsland;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.checkerframework.checker.units.qual.K;
import org.w3c.dom.Entity;

public class DisableFallDamageListener implements Listener {
    PvpTag taggerino = new PvpTag();
    String tag = taggerino.getTag();
    private SchulDropDffaPlugin plugin;
    public DisableFallDamageListener(SchulDropDffaPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event){
        int minFallDistance = plugin.getConfig().getInt("minFallDistance");
        if (event.getEntity() instanceof Player player){
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getFallDistance() >= minFallDistance){
                    event.setCancelled(true);
                    player.playSound(player, Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR,0.1F,0.5F);
                    player.sendMessage(tag + ChatColor.GREEN + " Viel Erfolg in der Arena");
            }
        }
    }
}
