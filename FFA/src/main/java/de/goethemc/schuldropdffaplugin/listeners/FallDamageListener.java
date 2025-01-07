package de.goethemc.schuldropdffaplugin.listeners;


import de.goethemc.schuldropdffaplugin.SchulFFA;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamageListener implements Listener {
    private SchulFFA ffa;

    public FallDamageListener(SchulFFA ffa) {
        this.ffa = ffa;
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event) {

        if (!(event.getEntity() instanceof Player player)) return;

        if (event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getFallDistance() >= ffa.getMinFallDistance()) {

            event.setCancelled(true);

            player.playSound(player, Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, 0.1F, 0.5F);
            player.sendMessage(ffa.getTag() + ChatColor.GREEN + " Viel Erfolg in der Arena");
        }

    }
}
