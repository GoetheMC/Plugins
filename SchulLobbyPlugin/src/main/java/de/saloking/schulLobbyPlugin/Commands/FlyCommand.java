package de.saloking.schulLobbyPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){
            if(p.hasPermission("fly.use")){
                p.setAllowFlight(true);
                p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.LIGHT_PURPLE+"Du kannst jetzt fliegen. Viel Spaß!");
            }
        }
        return true;
    }
}
