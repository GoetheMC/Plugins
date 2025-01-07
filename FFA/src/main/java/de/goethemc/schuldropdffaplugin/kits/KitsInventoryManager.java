package de.goethemc.schuldropdffaplugin.kits;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitsInventoryManager {
    public Inventory getUHC(Player p){
        Inventory inv = p.getInventory();
        inv.clear();

        ItemStack schwert = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta schwertMeta = schwert.getItemMeta();
        schwertMeta.addEnchant(Enchantment.SHARPNESS,1,true);
        schwert.setItemMeta(schwertMeta);

        ItemStack axt = new ItemStack(Material.IRON_AXE);
        ItemMeta axtMeta = axt.getItemMeta();
        axtMeta.addEnchant(Enchantment.SHARPNESS,1,true);
        axtMeta.addEnchant(Enchantment.UNBREAKING,2,true);
        axt.setItemMeta(axtMeta);

        ItemStack crossbow = new ItemStack(Material.CROSSBOW);
        ItemMeta crossbowMeta = crossbow.getItemMeta();
        crossbowMeta.addEnchant(Enchantment.PIERCING,1,true);
        crossbow.setItemMeta(crossbowMeta);

        ItemStack picke = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta pickeMeta = picke.getItemMeta();
        pickeMeta.addEnchant(Enchantment.EFFICIENCY,1,true);
        pickeMeta.addEnchant(Enchantment.UNBREAKING,2,true);
        picke.setItemMeta(pickeMeta);

        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemMeta shieldMeta = shield.getItemMeta();
        shieldMeta.addEnchant(Enchantment.UNBREAKING,1,true);
        shield.setItemMeta(shieldMeta);

        ItemStack ygt1 = new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA,64);
        ItemStack ygt2 = new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA,64);

        ItemStack water1 = new ItemStack(Material.WATER_BUCKET);
        ItemStack water2 = new ItemStack(Material.WATER_BUCKET);
        ItemStack water3 = new ItemStack(Material.WATER_BUCKET);

        ItemStack lava1 = new ItemStack(Material.LAVA_BUCKET);
        ItemStack lava2 = new ItemStack(Material.LAVA_BUCKET);

        ItemStack arrows = new ItemStack(Material.ARROW,12);

        ItemStack rod = new ItemStack(Material.FISHING_ROD);

        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE,8);

        inv.setItem(0, schwert);
        inv.setItem(1, rod);
        inv.setItem(2, gapple);
        inv.setItem(3, lava1);
        inv.setItem(4, axt);
        inv.setItem(5, water1);
        inv.setItem(6, crossbow);
        inv.setItem(7, picke);
        inv.setItem(8, ygt1);

        inv.setItem(40,shield);

        inv.setItem(35,ygt2);
        inv.setItem(31,lava2);
        inv.setItem(32,water2);
        inv.setItem(23,water3);
        inv.setItem(9,arrows);

        //Rüstung
        ItemStack hose = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta hoseMeta = hose.getItemMeta();
        hoseMeta.addEnchant(Enchantment.PROTECTION,2,true);
        hoseMeta.addEnchant(Enchantment.UNBREAKING,2,true);
        hose.setItemMeta(hoseMeta);
        inv.setItem(37,hose);

        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta helmMeta = helm.getItemMeta();
        helmMeta.addEnchant(Enchantment.PROTECTION,2,true);
        helmMeta.addEnchant(Enchantment.UNBREAKING,1,true);
        helm.setItemMeta(helmMeta);
        inv.setItem(39,helm);

        ItemStack botten = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta bottenMeta = botten.getItemMeta();
        bottenMeta.addEnchant(Enchantment.PROTECTION,3,true);
        bottenMeta.addEnchant(Enchantment.UNBREAKING,2,true);
        botten.setItemMeta(bottenMeta);
        inv.setItem(36,botten);

        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.addEnchant(Enchantment.PROTECTION,2,true);
        chestMeta.addEnchant(Enchantment.UNBREAKING,1,true);
        chest.setItemMeta(chestMeta);
        inv.setItem(38,chest);

        return inv;
    }

    public Inventory getOnlySword(Player p){
        Inventory inv = p.getInventory();
        inv.clear();

        ItemStack schwert = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta schwertMeta = schwert.getItemMeta();
        schwertMeta.addEnchant(Enchantment.SHARPNESS,2,true);
        schwert.setItemMeta(schwertMeta);
        inv.setItem(0,schwert);

        ItemStack gap = new ItemStack(Material.GOLDEN_APPLE,2);
        inv.setItem(1,gap);

        //Rüstung
        ItemStack hose = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta hoseMeta = hose.getItemMeta();
        hoseMeta.addEnchant(Enchantment.PROTECTION,1,true);
        hose.setItemMeta(hoseMeta);
        inv.setItem(37,hose);

        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        inv.setItem(39,helm);

        ItemStack botten = new ItemStack(Material.DIAMOND_BOOTS);
        inv.setItem(36,botten);

        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.addEnchant(Enchantment.PROTECTION,2,true);
        chest.setItemMeta(chestMeta);
        inv.setItem(38,chest);

        return inv;
    }
    public Inventory getSoup(Player p){
        Inventory inv = p.getInventory();
        inv.clear();

        ItemStack schwert = new ItemStack(Material.IRON_SWORD);
        ItemMeta schwertMeta = schwert.getItemMeta();
        schwertMeta.addEnchant(Enchantment.SHARPNESS,1,true);
        schwertMeta.addEnchant(Enchantment.UNBREAKING,2,true);
        schwert.setItemMeta(schwertMeta);
        inv.setItem(0,schwert);

        ItemStack soup = new ItemStack(Material.MUSHROOM_STEW);
        for (int i = 1; i <= 35; i++){
            if(i==17 || i == 16||i==15){
                continue;
            }
            inv.setItem(i,soup);
        }
        ItemStack bowl = new ItemStack(Material.BOWL,64);
        inv.setItem(15,bowl);
        ItemStack rM = new ItemStack(Material.RED_MUSHROOM,64);
        inv.setItem(16,rM);
        ItemStack bM = new ItemStack(Material.BROWN_MUSHROOM,64);
        inv.setItem(17,bM);

        //Rüstung
        ItemStack hose = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta hoseMeta = hose.getItemMeta();
        hoseMeta.addEnchant(Enchantment.PROTECTION,4,true);
        hoseMeta.setUnbreakable(true);
        hose.setItemMeta(hoseMeta);
        inv.setItem(37,hose);

        ItemStack helm = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta helmMeta = helm.getItemMeta();
        helmMeta.setUnbreakable(true);
        helmMeta.addEnchant(Enchantment.PROTECTION,4,true);
        helm.setItemMeta(helmMeta);

        inv.setItem(39,helm);

        ItemStack botten = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta bottenMeta = botten.getItemMeta();
        bottenMeta.setUnbreakable(true);
        bottenMeta.addEnchant(Enchantment.PROTECTION,4,true);
        botten.setItemMeta(bottenMeta);
        inv.setItem(36,botten);

        ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.addEnchant(Enchantment.PROTECTION,3,true);
        chest.setItemMeta(chestMeta);


        inv.setItem(38,chest);

        return inv;
    }
    public Inventory getAxe(Player p){
        Inventory inv = p.getInventory();
        inv.clear();

        ItemStack schwert = new ItemStack(Material.DIAMOND_SWORD);
        inv.setItem(0,schwert);

        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        inv.setItem(1,axe);

        ItemStack crossbow = new ItemStack(Material.CROSSBOW);
        inv.setItem(2,crossbow);

        ItemStack bogen = new ItemStack(Material.BOW);
        inv.setItem(3,bogen);

        ItemStack arrow = new ItemStack(Material.ARROW,7);
        inv.setItem(8,arrow);

        ItemStack shield = new ItemStack(Material.SHIELD);
        inv.setItem(40,shield);

        //Rüstung
        ItemStack hose = new ItemStack(Material.DIAMOND_LEGGINGS);
        inv.setItem(37,hose);

        ItemStack helm = new ItemStack(Material.DIAMOND_HELMET);
        inv.setItem(39,helm);

        ItemStack botten = new ItemStack(Material.DIAMOND_BOOTS);
        inv.setItem(36,botten);

        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        inv.setItem(38,chest);

        return inv;
    }
}
