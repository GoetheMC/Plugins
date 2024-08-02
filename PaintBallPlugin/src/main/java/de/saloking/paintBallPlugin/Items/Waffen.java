package de.saloking.paintBallPlugin.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Waffen {

    public ItemStack getPumpGun(){
        ItemStack pumpgun = new ItemStack(Material.GOLDEN_HOE);

        ItemMeta pumpgunMeta = pumpgun.getItemMeta();
        pumpgunMeta.setDisplayName(ChatColor.DARK_PURPLE+""+ChatColor.BOLD+"Pump-Gun");
        pumpgunMeta.setUnbreakable(true);

        ArrayList<String> pump = new ArrayList();
        pump.add(ChatColor.GREEN+"Preis: 500c");
        pump.add(ChatColor.DARK_PURPLE+"Cooldown: 0.8s");
        pump.add(ChatColor.DARK_PURPLE+"Speed: 1-5");
        pump.add(ChatColor.DARK_PURPLE+"Schaden: 5hp");
        pump.add(ChatColor.DARK_PURPLE+"Anzahl: 8/klick");

        pumpgunMeta.setLore(pump);
        pumpgun.setItemMeta(pumpgunMeta);

        return pumpgun;
    }
    public ItemStack getMiniGun(){
        ItemStack mingun = new ItemStack(Material.NETHERITE_HOE);
        mingun.setDurability((short)0);

        ItemMeta mingunMeta = mingun.getItemMeta();
        mingunMeta.setDisplayName(ChatColor.DARK_BLUE+""+ChatColor.BOLD+"Mini-Gun");
        mingunMeta.setUnbreakable(true);

        ArrayList<String> mini = new ArrayList();
        mini.add(ChatColor.GREEN+"Preis: 1000c");
        mini.add("Cooldown: 0.05s");
        mini.add("Speed: 0.5");
        mini.add("Schaden: 4hp");
        mini.add("Anzahl: 1/klick");

        mingunMeta.setLore(mini);
        mingun.setItemMeta(mingunMeta);

        return mingun;
    }
    public ItemStack getSniper(){
        ItemStack sniper = new ItemStack(Material.DIAMOND_HOE);

        ItemMeta sniperMeta = sniper.getItemMeta();
        sniperMeta.setDisplayName(ChatColor.AQUA+""+ChatColor.BOLD+"Sniper");
        sniperMeta.setUnbreakable(true);

        ArrayList<String> snipe = new ArrayList();
        snipe.add(ChatColor.GREEN+"Preis: 750c");
        snipe.add("Cooldown: 3s");
        snipe.add("Speed: 3");
        snipe.add("Schaden: 11hp");
        snipe.add("Anzahl: 1/klick");

        sniperMeta.setLore(snipe);
        sniper.setItemMeta(sniperMeta);

        return sniper;
    }
    public ItemStack getHandGrante(){
        ItemStack granate = new ItemStack(Material.EGG);

        ItemMeta granateMeta = granate.getItemMeta();
        granateMeta.setDisplayName(ChatColor.WHITE+""+ChatColor.BOLD+"Hand-Granate");
        granateMeta.setUnbreakable(true);

        ArrayList<String> gran = new ArrayList();
        gran.add(ChatColor.GREEN+"Preis: 250c");
        gran.add("Anzahl: 1");
        gran.add("Explosionsstärke: 5");

        granateMeta.setLore(gran);
        granate.setItemMeta(granateMeta);

        return granate;
    }
}
