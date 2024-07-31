package de.saloking.schulLobbyPlugin;

import de.saloking.schulLobbyPlugin.Commands.*;
import de.saloking.schulLobbyPlugin.Listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class SchulLobbyPlugin extends JavaPlugin {


    @Override
    public void onEnable() {

        getConfig().options().copyDefaults(true);
        saveConfig();

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


        getCommand("openMenu").setExecutor(new PlayerMenuCommand());
        getCommand("partikel").setExecutor(new PlayerParticlesCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("hidePlayers").setExecutor(new HidePlayersCommand());
        getCommand("showPlayers").setExecutor(new ShowPlayerCommand());
        getCommand("openScoreBoard").setExecutor(new OpenScoreboardCommand());
        getCommand("fly").setExecutor(new FlyCommand());


        /*
        TODO 23.07:

X FERTIG - 1. Man kann items Droppen.
X FERTIG - 2. Durch das klicken auf die Items in dem Partikel Menü werden die Partikel noch nicht aktiviert.
X FERTIG - 3. Permissions
X Fertig - 3. Man kann noch sachen abbauen und Placen -> Das will ich aber erst im Zusammenhang mit permissions ändern
X FERTIG außer Rang anzeigen - 4. Scoreboard wo das Datum angezeigt wird der Rang und so sachen
        5. Levelbar mit irgendetwas.
X EIG. FERTIG - 6. Config
         */
        /*
        TODO 24.07
        1. Tabliste.
         */
    }

}
