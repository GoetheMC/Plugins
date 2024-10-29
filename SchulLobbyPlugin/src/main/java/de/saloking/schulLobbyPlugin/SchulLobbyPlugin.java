package de.saloking.schulLobbyPlugin;

import de.saloking.schulLobbyPlugin.Commands.*;
import de.saloking.schulLobbyPlugin.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SchulLobbyPlugin extends JavaPlugin {


    @Override
    public void onEnable() {

        //Coole Nachricht in der Konsole beim starten des Plugins!
        Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD+"\n"+
                "   _____            _     _       __  __  _____ \n" +
                "  / ____|          | |   | |     |  \\/  |/ ____|\n" +
                " | |  __  ___   ___| |__ | |_ ___| \\  / | |     \n" +
                " | | |_ |/ _ \\ / _ \\ '_ \\| __/ _ \\ |\\/| | |     \n" +
                " | |__| | (_) |  __/ | | | ||  __/ |  | | |____ \n" +
                "  \\_____|\\___/ \\___|_| |_|\\__\\___|_|  |_|\\_____|\n" +
                "by Saloking & xSirBeppo                                                 \n" +
                "                                               ");

        //Config
        getConfig().options().copyDefaults(true);
        saveConfig();

        //Listener registrieren
        getServer().getPluginManager().registerEvents(new MenuListener(this),this);
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryDragListener(), this);
        getServer().getPluginManager().registerEvents(new PlayDropItemListener(), this);
        getServer().getPluginManager().registerEvents(new BlockDestroyListener(),this);
        getServer().getPluginManager().registerEvents(new PlayDropItemListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerDamageListener(), this);
        getServer().getPluginManager().registerEvents(new SignEvents(), this);
        getServer().getPluginManager().registerEvents(new OffHandListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerLeaveListener(this), this);

        //Command registrieren
        getCommand("openMenu").setExecutor(new PlayerMenuCommand());
        getCommand("partikel").setExecutor(new PlayerParticlesCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("hidePlayers").setExecutor(new HidePlayersCommand());
        getCommand("showPlayers").setExecutor(new ShowPlayerCommand());
        getCommand("openScoreBoard").setExecutor(new OpenScoreboardCommand());
        getCommand("fly").setExecutor(new FlyCommand());


        /*
        TODO 23.07.24:

X FERTIG - 1. Man kann items Droppen.
X FERTIG - 2. Durch das klicken auf die Items in dem Partikel Menü werden die Partikel noch nicht aktiviert.
X FERTIG - 3. Permissions
X Fertig - 3. Man kann noch sachen abbauen und Placen -> Das will ich aber erst im Zusammenhang mit permissions ändern
X FERTIG außer Rang anzeigen - 4. Scoreboard wo das Datum angezeigt wird der Rang und so sachen
X FERTIG - 5. Levelbar mit irgendetwas.
X EIG. FERTIG - 6. Config
         */
        /*
        TODO 24.07
        1. Tabliste

         */
        /**
         * ToDO: 31.07
         * 1.  Playtime tracker ._.
         *
         */
    }

}
