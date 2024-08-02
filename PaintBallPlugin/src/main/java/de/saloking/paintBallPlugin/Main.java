package de.saloking.paintBallPlugin;

import de.saloking.paintBallPlugin.Commands.OpenScoreBoard;
import de.saloking.paintBallPlugin.Commands.OpenShop;
import de.saloking.paintBallPlugin.Event.*;
import de.saloking.paintBallPlugin.Traker.CoinsKillStreakTracker;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private CoinsKillStreakTracker tracker;
    @Override
    public void onEnable() {
        // Plugin startup logic

        tracker = new CoinsKillStreakTracker();
        getServer().getPluginManager().registerEvents(tracker, this);

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new WeaponEvents(), this);
        getServer().getPluginManager().registerEvents(new ShopOpenEvent(tracker),this);
        getServer().getPluginManager().registerEvents(new CoinsKillStreakTracker(),this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawn(), this);

        getCommand("openshop").setExecutor(new OpenShop(tracker));
        getCommand("openscoreboard").setExecutor(new OpenScoreBoard(tracker));

    }
}
