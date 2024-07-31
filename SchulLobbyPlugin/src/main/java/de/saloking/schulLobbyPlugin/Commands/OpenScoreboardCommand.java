package de.saloking.schulLobbyPlugin.Commands;

import de.saloking.schulLobbyPlugin.SchulLobbyPlugin;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class OpenScoreboardCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            Scoreboard scoreboard = manager.getNewScoreboard();

            Objective o = scoreboard.registerNewObjective("scoreboard","dummy", ChatColor.GOLD+" "+ ChatColor.BOLD+"GoehteMC");
            o.setDisplaySlot(DisplaySlot.SIDEBAR);

            Score score = o.getScore("");
            score.setScore(9);

            Score score1 = o.getScore("Dein Rang:");
            score1.setScore(8);

            String rank = ChatColor.BOLD+" SPIELER";


                if(p.hasPermission("owner.rang")){
                    rank = ChatColor.RED +""+ ChatColor.BOLD + " OWNER";;
                } else if (p.hasPermission("admin.rang")) {
                    rank = ChatColor.RED +""+ ChatColor.BOLD +" ADMIN";
                }

            Score score2 = o.getScore(rank);
            score2.setScore(7);

            Score se1 = o.getScore(" ");
            se1.setScore(6);

            Score score3 = o.getScore("Spielername:");
            score3.setScore(5);

            Score score4 = o.getScore(ChatColor.BLUE+""+ChatColor.BOLD + " " +p.getDisplayName());
            score4.setScore(4);

            Score se2 = o.getScore("  ");
            se2.setScore(3);

            Score score5 = o.getScore("Lobby betreten:");
            score5.setScore(2);

            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            Score score6 = o.getScore(ChatColor.GOLD+""+ChatColor.BOLD + " "+formatter.format(date));
            score6.setScore(1);

            Score se3 = o.getScore("    ");
            se3.setScore(0);

            p.setScoreboard(scoreboard);
        }
        return true;
    }
}
