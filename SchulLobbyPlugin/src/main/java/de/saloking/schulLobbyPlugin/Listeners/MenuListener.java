package de.saloking.schulLobbyPlugin.Listeners;

import de.saloking.schulLobbyPlugin.SchulLobbyPlugin;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;
import java.util.Map;

public class MenuListener implements Listener {

    private final Map<Player, Particle> playerParticleSelections = new HashMap<>();

    private final SchulLobbyPlugin plugin;
    public MenuListener(SchulLobbyPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();

        if(!p.hasPermission("inventory.use")){
            e.setCancelled(true);
        }
        if(!p.getGameMode().equals(GameMode.CREATIVE)){
            e.setCancelled(true);
        }
        //Partikel Menü Inventar
        if(e.getView().getTitle().equals(ChatColor.GOLD + "Alle-Partikel")){
            //Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);

            if (e.getCurrentItem() == null) {
                return;
            }

            switch (e.getCurrentItem().getType()) {
                case NETHER_STAR:
                    p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.WHITE+" "+ ChatColor.BOLD+"Weißer-Schweif-Partikel aktiviert!");
                    playerParticleSelections.put(p, Particle.END_ROD);
                    break;
                case RED_TULIP:
                    p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.RED+" "+ ChatColor.BOLD+"Herz-Partikel aktiviert!");
                    playerParticleSelections.put(p, Particle.HEART);
                    break;
                case LAVA_BUCKET:
                    p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.GOLD+" "+ ChatColor.BOLD+"Feuer-Partikel aktiviert!");
                    playerParticleSelections.put(p, Particle.FLAME);
                    break;
                default:
                    break;
            }
        }

        //Spiel Menü Inventar
        if(e.getView().getTitle().equals(ChatColor.AQUA+"Spiel-Server")) { //es wird geschaut, ob mit dem in der Klasse PlayerMenuCommand erstellte Inventar iteragiert wurde

            //Player p = (Player) e.getWhoClicked();
            e.setCancelled(true); //Das ClickEvent wird gecancellt, das heißt es kann nicht rausgenommen wurde.

            if (e.getCurrentItem().getType().equals(Material.GRASS_BLOCK)) { //Wenn das geklickte Item grass_block ist
                p.teleport(new Location(p.getWorld(),
                        this.plugin.getConfig().getInt("survival-coordinates.X"),
                        this.plugin.getConfig().getInt("survival-coordinates.Y"),
                        this.plugin.getConfig().getInt("survival-coordinates.Z"),
                        this.plugin.getConfig().getInt("survival-coordinates.YAW"),
                        this.plugin.getConfig().getInt("survival-coordinates.PITCH")));
                p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.GREEN+" Du wurdest vor den Eingang der "+ChatColor.GREEN+""+ChatColor.BOLD+"surival-Welt"+ ChatColor.RESET+""+ ChatColor.GREEN +" teleportiert. Viel Spaß!");
            } else if (e.getCurrentItem().getType().equals(Material.GOLDEN_SWORD)) { //Wenn das geklickte Item gold schwert ist.
                p.teleport(new Location(p.getWorld(),
                        this.plugin.getConfig().getInt("pvp-coordinates.X"),
                        this.plugin.getConfig().getInt("pvp-coordinates.Y"),
                        this.plugin.getConfig().getInt("pvp-coordinates.Z"),
                        this.plugin.getConfig().getInt("pvp-coordinates.YAW"),
                        this.plugin.getConfig().getInt("pvp-coordinates.PITCH")));
                p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.GOLD+" Du wurdest vor den Eingang der "+ChatColor.GOLD+""+ChatColor.BOLD+"pvp-Welt"+ ChatColor.RESET+""+ ChatColor.GOLD +" teleportiert. Viel Spaß!");
            } else if (e.getCurrentItem().getType().equals(Material.PRISMARINE_CRYSTALS)) {
                p.teleport(p.getWorld().getSpawnLocation());
                p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.BLUE+" Du wurdest zum"+ ChatColor.BLUE+""+ChatColor.BOLD+" Spawn "+ChatColor.RESET+""+ChatColor.BLUE+"teleportiert.");
            }
        }
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Particle particle = playerParticleSelections.get(player);
        if(particle != null){
            if (particle == Particle.HEART) {
                player.getWorld().spawnParticle(particle, player.getLocation(), plugin.getConfig().getInt("heart-particles.AMOUNT"));
            } else if (particle == Particle.END_ROD) {
                player.getWorld().spawnParticle(particle, player.getLocation(), plugin.getConfig().getInt("white-particles.AMOUNT"), 0.2, 0.2, 0.2, 0.1);
            } else if(particle == Particle.FLAME){
                player.getWorld().spawnParticle(particle, player.getLocation(), plugin.getConfig().getInt("flame-particles.AMOUNT"), 0.1, 0.2, 0.2, 0.1);
            }
        }

    }

}
