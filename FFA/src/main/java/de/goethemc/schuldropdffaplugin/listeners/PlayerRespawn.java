package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {
    private final SchulFFA schulFFA;

    public PlayerRespawn(SchulFFA schulFFA){
        this.schulFFA = schulFFA;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event){
        Player player = event.getPlayer();
        Location loc = new Location(player.getWorld(), schulFFA.getSpawnX(),schulFFA.getSpawnY(),schulFFA.getSpawnZ());
        event.setRespawnLocation(loc);

        player.teleport(new Location(player.getWorld(),schulFFA.getSpawnX(),schulFFA.getSpawnY(),schulFFA.getSpawnZ()));

        player.getInventory().clear();
        schulFFA.getSpawnInv().setPlayerInv(player.getInventory());
        player.playSound(player, Sound.ENTITY_ELDER_GUARDIAN_DEATH,0.5F,0.1F);
    }

}
