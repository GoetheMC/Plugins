package de.saloking.paintBallPlugin.Event;

import org.bukkit.Material;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.UUID;

public class WeaponEvents implements Listener {
    private HashMap<UUID, Double> cooldown = new HashMap<>();
    private HashMap<UUID, Double> damage = new HashMap<>();

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction().isRightClick()) {
            //Pistole
            if (e.getItem().getType() == Material.WOODEN_HOE) {
                if (finishedCoolDown(p, 500,Material.WOODEN_HOE)) {
                    shootSnowball(p, 1, 9);
                }
            }
            //Pump-Gun
            if (e.getItem().getType() == Material.GOLDEN_HOE) {
                if (finishedCoolDown(p, 800,Material.GOLDEN_HOE)) {
                    double temp = 1;
                    for (int i = 0; i < 8; i++) {
                        shootSnowball(p, temp, 5);
                        temp += 0.5;
                    }
                }
            }
            //Mini-Gun
            if (e.getItem().getType() == Material.NETHERITE_HOE) {
                if (finishedCoolDown(p, 50, Material.NETHERITE_HOE)) {
                    shootSnowball(p, 0.5, 4);
                }
            }
            //Sniper
            if(e.getItem().getType() == Material.DIAMOND_HOE){
                if(finishedCoolDown(p, 3000,Material.DIAMOND_HOE)){
                    shootSnowball(p,3,11);
                }
            }

        }
    }

    @EventHandler
    //Schneeball Waffe
    public void onProjectileHit (ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball) {
            if(event.getHitEntity() instanceof Player p){
                p.sendMessage("TEST: " +event.getEntity().getOwnerUniqueId());
                p.sendMessage("Test2: "+damage.get(event.getEntity().getUniqueId()));

                p.damage(damage.get(event.getEntity().getOwnerUniqueId()));
            }
        }
        //Handgranate
        if(event.getEntity() instanceof Egg){
            if(event.getHitBlock() == null){
                event.getHitEntity().getWorld().createExplosion(event.getEntity().getLocation(),5,false,false);
            }else if(event.getHitEntity() == null){
                event.getHitBlock().getWorld().createExplosion(event.getHitBlock().getLocation(),5,false,false);
            }
        }
    }

    public void shootSnowball(Player p, double velocity, double damage) {
        Snowball snowball = p.launchProjectile(Snowball.class);
        snowball.setVelocity(snowball.getVelocity().multiply(velocity));

        double uhrzeit = System.currentTimeMillis();
        this.damage.put(p.getUniqueId(),damage);
        cooldown.put(p.getUniqueId(), uhrzeit);
    }



    public boolean finishedCoolDown(Player p, int abklingzeit, Material material) {

        double uhrzeit = System.currentTimeMillis();
        double time = ((double)abklingzeit/1000.0)*25;

        if (cooldown.containsKey(p.getUniqueId())) {

            if (!(cooldown.get(p.getUniqueId()) > System.currentTimeMillis() - abklingzeit)) {
                cooldown.put(p.getUniqueId(), uhrzeit);
                p.setCooldown(material,(int) time);
                return true;
            } else {
                return false;
            }

        } else {
            cooldown.put(p.getUniqueId(), uhrzeit);
            p.setCooldown(material,(int)time);
            return true;
        }
    }
}

