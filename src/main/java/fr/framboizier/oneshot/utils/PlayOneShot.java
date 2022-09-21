package fr.framboizier.oneshot.utils;

import fr.framboizier.oneshot.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayOneShot {
    private static void setArrow(Player player, int i, int ammount) {
        ItemStack arrow = new ItemBuilder(Material.ARROW, ammount).toItemStack();
        player.getInventory().setItem(i, arrow);
    }

    public void itemHub(Player p) {
        ItemStack play = new ItemBuilder(Material.DIAMOND_AXE).setDisplayName(Main.getInstance().prefix + "§bJouer").toItemStack();
        ItemStack kit = new ItemBuilder(Material.CHEST).setDisplayName("§eSelection de kit").toItemStack();
        p.getInventory().setItem(4, play);
        p.getInventory().setItem(8, kit);
    }

    public void playGame(Player p) {
        p.setGameMode(GameMode.ADVENTURE);
        p.setFoodLevel(20);
        p.getInventory().clear();
        // ARC
        ItemStack bow = new ItemBuilder(Material.BOW).setDisplayName("§6Arc").setLore("§8§l» §7Une flèche = Un mort !").setUnbreakable().addItemFlag(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES).toItemStack();
        // SWORD
        ItemStack stone_sword = new ItemBuilder(Material.STONE_SWORD).setDisplayName("§6Epée").setLore("§8§l» §7Trois Coups = Un mort !").setUnbreakable().addItemFlag(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES).toItemStack();
        ItemStack iron_sword = new ItemBuilder(Material.IRON_SWORD).setDisplayName("§6Epée").setLore("§8§l» §7Deux Coups = Un mort !").setUnbreakable().addItemFlag(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES).toItemStack();
        ItemStack diamond_sword = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayName("§6Epée").setLore("§8§l» §7Un Coup = Un mort !").setUnbreakable().addItemFlag(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES).toItemStack();
        //Ultime
        ItemStack invisible = new ItemBuilder(Material.FEATHER).setDisplayName("§1Invisilbe").toItemStack();
        ItemStack saut = new ItemBuilder(Material.SLIME_BALL).setDisplayName("§aSuper saut").toItemStack();
        ItemStack tortue = new ItemBuilder(Material.IRON_DOOR).setDisplayName("§8Tortue").toItemStack();
        // OBJETS QUI SE DONNE
        if (Main.getInstance().kit.get(p) == "oneshot") {
            p.setHealthScale(6.0);
            p.setMaxHealth(6.0);
            p.setHealth(6);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 0, true, false));
            if (Main.getInstance().bow.get(p.getUniqueId()) == 1) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 3);
                p.getInventory().setItem(2, invisible);
            } else if (Main.getInstance().bow.get(p.getUniqueId()) == 2) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, invisible);
            } else if (Main.getInstance().bow.get(p.getUniqueId()) == 3) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, invisible);
            } else if (Main.getInstance().bow.get(p.getUniqueId()) == 4) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, invisible);
            } else if (Main.getInstance().bow.get(p.getUniqueId()) == 5) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 7);
                p.getInventory().setItem(2, invisible);
            }
        }
        if (Main.getInstance().kit.get(p) == "guerrier") {
            p.setHealthScale(4.0);
            p.setMaxHealth(4.0);
            p.setHealth(4);
            if (Main.getInstance().guerrier.get(p.getUniqueId()) == 1) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, iron_sword);
                setArrow(p, 9, 2);
            } else if (Main.getInstance().guerrier.get(p.getUniqueId()) == 2) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, iron_sword);
                setArrow(p, 9, 4);
            } else if (Main.getInstance().guerrier.get(p.getUniqueId()) == 3) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, iron_sword);
                setArrow(p, 9, 4);
            } else if (Main.getInstance().guerrier.get(p.getUniqueId()) == 4) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, iron_sword);
                setArrow(p, 9, 4);
            } else if (Main.getInstance().guerrier.get(p.getUniqueId()) == 5) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, diamond_sword);
                setArrow(p, 9, 4);
            }
        }
        if (Main.getInstance().kit.get(p) == "acrobate") {
            p.setHealthScale(4.0);
            p.setMaxHealth(4.0);
            p.setHealth(4);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
            p.setAllowFlight(true);
            if (Main.getInstance().acrobate.get(p.getUniqueId()) == 1) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 3);
            } else if (Main.getInstance().acrobate.get(p.getUniqueId()) == 2) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
            } else if (Main.getInstance().acrobate.get(p.getUniqueId()) == 3) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, saut);
            } else if (Main.getInstance().acrobate.get(p.getUniqueId()) == 4) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, saut);
            } else if (Main.getInstance().acrobate.get(p.getUniqueId()) == 5) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, saut);
            }
        }
        if (Main.getInstance().kit.get(p) == "tank") {
            p.setHealthScale(8.0);
            p.setMaxHealth(8.0);
            p.setHealth(8);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1, true, false));
            if (Main.getInstance().tank.get(p.getUniqueId()) == 1) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 3);
                p.getInventory().setItem(2, tortue);
            } else if (Main.getInstance().tank.get(p.getUniqueId()) == 2) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 3);
                p.getInventory().setItem(2, tortue);
            } else if (Main.getInstance().tank.get(p.getUniqueId()) == 3) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, tortue);
            } else if (Main.getInstance().tank.get(p.getUniqueId()) == 4) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, tortue);
            } else if (Main.getInstance().tank.get(p.getUniqueId()) == 5) {
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, stone_sword);
                setArrow(p, 9, 5);
                p.getInventory().setItem(2, tortue);
            }
        }
    }
}
