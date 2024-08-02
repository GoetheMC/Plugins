package de.saloking.paintBallPlugin.Event;

import de.saloking.paintBallPlugin.Items.DefaultItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        //Keine Drops bei Tod
        List<ItemStack> list = e.getDrops();
        for(ItemStack i : list) {
            e.getDrops().remove(i);
        }
    }
}
