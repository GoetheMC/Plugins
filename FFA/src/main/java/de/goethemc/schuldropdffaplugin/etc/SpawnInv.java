package de.goethemc.schuldropdffaplugin.etc;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class SpawnInv {
    public Inventory setPlayerInv(Inventory inventory){
        inventory.clear();

        ItemStack selector = new ItemStack(Material.DIAMOND);
        ItemMeta selectorMeta = selector.getItemMeta();
        selectorMeta.setDisplayName(ChatColor.GOLD + "KIT SELECTOR");
        selectorMeta.setLore(List.of("Wähle ein Kit für den Kampf"));
        selector.setItemMeta(selectorMeta);

        ItemStack arenatp = new ItemStack(Material.IRON_SWORD);
        ItemMeta arenatpMeta = arenatp.getItemMeta();
        arenatpMeta.setDisplayName(ChatColor.GOLD + "ARENA");
        arenatpMeta.setLore(List.of("Tritt der Arena zum Kampf bei"));
        arenatp.setItemMeta(arenatpMeta);

        ItemStack lobbytp = new ItemStack(Material.COMPASS);
        ItemMeta lobbytpMeta = lobbytp.getItemMeta();
        lobbytpMeta.setDisplayName(ChatColor.GOLD + "LOBBY");
        lobbytpMeta.setLore(List.of("Kehre zur Lobby zurück"));
        lobbytp.setItemMeta(lobbytpMeta);


        inventory.setItem(0, arenatp);
        inventory.setItem(4, selector);
        inventory.setItem(8, lobbytp);

        return inventory;
    }
}
