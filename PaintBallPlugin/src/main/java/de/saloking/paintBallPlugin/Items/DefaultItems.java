package de.saloking.paintBallPlugin.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class DefaultItems{
    public void setInv(Player p){
        p.sendMessage("TEST - INV");
        //Inventar setzten!
        Inventory playerInv = p.getInventory();
        playerInv.clear();

        ItemStack pistole = new ItemStack(Material.WOODEN_HOE);
        ItemMeta pistoleMeta = pistole.getItemMeta();
        pistoleMeta.setDisplayName(ChatColor.YELLOW+""+ChatColor.BOLD+"Pistole");
        pistoleMeta.setLore(List.of(ChatColor.YELLOW+"Schieße alle 0.5 Sekunden!"));
        pistoleMeta.setUnbreakable(true);
        pistole.setItemMeta(pistoleMeta);

        playerInv.setItem(0,pistole);

        ItemStack shop = new ItemStack(Material.EMERALD);
        ItemMeta shopMeta = shop.getItemMeta();
        shopMeta.setDisplayName(ChatColor.GREEN+""+ChatColor.BOLD+"Shop");
        shop.setItemMeta(shopMeta);

        playerInv.setItem(8,shop);
    }
}
