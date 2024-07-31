package de.saloking.schulLobbyPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class ShowPlayerCommand implements CommandExecutor{

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){
            List<Player> players = Bukkit.getOnlinePlayers().stream().collect(Collectors.toList());
            for (Player player : players) {
                p.showPlayer(player);
            }
            p.sendMessage(ChatColor.GOLD+"[Lobby] "+ChatColor.GREEN+"Alle Spieler wurden sichtbar gemacht!");
        }
        return true;
    }
}
