package fr.framboizier.oneshot.listeners;

import fr.framboizier.oneshot.Main;
import fr.framboizier.oneshot.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class PlayerProjecticleHitOneShot implements Listener {

    @EventHandler
    public void projecticleHit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow) {
            Arrow a = (Arrow) e.getDamager();
            Player victim = (Player) e.getEntity();
            if (a.getShooter() instanceof Player) {
                Player attacker = (Player) a.getShooter();
                if (attacker == victim) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.getInstance().tortue.contains(victim)) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.getInstance().invunerability.contains(attacker) || Main.getInstance().invunerability.contains(victim)) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.getInstance().kit.get(victim) == "tank") {
                    if (victim.getHealth() <= 8 && victim.getHealth() > 6) {
                        victim.setHealth(4);
                        return;
                    }
                }
                if (Main.getInstance().kit.get(victim) == "guerrier") {
                    if (victim.getHealth() <= 4 && victim.getHealth() > 2) {
                        victim.setHealth(2);
                        return;
                    }
                }
                e.setCancelled(true);
                Random coins_random = new Random();
                int coins;
                coins = 1 + coins_random.nextInt(4);
                kill(attacker, victim, coins);
                return;
            }
            return;
        }
        if (e.getDamager() instanceof Player) {
            Player victim = (Player) e.getEntity();
            Player attacker = (Player) e.getDamager();
            if (Main.getInstance().tortue.contains(victim)) {
                e.setCancelled(true);
                return;
            }
            if (Main.getInstance().invunerability.contains(attacker) || Main.getInstance().invunerability.contains(victim)) {
                e.setCancelled(true);
                return;
            }
            if (attacker.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_SWORD)) {
                if (victim.getHealth() <= 8 && victim.getHealth() > 6) {
                    victim.setHealth(4);
                    return;
                }
                if (victim.getHealth() <= 6) {
                    Random coins_random = new Random();
                    int coins;
                    coins = 1 + coins_random.nextInt(4);
                    kill(attacker, victim, coins);
                    return;
                }
            }
            if (attacker.getPlayer().getItemInHand().getType().equals(Material.IRON_SWORD)) {
                if (victim.getHealth() <= 8 && victim.getHealth() > 6) {
                    victim.setHealth(6);
                    return;
                }
                if (victim.getHealth() <= 6 && victim.getHealth() > 4) {
                    victim.setHealth(3);
                    return;
                }
                if (victim.getHealth() <= 4 && victim.getHealth() > 3) {
                    victim.setHealth(2);
                    return;
                }
                if (victim.getHealth() <= 3) {
                    Random coins_random = new Random();
                    int coins;
                    coins = 1 + coins_random.nextInt(4);
                    kill(attacker, victim, coins);
                    return;
                }
            }
            if (attacker.getPlayer().getItemInHand().getType().equals(Material.STONE_SWORD)) {
                if (victim.getHealth() <= 8 && victim.getHealth() > 6) {
                    victim.setHealth(6);
                    return;
                }
                if (victim.getHealth() <= 6 && victim.getHealth() > 4) {
                    victim.setHealth(4);
                    return;
                }
                if (victim.getHealth() <= 4 && victim.getHealth() > 2) {
                    victim.setHealth(2);
                    return;
                }
                if (victim.getHealth() <= 2) {
                    Random coins_random = new Random();
                    int coins;
                    coins = 1 + coins_random.nextInt(4);
                    kill(attacker, victim, coins);
                    return;
                }

            }
        }
        return;
    }
    private static void kill(Player attacker, Player victim, int coins) {
        Main.getInstance().play.itemHub(victim);
        victim.playSound(victim.getLocation(), Sound.ANVIL_BREAK, 2, 2);
        attacker.playSound(victim.getLocation(), Sound.ORB_PICKUP, 2, 2);
        Main.getInstance().killstreak.put(attacker.getPlayer(), Main.getInstance().killstreak.get(attacker.getPlayer()) + 1);
        if (Main.getInstance().killstreak.get(attacker) == 5) {
            Bukkit.broadcastMessage(Main.getInstance().prefix + attacker.getDisplayName() + " §fa fait une série de §c5 kill §f!");
        }
        if (Main.getInstance().killstreak.get(attacker) == 10) {
            Bukkit.broadcastMessage(Main.getInstance().prefix + attacker.getDisplayName() + " §fa fait une série de §c10 kill §f!");
        }
        if (Main.getInstance().killstreak.get(attacker) == 15) {
            Bukkit.broadcastMessage(Main.getInstance().prefix + attacker.getDisplayName() + " §fa fait une série de §415 kill §f!");
        }
        if (Main.getInstance().killstreak.get(attacker) == 20) {
            Bukkit.broadcastMessage(Main.getInstance().prefix + attacker.getDisplayName() + " §fa fait une série de §420 kill §f!");
        }
        if (Main.getInstance().killstreak.get(attacker) == 25) {
            Bukkit.broadcastMessage(Main.getInstance().prefix + attacker.getDisplayName() + " §fa fait une série de §4§l25 kill §f!");
        }
        if (Main.getInstance().killstreak.get(attacker) == 30) {
            Bukkit.broadcastMessage(Main.getInstance().prefix + attacker.getDisplayName() + " §fVien de faire une §4§lNucleaire §f!");
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), Sound.WITHER_SPAWN, 4, 4);
            }
        }
        Main.getInstance().killstreak.put(victim, 0);


        attacker.sendMessage("§9§lOneShot§8§l»" + " §fVous avez tué §d" + victim.getDisplayName() + " §f! §e+" + coins + " §eCoins");
        Main.getInstance().kills.put(attacker.getUniqueId(), Main.getInstance().kills.get(attacker.getUniqueId()) + 1);
        Main.getInstance().coins.put(attacker.getUniqueId(), Main.getInstance().coins.get(attacker.getUniqueId()) + coins);
        victim.sendMessage("§9§lOneShot§8§l» §d" + attacker.getDisplayName() + " §7vous a tué !");
        if (Main.getInstance().kit.get(attacker) == "guerrier" || Main.getInstance().kit.get(attacker) == "acrobate") {
            attacker.setHealth(4);
        }
        if (Main.getInstance().kit.get(attacker) == "oneshot") {
            attacker.setHealth(6);
        }
        if (Main.getInstance().kit.get(attacker) == "tank") {
            attacker.setHealth(8);
        }
        if (Main.getInstance().kit.get(victim) == "guerrier" || Main.getInstance().kit.get(victim) == "acrobate") {
            victim.setHealth(4);
            victim.removePotionEffect(PotionEffectType.SPEED);
            victim.setAllowFlight(false);
        }
        if (Main.getInstance().kit.get(victim) == "oneshot") {
            victim.setHealth(6);
            victim.removePotionEffect(PotionEffectType.SPEED);
            victim.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
        if (Main.getInstance().kit.get(victim) == "tank") {
            victim.setHealth(8);
            victim.removePotionEffect(PotionEffectType.SLOW);
        }
        Main.getInstance().playercooldown.put(victim.getUniqueId(), false);
        ItemStack arrow = new ItemBuilder(Material.ARROW, 2).setDisplayName("§7Flèche").toItemStack();
        attacker.getInventory().addItem(arrow);
        return;
    }
}