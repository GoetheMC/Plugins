package de.saloking.schulLobbyPlugin.Listeners;

import de.saloking.schulLobbyPlugin.SchulLobbyPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Score;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PlayerJoinListener implements Listener {

    private final SchulLobbyPlugin plugin;
    public PlayerJoinListener(SchulLobbyPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){

        if(e.getPlayer() instanceof Player p){

            //Levelbar zum Jahr setzen
            SimpleDateFormat formatter1 = new SimpleDateFormat("MM");
            Date date1 = new Date();
            p.setExp(Integer.parseInt(formatter1.format(date1))/12f);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
            Date date = new Date();
            p.setLevel(Integer.parseInt(formatter.format(date)));
            //Spieler Nachtsicht geben
            PotionEffect nightVision = new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, Integer.MAX_VALUE, false, false);
            p.addPotionEffect(nightVision);
            //Zum Spawn Telportieren
            Location spawn = p.getWorld().getSpawnLocation();
            Location spawnPoint = new Location(p.getWorld(),spawn.getX(),spawn.getY()+0.5,spawn.getZ(),90, 0);
            p.teleport(spawnPoint);
            //Join Message
            String message = this.plugin.getConfig().getString("join-message");
            if(message != null){
                message = message.replace("%Player%",e.getPlayer().getDisplayName());
                e.setJoinMessage(org.bukkit.ChatColor.GOLD+"[Lobby] "+ChatColor.translateAlternateColorCodes('&',message));
            }
            //Scoreboard anzeigen
            p.performCommand("openscoreboard");
            //Inventar des Spilers festlegen
            Inventory playerInv = p.getInventory();
            playerInv.clear();

            ItemStack compass = new ItemStack(Material.COMPASS);
            ItemStack blazePowder = new ItemStack(Material.BLAZE_POWDER);
            ItemStack limeDye = new ItemStack(Material.LIME_DYE);

            ItemMeta compassMeta = compass.getItemMeta();
            compassMeta.setDisplayName(ChatColor.AQUA+""+ChatColor.BOLD+"Navigator");
            compassMeta.setLore(List.of(ChatColor.AQUA+"Navigiere durch die Lobby"));
            compass.setItemMeta(compassMeta);

            ItemMeta blazePowderMeta = blazePowder.getItemMeta();
            blazePowderMeta.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+"Partikel");
            blazePowderMeta.setLore(List.of(ChatColor.GOLD+"Setze deine Laufpartikel fest"));
            blazePowder.setItemMeta(blazePowderMeta);

            ItemMeta limeDyeMeta = limeDye.getItemMeta();
            limeDyeMeta.setDisplayName(org.bukkit.ChatColor.GREEN+""+ChatColor.BOLD+"Spielersichtbarkeit: AN");
            limeDyeMeta.setLore(List.of(ChatColor.GREEN+"Stelle die Spielersichtbarkeit ein"));
            limeDye.setItemMeta(limeDyeMeta);

            playerInv.setItem(4,compass );
            playerInv.setItem(2, blazePowder);
            playerInv.setItem(6, limeDye);
            for (int i = 0; i < 36; i++) {
                if(i == 4 || i == 2 || i == 6) continue;
                playerInv.setItem(i,new ItemStack(Material.AIR));
            }
        }
    }
}
