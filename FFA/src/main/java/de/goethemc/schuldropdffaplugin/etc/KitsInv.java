package de.goethemc.schuldropdffaplugin.etc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KitsInv {
    public void openKitsInv(Player player,String ausgewählt){
        Inventory kitInv = Bukkit.createInventory(player, 9, ChatColor.GOLD +""+ChatColor.BOLD+ "Kits");

        ItemStack onlySwordKit = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta onlySwordKitMeta = onlySwordKit.getItemMeta();
        onlySwordKitMeta.setDisplayName(ChatColor.AQUA+ "Only Sword");
        onlySwordKitMeta.setLore(List.of("1 Schwert + 2 Gold Äpfel"));
        onlySwordKit.setItemMeta(onlySwordKitMeta);

        ItemStack soupKit = new ItemStack(Material.MUSHROOM_STEW);
        ItemMeta soupKitMeta = soupKit.getItemMeta();
        soupKitMeta.setDisplayName(ChatColor.DARK_GRAY+ "Soup");
        soupKitMeta.setLore(List.of("Eisenschwert + Lederrüstung + Soups"));
        soupKit.setItemMeta(soupKitMeta);

        ItemStack axtKit = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta axtKitMeta = axtKit.getItemMeta();
        axtKitMeta.setDisplayName(ChatColor.RED + "Axt");
        axtKitMeta.setLore(List.of("Schwert + Axt + Bogen + Crossbow + Dia-Rüstung"));
        axtKit.setItemMeta(axtKitMeta);


        ItemStack uhcKit = new ItemStack(Material.GOLDEN_APPLE);
        ItemMeta uhcKitMeta = uhcKit.getItemMeta();
        uhcKitMeta.setDisplayName(ChatColor.GOLD + "UHC");
        uhcKitMeta.setLore(List.of("Schwert + Lava + Wasser + Blöcke etc."));
        uhcKit.setItemMeta(uhcKitMeta);

        switch (ausgewählt){
            case "ONLYSWORD": onlySwordKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    onlySwordKit.setItemMeta(onlySwordKitMeta); break;
            case "SOUP": soupKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    soupKit.setItemMeta(soupKitMeta); break;
            case "AXE": axtKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    axtKit.setItemMeta(axtKitMeta); break;
            case "": break;
            case "UHC": uhcKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    uhcKit.setItemMeta(uhcKitMeta); break;
            default: onlySwordKitMeta.setLore(List.of(ChatColor.GREEN+"Ausgewählt."));
                    onlySwordKit.setItemMeta(onlySwordKitMeta); break;
        }

        kitInv.setItem(1,onlySwordKit);
        kitInv.setItem(3,axtKit);
        kitInv.setItem(5,uhcKit);
        kitInv.setItem(7, soupKit);

        player.openInventory(kitInv);
    }

}
