package fr.oneshot.listeners;

import fr.oneshot.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class PlayerProjecticleHitOneShot implements Listener {
    String prefix = Main.prefix;

    @EventHandler
    public void projecticleHit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Arrow) {
            Arrow a = (Arrow) e.getDamager();
            Player v = (Player) e.getEntity();
            if (a.getShooter() instanceof Player) {
                Player attacker = (Player) a.getShooter();
                if (attacker == v) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.getInstance().tortue.contains(v)) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.getInstance().invunerability.contains(attacker) || Main.getInstance().invunerability.contains(v)) {
                    e.setCancelled(true);
                    return;
                }
                if (Main.kit.get(v) == "tank") {
                    if (v.getHealth() <= 8 && v.getHealth() > 6) {
                        v.setHealth(4);
                        return;
                    }
                }
                if (Main.kit.get(v) == "guerrier") {
                    if (v.getHealth() <= 4 && v.getHealth() > 2) {
                        v.setHealth(2);
                        return;
                    }
                }
                e.setCancelled(true);
                Random coins_random = new Random();
                int coins;
                coins = 1 + coins_random.nextInt(4);
                kill(attacker, v, coins);
                return;
            }
            return;
        }
        if (e.getDamager() instanceof Player) {
            Player v = (Player) e.getEntity();
            Player a = (Player) e.getDamager();
            if (Main.getInstance().tortue.contains(v)) {
                e.setCancelled(true);
                return;
            }
            if (Main.getInstance().invunerability.contains(a) || Main.getInstance().invunerability.contains(v)) {
                e.setCancelled(true);
                return;
            }
            if (a.getPlayer().getItemInHand().getType().equals(Material.DIAMOND_SWORD)) {
                if (v.getHealth() <= 8 && v.getHealth() > 6) {
                    v.setHealth(4);
                    return;
                }
                if (v.getHealth() <= 6) {
                    Random coins_random = new Random();
                    int coins;
                    coins = 1 + coins_random.nextInt(4);
                    kill(a, v, coins);
                    return;
                }
            }
            if (a.getPlayer().getItemInHand().getType().equals(Material.IRON_SWORD)) {
                if (v.getHealth() <= 8 && v.getHealth() > 6) {
                    v.setHealth(6);
                    return;
                }
                if (v.getHealth() <= 6 && v.getHealth() > 4) {
                    v.setHealth(3);
                    return;
                }
                if (v.getHealth() <= 4 && v.getHealth() > 3) {
                    v.setHealth(2);
                    return;
                }
                if (v.getHealth() <= 3) {
                    Random coins_random = new Random();
                    int coins;
                    coins = 1 + coins_random.nextInt(4);
                    kill(a, v, coins);
                    return;
                }
            }
            if (a.getPlayer().getItemInHand().getType().equals(Material.STONE_SWORD)) {
                if (v.getHealth() <= 8 && v.getHealth() > 6) {
                    v.setHealth(6);
                    return;
                }
                if (v.getHealth() <= 6 && v.getHealth() > 4) {
                    v.setHealth(4);
                    return;
                }
                if (v.getHealth() <= 4 && v.getHealth() > 2) {
                    v.setHealth(2);
                    return;
                }
                if (v.getHealth() <= 2) {
                    Random coins_random = new Random();
                    int coins;
                    coins = 1 + coins_random.nextInt(4);
                    kill(a, v, coins);
                    return;
                }

            }
        }
        return;
    }

    private void kill(Player attacker, Player victim, int coins) {
        victim.teleport(Main.getInstance().locations.getLobby());
        victim.getInventory().clear();
        ItemStack play = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta playM = play.getItemMeta();
        playM.setDisplayName(prefix + "§bJouer");
        play.setItemMeta(playM);

        ItemStack kit = new ItemStack(Material.CHEST, 1);
        ItemMeta kitM = kit.getItemMeta();
        kitM.setDisplayName("§eSelection de kit");
        kit.setItemMeta(kitM);

        victim.getInventory().setItem(4, play);
        victim.getInventory().setItem(8, kit);
        victim.playSound(victim.getLocation(), Sound.ANVIL_BREAK, 2, 2);
        attacker.playSound(victim.getLocation(), Sound.ORB_PICKUP, 2, 2);
        Main.killstreak.put(attacker.getPlayer(), Main.killstreak.get(attacker.getPlayer()) + 1);
        if (Main.killstreak.get(attacker) == 5) {
            Bukkit.broadcastMessage(prefix + attacker.getDisplayName() + " §fa fait une série de §c5 kill §f!");
        }
        if (Main.killstreak.get(attacker) == 10) {
            Bukkit.broadcastMessage(prefix + attacker.getDisplayName() + " §fa fait une série de §c10 kill §f!");
        }
        if (Main.killstreak.get(attacker) == 15) {
            Bukkit.broadcastMessage(prefix + attacker.getDisplayName() + " §fa fait une série de §415 kill §f!");
        }
        if (Main.killstreak.get(attacker) == 20) {
            Bukkit.broadcastMessage(prefix + attacker.getDisplayName() + " §fa fait une série de §420 kill §f!");
        }
        if (Main.killstreak.get(attacker) == 25) {
            Bukkit.broadcastMessage(prefix + attacker.getDisplayName() + " §fa fait une série de §4§l25 kill §f!");
        }
        if (Main.killstreak.get(attacker) == 30) {
            Bukkit.broadcastMessage(prefix + attacker.getDisplayName() + " §fVien de faire une §4§lNucleaire §f!");
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), Sound.WITHER_SPAWN, 4, 4);
            }
        }
        Main.killstreak.put(victim, 0);


        attacker.sendMessage("§9§lOneShot§8§l»" + " §fVous avez tué §d" + victim.getDisplayName() + " §f! §e+" + coins + " §eCoins");
        Main.getInstance().database.addKills(attacker.getUniqueId());
        Main.getInstance().database.addCoins(coins, attacker.getUniqueId());
        victim.sendMessage("§9§lOneShot§8§l» §d" + attacker.getDisplayName() + " §7vous a tué !");
        if (Main.kit.get(attacker) == "guerrier" || Main.kit.get(attacker) == "acrobate") {
            attacker.setHealth(4);
        }
        if (Main.kit.get(attacker) == "oneshot") {
            attacker.setHealth(6);
        }
        if (Main.kit.get(attacker) == "tank") {
            attacker.setHealth(8);
        }
        if (Main.kit.get(victim) == "guerrier" || Main.kit.get(victim) == "acrobate") {
            victim.setHealth(4);
            victim.removePotionEffect(PotionEffectType.SPEED);
            victim.setAllowFlight(false);
        }
        if (Main.kit.get(victim) == "oneshot") {
            victim.setHealth(6);
            victim.removePotionEffect(PotionEffectType.SPEED);
            victim.removePotionEffect(PotionEffectType.INVISIBILITY);
        }
        if (Main.kit.get(victim) == "tank") {
            victim.setHealth(8);
            victim.removePotionEffect(PotionEffectType.SLOW);
        }
        PlayerInteractOneShot.playercooldown.put(victim.getUniqueId(), false);
        ItemStack arrow = new ItemStack(Material.ARROW, 2);
        ItemMeta arrowM = arrow.getItemMeta();
        arrowM.setDisplayName("§7Flèche");
        arrow.setItemMeta(arrowM);
        attacker.getInventory().addItem(arrow);
        return;
    }
}