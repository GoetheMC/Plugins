package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulDropDffaPlugin;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnInv;
import io.papermc.paper.event.player.AsyncChatCommandDecorateEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import static org.bukkit.Effect.Type.SOUND;

public class PlayerRespawnAndDeath implements Listener {
    SpawnInv inv = new SpawnInv();
    private final SchulDropDffaPlugin plugin;
    public PlayerRespawnAndDeath(SchulDropDffaPlugin plugin){this.plugin = plugin;}
    PvpTag tag = new PvpTag();

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
        int xCord = plugin.getConfig().getInt("SpawnX");
        int yCord = plugin.getConfig().getInt("SpawnY");
        int zCord = plugin.getConfig().getInt("SpawnZ");
        Player p = e.getPlayer();
        Location loc = new Location(p.getWorld(), xCord,yCord,zCord);
        e.setRespawnLocation(loc);

        p.teleport(new Location(p.getWorld(),xCord,yCord,zCord));

        p.getInventory().clear();
        inv.setPlayerInv(p.getInventory());
        p.playSound(p, Sound.ENTITY_ELDER_GUARDIAN_DEATH,0.5F,0.1F);
    }
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        e.getDrops().clear();
        if(e.getPlayer().getKiller() == null) return;

        Player p = e.getPlayer();

        //geile alle sounds: https://minecraftsounds.com/
        p.getKiller().playSound(p, Sound.BLOCK_AMETHYST_BLOCK_BREAK,1,1);

        e.setDeathMessage(tag.getTag()+""+ChatColor.RED+" "+ChatColor.BOLD+""+p.getDisplayName()+
                ""+ChatColor.WHITE+" wurde von "+ChatColor.GREEN+""+ChatColor.BOLD+""+p.getKiller().getDisplayName()+""+ChatColor.WHITE
        +" getötet!");

        double health = p.getKiller().getHealth()/2;
        double healthRounded = Math.round(health*10);

        p.sendMessage(tag.getTag()+ ChatColor.WHITE+" Du wurdest von "+ChatColor.DARK_PURPLE+""+ChatColor.BOLD+""+p.getKiller().getDisplayName()+""+ChatColor.WHITE+""+" getötet! "+
               ChatColor.LIGHT_PURPLE +""+ChatColor.ITALIC+""+ healthRounded/10 +"/10.0 ❤");
    }

}
