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

    private static void kill(Player attacker, Player victim, int coins) {
        Main.getInstance().getPlay().itemHub(victim);
        victim.playSound(victim.getLocation(), Sound.ANVIL_BREAK, 2, 2);
        attacker.playSound(victim.getLocation(), Sound.ORB_PICKUP, 2, 2);
        Main.getInstance().getKillstreak().put(attacker.getPlayer(), Main.getInstance().getKillstreak().get(attacker.getPlayer()) + 1);
        if (Main.getInstance().getKillstreak().get(attacker).equals(5)) {
            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + attacker.getDisplayName() + " §fa fait une série de §c5 kill §f!");
        }
        if (Main.getInstance().getKillstreak().get(attacker).equals(10)) {
            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + attacker.getDisplayName() + " §fa fait une série de §c10 kill §f!");
        }
        if (Main.getInstance().getKillstreak().get(attacker).equals(15)) {
            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + attacker.getDisplayName() + " §fa fait une série de §415 kill §f!");
        }
        if (Main.getInstance().getKillstreak().get(attacker).equals(20)) {
            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + attacker.getDisplayName() + " §fa fait une série de §420 kill §f!");
        }
        if (Main.getInstance().getKillstreak().get(attacker).equals(25)) {
            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + attacker.getDisplayName() + " §fa fait une série de §4§l25 kill §f!");
        }
        if (Main.getInstance().getKillstreak().get(attacker).equals(30)) {
            Bukkit.broadcastMessage(Main.getInstance().getPrefix() + attacker.getDisplayName() + " §fVien de faire une §4§lNucleaire §f!");
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), Sound.WITHER_SPAWN, 4, 4);
            }
        }
        Main.getInstance().getKillstreak().put(victim, 0);


        attacker.sendMessage("§9§lOneShot§8§l»" + " §fVous avez tué §d" + victim.getDisplayName() + " §f! §e+" + coins + " §eCoins");
        Main.getInstance().getKills().put(attacker.getUniqueId(), Main.getInstance().getKills().get(attacker.getUniqueId()) + 1);
        Main.getInstance().getCoins().put(attacker.getUniqueId(), Main.getInstance().getCoins().get(attacker.getUniqueId()) + coins);
        victim.sendMessage("§9§lOneShot§8§l» §d" + attacker.getDisplayName() + " §7vous a tué !");
        if (Main.getInstance().getKit().get(attacker).equals("guerrier") || Main.getInstance().getKit().get(attacker).equals("acrobate")) {
            attacker.setHealth(4);
        }
        if (Main.getInstance().getKit().get(attacker).equals("oneshot")) {
            attacker.setHealth(6);
        }
        if (Main.getInstance().getKit().get(attacker).equals("tank")) {
            attacker.setHealth(8);
        }
        if (Main.getInstance().getKit().get(victim).equals("guerrier") || Main.getInstance().getKit().get(victim).equals("acrobate")) {
            victim.setHealth(4);
            victim.removePotionEffect(PotionEffectType.SPEED);
            victim.setAllowFlight(false);
        }
        if (Main.getInstance().getKit().get(victim).equals("oneshot")) {
            victim.setHealth(6);
            victim.removePotionEffect(PotionEffectType.SPEED);
            victim.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
        if (Main.getInstance().getKit().get(victim).equals("tank")) {
            victim.setHealth(8);
            victim.removePotionEffect(PotionEffectType.SLOW);
        }
        Main.getInstance().getPlayerCoolDown().put(victim.getUniqueId(), false);
        ItemStack arrow = new ItemBuilder(Material.ARROW, 2).setDisplayName("§7Flèche").toItemStack();
        attacker.getInventory().addItem(arrow);
        return;
    }

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
                if (Main.getInstance().getTortue().contains(victim)) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.getInstance().getInvunerability().contains(attacker) || Main.getInstance().getInvunerability().contains(victim)) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.getInstance().getKit().get(victim).equals("tank")) {
                    if (victim.getHealth() <= 8 && victim.getHealth() > 6) {
                        victim.setHealth(4);
                        return;
                    }
                }
                if (Main.getInstance().getKit().get(victim).equals("guerrier")) {
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
            if (Main.getInstance().getTortue().contains(victim)) {
                e.setCancelled(true);
                return;
            }
            if (Main.getInstance().getInvunerability().contains(attacker) || Main.getInstance().getInvunerability().contains(victim)) {
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
}