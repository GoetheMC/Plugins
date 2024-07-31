package de.saloking.schulLobbyPlugin.Commands;

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

public class PlayerParticlesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player p) {
            Inventory partikel = Bukkit.createInventory(p, 27, ChatColor.GOLD + "Alle-Partikel");

            ItemStack herzPartikel = new ItemStack(Material.RED_TULIP);
            ItemStack feuerPartikel = new ItemStack(Material.LAVA_BUCKET);
            ItemStack schweifPartikel = new ItemStack(Material.NETHER_STAR);

            ItemMeta herzPartikelMeta = herzPartikel.getItemMeta();
            herzPartikelMeta.setDisplayName(ChatColor.RED +""+ChatColor.BOLD+ "HERZ-PARTIKEL");
            herzPartikelMeta.setLore(null);
            herzPartikel.setItemMeta(herzPartikelMeta);

            ItemMeta feuerPartikelMeta = feuerPartikel.getItemMeta();
            feuerPartikelMeta.setDisplayName(ChatColor.GOLD+""+ChatColor.BOLD+"FEUER-PARTIKEL");
            feuerPartikelMeta.setLore(null);
            feuerPartikel.setItemMeta(feuerPartikelMeta);

            ItemMeta weißPartikelMeta = schweifPartikel.getItemMeta();
            weißPartikelMeta.setDisplayName(ChatColor.WHITE+""+ChatColor.BOLD+"WEIßer-SCHWEIF");
            weißPartikelMeta.setLore(null);
            schweifPartikel.setItemMeta(weißPartikelMeta);

            partikel.setItem(11, schweifPartikel);
            partikel.setItem(13,herzPartikel);
            partikel.setItem(15,feuerPartikel);

            for (int i = 0; i < 27; i++) {
                if(i == 11 || i == 13 || i == 15) continue;
                ItemStack temp = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                ItemMeta tempMeta = temp.getItemMeta();
                tempMeta.setDisplayName(" ");
                temp.setItemMeta(tempMeta);

                partikel.setItem(i,temp);
            }

            p.openInventory(partikel);
        }

        return true;
    }
}
