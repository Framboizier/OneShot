package fr.oneshot.utils;

import fr.oneshot.Main;
import fr.oneshot.Mysql.PlayerInfo;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class PlayOneShot {
    public void playGame(Player p){
        PlayerInfo pinfo = new PlayerInfo((Player) p);
        p.setGameMode(GameMode.ADVENTURE);
        p.setFoodLevel(20);
        p.getInventory().clear();
        // ARC
        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowM = bow.getItemMeta();
        bowM.setDisplayName("§6Arc");
        bowM.setLore(Arrays.asList("§8§l» §7Une flèche = Un mort !"));
        bowM.spigot().setUnbreakable(true);
        bowM.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        bow.setItemMeta(bowM);
        // FLECHE
        ItemStack arrow = new ItemStack(Material.ARROW, 3);
        ItemMeta arrowM = arrow.getItemMeta();
        arrowM.setDisplayName("§7Flèche");
        arrow.setItemMeta(arrowM);
        ItemStack arrow1 = new ItemStack(Material.ARROW, 5);
        ItemMeta arrowM1 = arrow1.getItemMeta();
        arrowM1.setDisplayName("§7Flèche");
        arrow1.setItemMeta(arrowM1);
        ItemStack arrow2 = new ItemStack(Material.ARROW, 7);
        ItemMeta arrowM2 = arrow2.getItemMeta();
        arrowM2.setDisplayName("§7Flèche");
        arrow2.setItemMeta(arrowM2);
        ItemStack arrow3 = new ItemStack(Material.ARROW, 2);
        ItemMeta arrowM3 = arrow3.getItemMeta();
        arrowM3.setDisplayName("§7Flèche");
        arrow3.setItemMeta(arrowM3);
        ItemStack arrow4 = new ItemStack(Material.ARROW, 4);
        ItemMeta arrowM4 = arrow4.getItemMeta();
        arrowM4.setDisplayName("§7Flèche");
        arrow4.setItemMeta(arrowM4);
        // SWORD
        ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta swordM = sword.getItemMeta();
        swordM.setDisplayName("§6Epée");
        swordM.setLore(Arrays.asList("§8§l» §7Trois Coups = Un mort !"));
        swordM.spigot().setUnbreakable(true);
        swordM.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        sword.setItemMeta(swordM);
        ItemStack sword1 = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta swordM1 = sword1.getItemMeta();
        swordM1.setDisplayName("§6Epée");
        swordM1.setLore(Arrays.asList("§8§l» §7Deux Coups = Un mort !"));
        swordM1.spigot().setUnbreakable(true);
        swordM1.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        sword1.setItemMeta(swordM1);
        ItemStack sword2 = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta swordM2 = sword2.getItemMeta();
        swordM2.setDisplayName("§6Epée");
        swordM2.setLore(Arrays.asList("§8§l» §7Un Coup = Un mort !"));
        swordM2.spigot().setUnbreakable(true);
        swordM2.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ATTRIBUTES);
        sword2.setItemMeta(swordM2);
        //Ultime
        ItemStack invisible = new ItemStack(Material.FEATHER, 1);
        ItemMeta invisibleM = invisible.getItemMeta();
        invisibleM.setDisplayName("§1Invisible");
        invisible.setItemMeta(invisibleM);
        ItemStack saut = new ItemStack(Material.SLIME_BALL, 1);
        ItemMeta sautM = saut.getItemMeta();
        sautM.setDisplayName("§aSuper saut");
        saut.setItemMeta(sautM);
        ItemStack tortue = new ItemStack(Material.IRON_DOOR, 1);
        ItemMeta tortueM = tortue.getItemMeta();
        tortueM.setDisplayName("§8Tortue");
        tortue.setItemMeta(tortueM);
        // OBJETS QUI SE DONNE
        if (Main.kit.get(p) == "oneshot"){
            p.setHealthScale(6.0);
            p.setMaxHealth(6.0);
            p.setHealth(6);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,Integer.MAX_VALUE,0,true,false));
            if (pinfo.getBow() == 1){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow);
                p.getInventory().setItem(2,invisible);
            }
            else if (pinfo.getBow() == 2){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,invisible);
            }
            else if (pinfo.getBow() == 3){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,invisible);
            }
            else if (pinfo.getBow() == 4){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,invisible);
            }
            else if (pinfo.getBow() == 5){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow2);
                p.getInventory().setItem(2,invisible);
            }
        }
        if (Main.kit.get(p) == "guerrier"){
            p.setHealthScale(4.0);
            p.setMaxHealth(4.0);
            p.setHealth(4);
            if (pinfo.getGuerrier() == 1){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword1);
                p.getInventory().setItem(9, arrow3);
            }
            else if (pinfo.getGuerrier() == 2){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword1);
                p.getInventory().setItem(9, arrow4);
            }
            else if (pinfo.getGuerrier() == 3){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword1);
                p.getInventory().setItem(9, arrow4);
            }
            else if (pinfo.getGuerrier() == 4){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword1);
                p.getInventory().setItem(9, arrow4);
            }
            else if (pinfo.getGuerrier() == 5){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword2);
                p.getInventory().setItem(9, arrow4);
            }
        }
        if (Main.kit.get(p) == "acrobate"){
            p.setHealthScale(4.0);
            p.setMaxHealth(4.0);
            p.setHealth(4);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,Integer.MAX_VALUE,1,true,false));
            p.setAllowFlight(true);
            if (pinfo.getAcrobate() == 1){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow);
            }
            else if (pinfo.getAcrobate() == 2){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
            }
            else if (pinfo.getAcrobate() == 3){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,saut);
            }
            else if (pinfo.getAcrobate() == 4){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,saut);
            }
            else if (pinfo.getAcrobate() == 5){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,saut);
            }
        }
        if (Main.kit.get(p) == "tank"){
            p.setHealthScale(8.0);
            p.setMaxHealth(8.0);
            p.setHealth(8);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,1,true,false));
            if (pinfo.getTank() == 1){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow);
                p.getInventory().setItem(2,tortue);
            }
            else if (pinfo.getTank() == 2){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow);
                p.getInventory().setItem(2,tortue);
            }
            else if (pinfo.getTank() == 3){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,tortue);
            }
            else if (pinfo.getTank() == 4){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,tortue);
            }
            else if (pinfo.getTank() == 5){
                p.getInventory().setItem(1, bow);
                p.getInventory().setItem(0, sword);
                p.getInventory().setItem(9, arrow1);
                p.getInventory().setItem(2,tortue);
            }
        }
    }
}
