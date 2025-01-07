package de.goethemc.schuldropdffaplugin;

import de.goethemc.schuldropdffaplugin.commands.ArenaCommand;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import de.goethemc.schuldropdffaplugin.etc.SpawnInv;
import de.goethemc.schuldropdffaplugin.etc.SpawnIsland;
import de.goethemc.schuldropdffaplugin.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SchulFFA extends JavaPlugin {

    private final PvpTag tag = new PvpTag();
    private final SpawnInv inv = new SpawnInv();
    private final SpawnIsland spawnIsland = new SpawnIsland(this);


    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"/|GoetheMC| FFA-Plugin gestartet!/");

        getConfig().options().copyDefaults(true);
        saveConfig();

        this.getCommand("arena").setExecutor(new ArenaCommand(this));

        getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(this), this);
        getServer().getPluginManager().registerEvents(new DisableFallDamageListener(this),this);
        getServer().getPluginManager().registerEvents(new BlockPlace(this),this);
        getServer().getPluginManager().registerEvents(new PlayerRespawn(this),this);
        getServer().getPluginManager().registerEvents(new KitLogikWTF(this), this);
    }

    public String getTag(){
        return tag.getTag();
    }
    public SpawnInv getSpawnInv(){
        return this.inv;
    }
    public int getSpawnX(){
        return getConfig().getInt("SpawnX");
    }
    public int getSpawnY(){
        return getConfig().getInt("SpawnY");
    }
    public int getSpawnZ(){
        return getConfig().getInt("SpawnZ");
    }
    public int getMinFallDistance(){
        return getConfig().getInt("minFallDistance");
    }
    public SpawnIsland getSpawnIsland(){
        return this.spawnIsland;
    }
}
