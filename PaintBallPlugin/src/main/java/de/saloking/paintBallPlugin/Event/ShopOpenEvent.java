package de.saloking.paintBallPlugin.Event;

import de.saloking.paintBallPlugin.Items.Waffen;
import de.saloking.paintBallPlugin.Traker.CoinsKillStreakTracker;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ShopOpenEvent implements Listener {
    Waffen waffe = new Waffen();
    CoinsKillStreakTracker tracker;
    public ShopOpenEvent(CoinsKillStreakTracker tracker) {
        this.tracker = tracker;
    }

    @EventHandler
    public void onInventoryClick(PlayerInteractEvent e){
        Player p  = e.getPlayer();
        if(e.getItem().getType() == Material.EMERALD){
            p.performCommand("openshop");
        }
    }
    @EventHandler
    public void onShopClock(InventoryClickEvent e){
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equals(ChatColor.GREEN+"Shop")){
            switch (e.getCurrentItem().getType()){
                case GOLDEN_HOE:
                    if(tracker.getCoins().get(p.getUniqueId()) >= 500){
                        p.getInventory().setItem(0,waffe.getPumpGun());
                        tracker.setCoins(p.getUniqueId(),tracker.getCoins().get(p.getUniqueId())-500);
                        p.sendMessage(ChatColor.GREEN+"Du hast dir einen Pump-Gun gekauft");
                    }else{
                        int fehledeneCoins = 500-tracker.getCoins().get(p.getUniqueId());
                        p.sendMessage(ChatColor.RED+"Du haste nicht genügend Coins. Um dies zu kaufen brauchst du noch "+ChatColor.GREEN+""+ fehledeneCoins +" Coins!");
                    }
                    break;
                case NETHERITE_HOE:
                    if(tracker.getCoins().get(p.getUniqueId()) >= 1000){
                        p.getInventory().setItem(0,waffe.getMiniGun());
                        tracker.setCoins(p.getUniqueId(),tracker.getCoins().get(p.getUniqueId())-1000);
                        p.sendMessage(ChatColor.GREEN+"Du hast dir einen Mini-Gun gekauft");
                    }else{
                        int fehledeneCoins = 1000-tracker.getCoins().get(p.getUniqueId());
                        p.sendMessage(ChatColor.RED+"Du haste nicht genügend Coins. Um dies zu kaufen brauchst du noch "+ChatColor.GREEN+""+ fehledeneCoins +" Coins!");
                    }
                    break;
                case DIAMOND_HOE:
                    if(tracker.getCoins().get(p.getUniqueId()) >= 750){
                        p.getInventory().setItem(0,waffe.getSniper());
                        tracker.setCoins(p.getUniqueId(),tracker.getCoins().get(p.getUniqueId())-750);
                        p.sendMessage(ChatColor.GREEN+"Du hast dir einen Sniper gekauft");
                    }else{
                        int fehledeneCoins = 750-tracker.getCoins().get(p.getUniqueId());
                        p.sendMessage(ChatColor.RED+"Du haste nicht genügend Coins. Um dies zu kaufen brauchst du noch "+ChatColor.GREEN+""+ fehledeneCoins +" Coins!");
                    }
                    break;
                case EGG:
                    if(tracker.getCoins().get(p.getUniqueId()) >= 250){
                        p.getInventory().setItem(1,waffe.getHandGrante());
                        tracker.setCoins(p.getUniqueId(),tracker.getCoins().get(p.getUniqueId())-250);
                        p.sendMessage(ChatColor.GREEN+"Du hast dir einen Hand-Granate gekauft");
                    }else{
                        int fehledeneCoins = 250-tracker.getCoins().get(p.getUniqueId());
                        p.sendMessage(ChatColor.RED+"Du haste nicht genügend Coins. Um dies zu kaufen brauchst du noch "+ChatColor.GREEN+""+ fehledeneCoins +" Coins!");
                    }
                    break;
            }
            p.performCommand("openscoreboard");
        }
    }
}
