package de.goethemc.schuldropdffaplugin.commands;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArenaCommand implements CommandExecutor {

    private final SchulFFA plugin;
    public ArenaCommand(SchulFFA plugin){this.plugin = plugin;}
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        int xCord = plugin.getConfig().getInt("ArenaX");
        int yCord = plugin.getConfig().getInt("ArenaY");
        int zCord = plugin.getConfig().getInt("ArenaZ");


        //Vllt. noch nen 5s counter wo man sich nicht bewegen darf, sonst kann man aus dem Kampf eif. "quitten"
        if(commandSender instanceof Player player){
            player.teleport(new Location(player.getWorld(),xCord,yCord,zCord));
        }
        else {
            commandSender.sendMessage("Du musst ein Spieler sein");
        }

        return false;
    }
}
