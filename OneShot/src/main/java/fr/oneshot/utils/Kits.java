package fr.oneshot.utils;

import fr.oneshot.Mysql.PlayerInfo;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Kits {
    private static final String Kit = "§7➤ §eSelection de kit";

    public static void Kit(Player p) {
        PlayerInfo pinfo = new PlayerInfo(p);
        Inventory k = Bukkit.createInventory(null, 9, Kit);
        ItemStack oneshot1 = new ItemStack(Material.BOW);
        ItemMeta oneshot1M = oneshot1.getItemMeta();
        oneshot1M.setDisplayName("§1OneShot 1/5");
        oneshot1M.setLore(Arrays.asList("§7-Arc + 3 flèches", "§7-épée en pierre", "§7-Capacité ultime : invisible pendant 10 secondes", "§7toutes les 10 minutes", "§7-avantage: ", "§7-speed 1", "§7-inconvénient:", "§7-aucun"));
        oneshot1.setItemMeta(oneshot1M);

        ItemStack oneshot2 = new ItemStack(Material.BOW);
        ItemMeta oneshot2M = oneshot2.getItemMeta();
        oneshot2M.setDisplayName("§1OneShot 2/5");
        oneshot2M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : invisible pendant 10 secondes", "§7toutes les 10 minutes", "§7-avantage: ", "§7-speed 1", "§7-inconvénient:", "§7-aucun"));
        oneshot2.setItemMeta(oneshot2M);

        ItemStack oneshot3 = new ItemStack(Material.BOW);
        ItemMeta oneshot3M = oneshot3.getItemMeta();
        oneshot3M.setDisplayName("§1OneShot 3/5");
        oneshot3M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : invisible pendant 10 secondes", "§7toutes les 5 minutes", "§7-avantage: ", "§7-speed 1", "§7-inconvénient:", "§7-aucun"));
        oneshot3.setItemMeta(oneshot3M);

        ItemStack oneshot4 = new ItemStack(Material.BOW);
        ItemMeta oneshot4M = oneshot4.getItemMeta();
        oneshot4M.setDisplayName("§1OneShot 4/5");
        oneshot4M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : invisible pendant 30 secondes", "§7toutes les 5 minutes", "§7-avantage: ", "§7-speed 1", "§7-inconvénient:", "§7-aucun"));
        oneshot4.setItemMeta(oneshot4M);

        ItemStack oneshot5 = new ItemStack(Material.BOW);
        ItemMeta oneshot5M = oneshot5.getItemMeta();
        oneshot5M.setDisplayName("§1OneShot 5/5");
        oneshot5M.setLore(Arrays.asList("§7-Arc + 7 flèches", "§7-épée en pierre", "§7-Capacité ultime : invisible pendant 30 secondes", "§7toutes les 2 minutes", "§7-avantage: ", "§7-speed 1", "§7-inconvénient:", "§7-aucun"));
        oneshot5.setItemMeta(oneshot5M);

        ItemStack guerrier1 = new ItemStack(Material.IRON_SWORD);
        ItemMeta guerrier1M = guerrier1.getItemMeta();
        guerrier1M.setDisplayName("§bGuerrier 1/5");
        guerrier1M.setLore(Arrays.asList("§7-Arc + 2 flèches", "§7-épée en fer", "§7-Capacité ultime : dash en avant", "§7toutes les 10 minutes", "§7-avantage: ", "§7-n'est pas oneshot par l'arc", "§7-inconvénient:", "§7-2 coeur"));
        guerrier1.setItemMeta(guerrier1M);

        ItemStack guerrier2 = new ItemStack(Material.IRON_SWORD);
        ItemMeta guerrier2M = guerrier2.getItemMeta();
        guerrier2M.setDisplayName("§bGuerrier 2/5");
        guerrier2M.setLore(Arrays.asList("§7-Arc + 4 flèches", "§7-épée en fer", "§7-Capacité ultime : dash en avant", "§7toutes les 8 minutes", "§7-avantage: ", "§7-n'est pas oneshot par l'arc", "§7-inconvénient:", "§7-2 coeur"));
        guerrier2.setItemMeta(guerrier2M);

        ItemStack guerrier3 = new ItemStack(Material.IRON_SWORD);
        ItemMeta guerrier3M = guerrier3.getItemMeta();
        guerrier3M.setDisplayName("§bGuerrier 3/5");
        guerrier3M.setLore(Arrays.asList("§7-Arc + 4 flèches", "§7-épée en fer", "§7-Capacité ultime : dash en avant", "§7toutes les 4 minutes", "§7-avantage: ", "§7-n'est pas oneshot par l'arc", "§7-inconvénient:", "§7-2 coeur"));
        guerrier3.setItemMeta(guerrier3M);

        ItemStack guerrier4 = new ItemStack(Material.IRON_SWORD);
        ItemMeta guerrier4M = guerrier4.getItemMeta();
        guerrier4M.setDisplayName("§bGuerrier 4/5");
        guerrier4M.setLore(Arrays.asList("§7-Arc + 4 flèches", "§7-épée en fer", "§7-Capacité ultime : dash en avant", "§7toutes les 1 minute", "§7-avantage: ", "§7-n'est pas oneshot par l'arc", "§7-inconvénient:", "§7-2 coeur"));
        guerrier4.setItemMeta(guerrier4M);

        ItemStack guerrier5 = new ItemStack(Material.IRON_SWORD);
        ItemMeta guerrier5M = guerrier5.getItemMeta();
        guerrier5M.setDisplayName("§bGuerrier 5/5");
        guerrier5M.setLore(Arrays.asList("§7-Arc + 4 flèches", "§7-épée en diamant", "§7-Capacité ultime : dash en avant", "§7toutes les 30 secondes", "§7-avantage: ", "§7-n'est pas oneshot par l'arc", "§7-inconvénient:", "§7-2 coeur"));
        guerrier5.setItemMeta(guerrier5M);

        ItemStack acrobate1 = new ItemStack(Material.SLIME_BALL);
        ItemMeta acrobate1M = acrobate1.getItemMeta();
        acrobate1M.setDisplayName("§aacrobate 1/5");
        acrobate1M.setLore(Arrays.asList("§7-Arc + 3 flèches", "§7-épée en pierre", "§7-Capacité ultime : double saut", "§7-avantage: ", "§7-speed 2", "§7-inconvénient:", "§7-2 coeur"));
        acrobate1.setItemMeta(acrobate1M);

        ItemStack acrobate2 = new ItemStack(Material.SLIME_BALL);
        ItemMeta acrobate2M = acrobate2.getItemMeta();
        acrobate2M.setDisplayName("§aacrobate 2/5");
        acrobate2M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : double saut", "§7-avantage: ", "§7-speed 2", "§7-inconvénient:", "§7-2 coeur"));
        acrobate2.setItemMeta(acrobate2M);

        ItemStack acrobate3 = new ItemStack(Material.SLIME_BALL);
        ItemMeta acrobate3M = acrobate3.getItemMeta();
        acrobate3M.setDisplayName("§aacrobate 3/5");
        acrobate3M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : super saut + double saut", "§7toutes les 5 minutes", "§7-avantage: ", "§7-speed 2", "§7-inconvénient:", "§7-2 coeur"));
        acrobate3.setItemMeta(acrobate3M);

        ItemStack acrobate4 = new ItemStack(Material.SLIME_BALL);
        ItemMeta acrobate4M = acrobate4.getItemMeta();
        acrobate4M.setDisplayName("§aacrobate 4/5");
        acrobate4M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : super saut + double saut", "§7toutes les 2 minutes", "§7-avantage: ", "§7-speed 2", "§7-inconvénient:", "§7-2 coeur"));
        acrobate4.setItemMeta(acrobate4M);

        ItemStack acrobate5 = new ItemStack(Material.SLIME_BALL);
        ItemMeta acrobate5M = acrobate5.getItemMeta();
        acrobate5M.setDisplayName("§aacrobate 5/5");
        acrobate5M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : super saut + double saut", "§7toutes les 30 secondes", "§7-avantage: ", "§7-speed 2", "§7-inconvénient:", "§7-2 coeur"));
        acrobate5.setItemMeta(acrobate5M);

        ItemStack tank1 = new ItemStack(Material.IRON_DOOR);
        ItemMeta tank1M = tank1.getItemMeta();
        tank1M.setDisplayName("§8Tank 1/5");
        tank1M.setLore(Arrays.asList("§7-Arc + 3 flèches", "§7-épée en pierre", "§7-Capacité ultime : mode tortue pendant 10 secondes", "§7toutes les 10 minutes", "§7-avantage: ", "§7-4 coeurs", "§7-inconvénient:", "§7-slowness 2"));
        tank1.setItemMeta(tank1M);

        ItemStack tank2 = new ItemStack(Material.IRON_DOOR);
        ItemMeta tank2M = tank2.getItemMeta();
        tank2M.setDisplayName("§8Tank 2/5");
        tank2M.setLore(Arrays.asList("§7-Arc + 3 flèches", "§7-épée en pierre", "§7-Capacité ultime : mode tortue pendant 10 secondes", "§7toutes les 8 minutes", "§7-avantage: ", "§7-4 coeurs", "§7-inconvénient:", "§7-slowness 2"));
        tank2.setItemMeta(tank2M);

        ItemStack tank3 = new ItemStack(Material.IRON_DOOR);
        ItemMeta tank3M = tank3.getItemMeta();
        tank3M.setDisplayName("§8Tank 3/5");
        tank3M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : mode tortue pendant 10 secondes", "§7toutes les 8 minutes", "§7-avantage: ", "§7-4 coeurs", "§7-inconvénient:", "§7-slowness 2"));
        tank3.setItemMeta(tank3M);

        ItemStack tank4 = new ItemStack(Material.IRON_DOOR);
        ItemMeta tank4M = tank4.getItemMeta();
        tank4M.setDisplayName("§8Tank 4/5");
        tank4M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : mode tortue pendant 30 secondes", "§7toutes les 8 minutes", "§7-avantage: ", "§7-4 coeurs", "§7-inconvénient:", "§7-slowness 2"));
        tank4.setItemMeta(tank4M);

        ItemStack tank5 = new ItemStack(Material.IRON_DOOR);
        ItemMeta tank5M = tank5.getItemMeta();
        tank5M.setDisplayName("§8Tank 5/5");
        tank5M.setLore(Arrays.asList("§7-Arc + 5 flèches", "§7-épée en pierre", "§7-Capacité ultime : mode tortue pendant 30 secondes", "§7toutes les 5 minutes", "§7-avantage: ", "§7-4 coeurs", "§7-inconvénient:", "§7-slowness 2"));
        tank5.setItemMeta(tank5M);

        if (pinfo.getBow() == 1 || pinfo.getBow() == 0) {
            k.setItem(1, oneshot1);
        } else if (pinfo.getBow() == 2) {
            k.setItem(1, oneshot2);
        } else if (pinfo.getBow() == 3) {
            k.setItem(1, oneshot3);
        } else if (pinfo.getBow() == 4) {
            k.setItem(1, oneshot4);
        } else {
            k.setItem(1, oneshot5);
        }
        if (pinfo.getGuerrier() == 1 || pinfo.getGuerrier() == 0) {
            k.setItem(3, guerrier1);
        } else if (pinfo.getGuerrier() == 2) {
            k.setItem(3, guerrier2);
        } else if (pinfo.getGuerrier() == 3) {
            k.setItem(3, guerrier3);
        } else if (pinfo.getGuerrier() == 4) {
            k.setItem(3, guerrier4);
        } else {
            k.setItem(3, guerrier5);
        }
        if (pinfo.getAcrobate() == 1 || pinfo.getAcrobate() == 0) {
            k.setItem(5, acrobate1);
        } else if (pinfo.getAcrobate() == 2) {
            k.setItem(5, acrobate2);
        } else if (pinfo.getAcrobate() == 3) {
            k.setItem(5, acrobate3);
        } else if (pinfo.getAcrobate() == 4) {
            k.setItem(5, acrobate4);
        } else {
            k.setItem(5, acrobate5);
        }
        if (pinfo.getTank() == 1 || pinfo.getTank() == 0) {
            k.setItem(7, tank1);
        } else if (pinfo.getTank() == 2) {
            k.setItem(7, tank2);
        } else if (pinfo.getTank() == 3) {
            k.setItem(7, tank3);
        } else if (pinfo.getTank() == 4) {
            k.setItem(7, tank4);
        } else {
            k.setItem(7, tank5);
        }

        p.openInventory(k);
    }
}
