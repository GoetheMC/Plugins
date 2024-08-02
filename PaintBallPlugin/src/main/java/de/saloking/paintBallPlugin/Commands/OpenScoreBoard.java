package de.saloking.paintBallPlugin.Commands;

import de.saloking.paintBallPlugin.Traker.CoinsKillStreakTracker;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

public class OpenScoreBoard implements CommandExecutor {
    CoinsKillStreakTracker tracker;
    public OpenScoreBoard(CoinsKillStreakTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p){
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                Scoreboard scoreboard = manager.getNewScoreboard();

                Objective o = scoreboard.registerNewObjective("scoreboard","dummy", ChatColor.GOLD+" "+ ChatColor.BOLD+"PAINTBALL");
                o.setDisplaySlot(DisplaySlot.SIDEBAR);

                Score score1 = o.getScore("");
                score1.setScore(7);

                Score score2 = o.getScore("Killstreak:");
                score2.setScore(6);

                if(tracker.getKillstreak().get(p.getUniqueId()) == null){
                    Score score3 = o.getScore(" "+0);
                    score3.setScore(5);
                }else{
                    Score score4 = o.getScore(" "+tracker.getKillstreak().get(p.getUniqueId()));
                    score4.setScore(5);
                }


                Score score5 = o.getScore(" ");
                score5.setScore(4);

                Score score6 = o.getScore("Coins:");
                score6.setScore(3);

                if(tracker.getCoins().get(p.getUniqueId()) == null){
                    Score score7 = o.getScore(" "+0);
                    score7.setScore(2);
                }else{
                    Score score8 = o.getScore(" "+tracker.getCoins().get(p.getUniqueId()));
                    score8.setScore(2);
                }

                Score score9 = o.getScore("  ");
                score9.setScore(0);

                p.setScoreboard(scoreboard);
        }
        return true;
    }
}
