package de.saloking.schulLobbyPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class PlayerMenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){
            Inventory menu = Bukkit.createInventory(p,27, ChatColor.AQUA+"Spiel-Server");
            ItemStack survival = new ItemStack(Material.GRASS_BLOCK);
            ItemStack pvp = new ItemStack(Material.GOLDEN_SWORD);
            ItemStack spawn = new ItemStack(Material.PRISMARINE_CRYSTALS);

            //Metadata
            ItemMeta survivalMeta = survival.getItemMeta();
            survivalMeta.setDisplayName(ChatColor.GOLD+"SURVIVAL");
            survivalMeta.setLore(List.of(ChatColor.GOLD +"Spiele auf dem Schuleigenen SMP")); //Vielleicht ein Error?
            survival.setItemMeta(survivalMeta);

            ItemMeta pvpMeta = survival.getItemMeta();
            pvpMeta.setDisplayName(ChatColor.GOLD+"PVP");
            pvpMeta.setLore(List.of(ChatColor.GOLD +"Kämpfe mit vorgefertigten oder selbsterstellten Kits gegen deine Freunde")); //Vielleicht ein Error?
            pvp.setItemMeta(pvpMeta);

            ItemMeta spawnMeta = spawn.getItemMeta();
            spawnMeta.setDisplayName(ChatColor.LIGHT_PURPLE+"SPAWN");
            spawnMeta.setLore(List.of(ChatColor.LIGHT_PURPLE+"Telpotiere dich zum Lobby-Spawn")); //Vielleicht ein Error?
            spawn.setItemMeta(spawnMeta);

            menu.setItem(11,survival);
            menu.setItem(13,spawn);
            menu.setItem(15,pvp);
            for (int i = 0; i < 27; i++) {
                if(i == 11 || i == 13 || i == 15) continue;
                ItemStack temp = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
                ItemMeta tempMeta = temp.getItemMeta();
                tempMeta.setDisplayName(" ");
                temp.setItemMeta(tempMeta);

                menu.setItem(i,temp);
            }

            p.openInventory(menu);

        }
        return true;

    }
}
