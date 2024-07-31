package de.saloking.schulLobbyPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class HidePlayersCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p){
            List<Player> players = Bukkit.getOnlinePlayers().stream().collect(Collectors.toList());

            for (Player player : players) {
                p.hidePlayer(player);
            }
            p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.RED+"Alle Spieler wurden unsichtbar gemacht!");
        }
        return true;
    }
}
