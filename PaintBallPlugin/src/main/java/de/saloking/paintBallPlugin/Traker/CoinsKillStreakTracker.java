package de.saloking.paintBallPlugin.Traker;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CoinsKillStreakTracker implements Listener {

    private HashMap<UUID,Integer> coins = new HashMap<>();
    private HashMap<UUID,Integer> killstreak = new HashMap<>();

    @EventHandler
    public void onPlayerDeath(EntityDeathEvent e){
        //Keine ItemDrops
        e.getDrops().clear();

        //Coins abziehen nach dem Tod
        Entity killed = e.getEntity();
        killstreak.put(killed.getUniqueId(),0);
            //Player killed = e.getPlayer();
        if(!coins.containsKey(killed.getUniqueId()) || coins.get(killed.getUniqueId()) < 50){
            coins.put(killed.getUniqueId(),0);
        }else{
            coins.put(killed.getUniqueId(),coins.get(killed.getUniqueId())-50);
        }

        if(e.getEntity() instanceof Player play){
            play.performCommand("openscoreboard");
        }
        //Coins hinzufügen nach einem Kill
        Player killer = e.getEntity().getKiller();
        if(killer != null){
            if(!coins.containsKey(killer.getUniqueId())){
                coins.put(killer.getUniqueId(),100);
                killstreak.put(killer.getUniqueId(),1);
            }else{
                coins.put(killer.getUniqueId(),coins.get(killer.getUniqueId())+100);
                killstreak.put(killer.getUniqueId(), killstreak.get(killer.getUniqueId())+1);
            }
            killer.performCommand("openscoreboard");
            killed.sendMessage("TEST: Du hast "+coins.get(killed.getUniqueId())+" Coins");
        }
    }

    //Scoreboard
    public HashMap<UUID, Integer> getCoins() {
        return coins;
    }

    public void setCoins(UUID id,Integer amount) {
        coins.put(id,amount);
    }

    public HashMap<UUID, Integer> getKillstreak() {
        return killstreak;
    }
}
