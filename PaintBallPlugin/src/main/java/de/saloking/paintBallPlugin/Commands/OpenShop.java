package de.saloking.paintBallPlugin.Commands;

import de.saloking.paintBallPlugin.Items.Waffen;
import de.saloking.paintBallPlugin.Traker.CoinsKillStreakTracker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class OpenShop implements CommandExecutor {

    CoinsKillStreakTracker tracker;
    public OpenShop(CoinsKillStreakTracker tracker) {
        this.tracker = tracker;
    }
    public Waffen waffe = new Waffen();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p){

            Inventory inventory = Bukkit.createInventory(p,4*9, ChatColor.GREEN+"Shop");

            ItemStack green = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta greenMeta = green.getItemMeta();
            greenMeta.setDisplayName(" ");
            green.setItemMeta(greenMeta);

            ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            ItemMeta redMeta = red.getItemMeta();
            redMeta.setDisplayName(" ");
            red.setItemMeta(redMeta);
            int coins = tracker.getCoins().getOrDefault(p.getUniqueId(), 0);

                for (int i = 0; i < 28; i+=9) {
                    inventory.setItem(i,red);
                }

                if (coins >= 1000) {
                    for (int i = 0; i < 28; i+=9) {
                        inventory.setItem(i, green);
                    }
                } else if (coins >= 750) {
                    for (int i = 0; i < 28; i+=9) {
                        if(i == 18)continue;
                        inventory.setItem(i,green);
                    }
                } else if (coins >= 500) {
                    for (int i = 0; i < 28; i+=9) {
                        if(i == 18 || i == 9)continue;
                        inventory.setItem(i,green);
                    }
                } else if (coins >= 250) {
                    inventory.setItem(27,green);
                }


            inventory.setItem(1,waffe.getPumpGun());
            inventory.setItem(10,waffe.getSniper());
            inventory.setItem(19,waffe.getMiniGun());
            inventory.setItem(28,waffe.getHandGrante());
            p.openInventory(inventory);
        }


        return true;
    }
}
