package de.goethemc.schuldropdffaplugin.listeners;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!event.getAction().isRightClick() && event.getItem() == null) return;
        if (event.getItem().getType() != Material.MUSHROOM_STEW) return;

        double maxHealth = player.getMaxHealth();
        double currentHealth = player.getHealth();

        if (currentHealth < maxHealth) {
            event.setCancelled(true);

            if (maxHealth - currentHealth <= 7) {
                event.setCancelled(true);

                player.playSound(player, Sound.ENTITY_DOLPHIN_EAT, 1, 1);
                player.setHealth(maxHealth);
                player.setItemInHand(ItemStack.of(Material.BOWL));
            } else {

                player.playSound(player, Sound.ENTITY_DOLPHIN_EAT, 1, 1);
                player.setHealth(currentHealth + 7);
                player.setItemInHand(ItemStack.of(Material.BOWL));
            }
        }


    }
}
