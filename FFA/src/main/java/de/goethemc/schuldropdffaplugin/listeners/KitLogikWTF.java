package de.goethemc.schuldropdffaplugin.listeners;

import de.goethemc.schuldropdffaplugin.SchulFFA;
import de.goethemc.schuldropdffaplugin.kits.KitsInventoryManager;
import de.goethemc.schuldropdffaplugin.kits.KitsOverviewInventory;
import de.goethemc.schuldropdffaplugin.etc.PvpTag;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;


public class KitLogikWTF implements Listener {
    KitsInventoryManager kit = new KitsInventoryManager();
    PvpTag tag = new PvpTag();
    KitsOverviewInventory kInv = new KitsOverviewInventory();

    private final SchulFFA plugin;

    public KitLogikWTF(SchulFFA plugin){
        this.plugin = plugin;
    }

    HashMap<UUID,String> playerKitMap = new HashMap<>();
    private final String uhc = "UHC";
    private final String onlySword = "ONLYSWORD";
    private final String soup = "SOUP";
    private final String axe = "AXE";

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player pl) {
            UUID p = pl.getUniqueId();
            if(e.getCurrentItem() == null) return;

            switch (e.getCurrentItem().getType()) {
                case Material.GOLDEN_APPLE:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD+"UHC")) {
                        if (playerKitMap.containsKey(p) && playerKitMap.get(p).equals("UHC")) {
                            //pl.sendMessage(tag.getTag()+ChatColor.RED+" Du kannst nicht das gleiche Kit zweimal auswählen!");
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1.50F, 0.50F);
                        } else {
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1, 2);
                            playerKitMap.put(p, this.uhc);
                            pl.sendMessage(tag.getTag() + ChatColor.GOLD + "" + ChatColor.BOLD + " UHC" + ChatColor.WHITE + "-Kit" + ChatColor.GREEN + " ausgewählt!");
                            kInv.openKitsInv(pl, "UHC");
                        }
                    }
                    break;
                case Material.DIAMOND_SWORD:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA+"Only Sword")) {
                        if (playerKitMap.containsKey(p) && playerKitMap.get(p).equals("ONLYSWORD")) {
                            //pl.sendMessage(tag.getTag()+ChatColor.RED+" Du kannst nicht das gleiche Kit zweimal auswählen!");
                            //Bukkit.getConsoleSender().sendMessage("HalloTest");
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1.50F, 0.50F);
                        } else {
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1.5F, 1.3F);
                            playerKitMap.put(p, this.onlySword);
                            pl.sendMessage(tag.getTag() + ChatColor.AQUA + "" + ChatColor.BOLD + " OnlySword" + ChatColor.WHITE + "-Kit" + ChatColor.GREEN + " ausgewählt!");
                            kInv.openKitsInv(pl, "ONLYSWORD");
                        }
                    }
                    break;
                case Material.MUSHROOM_STEW:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GRAY+"Soup")){
                        if(playerKitMap.containsKey(p) && playerKitMap.get(p).equals("SOUP")){
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1.50F,0.50F);
                        }else {
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1.50F,1.50F);
                            playerKitMap.put(p, this.soup);
                            pl.sendMessage(tag.getTag() + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + " SOUP" + ChatColor.WHITE + "-Kit" + ChatColor.GREEN + " ausgewählt!");
                            kInv.openKitsInv(pl, "SOUP");
                        }
                    }
                    break;
                case Material.NETHERITE_AXE:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED+"Axt")) {
                        if (playerKitMap.containsKey(p) && playerKitMap.get(p).equals("AXE")) {
                            //pl.sendMessage(tag.getTag()+ChatColor.RED+" Du kannst nicht das gleiche Kit zweimal auswählen!");
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1.50F, 0.50F);
                        } else {
                            pl.playSound(pl, Sound.ENTITY_ITEM_PICKUP, 1, 1);
                            playerKitMap.put(p, this.axe);
                            pl.sendMessage(tag.getTag() + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + " Axt" + ChatColor.WHITE + "-Kit" + ChatColor.GREEN + " ausgewählt.");
                            kInv.openKitsInv(pl, "AXE");
                        }
                    }
                    break;
            }
        }
    }

    @EventHandler
    public void onFallDamage(EntityDamageEvent event){
        int minFallDistance = plugin.getConfig().getInt("minFallDistance");
        if (event.getEntity() instanceof Player player){
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL && player.getFallDistance() >= minFallDistance){
                checkForKit(player);
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player died = e.getPlayer();

        if(died.getKiller() == null) return;
        Player killer = died.getKiller();
        killer.setHealthScale(20);

        checkForKit(killer);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.DIAMOND) {
            kInv.openKitsInv(p, playerKitMap.getOrDefault(p.getUniqueId(), ""));
        }
    }

    public void checkForKit(Player p){
        UUID player = p.getUniqueId();
        if (playerKitMap.containsKey(player)) {
            switch (playerKitMap.get(player)) {
                case "UHC":
                    kit.getUHC(p);
                    break;
                case "SOUP":
                    kit.getSoup(p);
                    break;
                case "AXE":
                    kit.getAxe(p);
                    break;
                default:
                    kit.getOnlySword(p);
                    break;
            }
        } else {
            kit.getOnlySword(p);
        }
    }

}
