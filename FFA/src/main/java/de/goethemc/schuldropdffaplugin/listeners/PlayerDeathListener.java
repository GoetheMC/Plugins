package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener {
    SchulFFA ffa;

    public PlayerDeathListener(SchulFFA ffa){
        this.ffa = ffa;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        event.getDrops().clear();
        if(event.getPlayer().getKiller() == null) return;

        Player player = event.getPlayer();

        //geile alle sounds: https://minecraftsounds.com/
        player.getKiller().playSound(player, Sound.BLOCK_AMETHYST_BLOCK_BREAK,1,1);

        event.setDeathMessage
                (ChatColor.RED + "" + ChatColor.BOLD + player.getDisplayName() + ChatColor.WHITE +
                        " wurde von " + ChatColor.GREEN + ChatColor.BOLD + player.getKiller().getDisplayName() + ChatColor.WHITE + " getötet!");

        double health = player.getKiller().getHealth()/2;
        double healthRounded = Math.round(health*10);

        player.sendMessage(ffa.getTag()+ ChatColor.WHITE + " Du wurdest von "+ChatColor.DARK_PURPLE+""+ChatColor.BOLD+""+player.getKiller().getDisplayName()+""+ChatColor.WHITE+""+" getötet! "+
                ChatColor.LIGHT_PURPLE +""+ChatColor.ITALIC+""+ healthRounded/10 +"/10.0 ❤");
    }
}
