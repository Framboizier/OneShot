package fr.oneshot.utils;

import fr.oneshot.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Kits {
    private static final String Kit = "§7➤ §eSelection de kit";

    public void Kit(Player p) {

        Inventory k = Bukkit.createInventory(null, 9, Kit);

        if (Main.getInstance().bow.get(p.getUniqueId()) == 1 || Main.getInstance().bow.get(p.getUniqueId()) == 0) {
            setItem(k,1,Material.BOW,"§1OneShot",1,3,"invisible",10,"seconds",10,"minutes","speed 1","aucun");
        } else if (Main.getInstance().bow.get(p.getUniqueId()) == 2) {
            setItem(k,1,Material.BOW,"§1OneShot",2,5,"invisible",10,"seconds",10,"minutes","speed 1","aucun");
        } else if (Main.getInstance().bow.get(p.getUniqueId()) == 3) {
            setItem(k,1,Material.BOW,"§1OneShot",3,5,"invisible",10,"seconds",5,"minutes","speed 1","aucun");
        } else if (Main.getInstance().bow.get(p.getUniqueId()) == 4) {
            setItem(k,1,Material.BOW,"§1OneShot",4,5,"invisible",30,"seconds",5,"minutes","speed 1","aucun");
        } else {
            setItem(k,1,Material.BOW,"§1OneShot",5,7,"invisible",30,"seconds",2,"minutes","speed 1","aucun");
        }
        if (Main.getInstance().guerrier.get(p.getUniqueId()) == 1 || Main.getInstance().guerrier.get(p.getUniqueId()) == 0) {
            setItem(k,3,Material.IRON_SWORD,"§bGuerrier",1,2,"épée en fer","dash en avant",10,"minutes","n'est pas oneshot par l'arc","2 coeur");
        } else if (Main.getInstance().guerrier.get(p.getUniqueId()) == 2) {
            setItem(k,3,Material.IRON_SWORD,"§bGuerrier",2,4,"épée en fer","dash en avant",8,"minutes","n'est pas oneshot par l'arc","2 coeur");
        } else if (Main.getInstance().guerrier.get(p.getUniqueId()) == 3) {
            setItem(k,3,Material.IRON_SWORD,"§bGuerrier",3,4,"épée en fer","dash en avant",4,"minutes","n'est pas oneshot par l'arc","2 coeur");
        } else if (Main.getInstance().guerrier.get(p.getUniqueId()) == 4) {
            setItem(k,3,Material.IRON_SWORD,"§bGuerrier",4,4,"épée en fer","dash en avant",1,"minutes","n'est pas oneshot par l'arc","2 coeur");
        } else {
            setItem(k,3,Material.IRON_SWORD,"§bGuerrier",5,4,"épée en diamant","dash en avant",30,"seconds","n'est pas oneshot par l'arc","2 coeur");
        }
        if (Main.getInstance().acrobate.get(p.getUniqueId()) == 1 || Main.getInstance().acrobate.get(p.getUniqueId()) == 0) {
            setItem(k,5,Material.SLIME_BALL,"§aacrobate",1,3,"double saut","speed 2","2 coeur");
        } else if (Main.getInstance().acrobate.get(p.getUniqueId()) == 2) {
            setItem(k,5,Material.SLIME_BALL,"§aacrobate",2,5,"double saut","speed 2","2 coeur");
        } else if (Main.getInstance().acrobate.get(p.getUniqueId()) == 3) {
            setItem(k,5,Material.SLIME_BALL,"§aacrobate",3,5,"super saut + double saut",5,"minutes","speed 2","2 coeur");
        } else if (Main.getInstance().acrobate.get(p.getUniqueId()) == 4) {
            setItem(k,5,Material.SLIME_BALL,"§aacrobate",4,5,"super saut + double saut",2,"minutes","speed 2","2 coeur");
        } else {
            setItem(k,5,Material.SLIME_BALL,"§aacrobate",5,5,"super saut + double saut",30,"seconds","speed 2","2 coeur");
        }
        if (Main.getInstance().tank.get(p.getUniqueId()) == 1 || Main.getInstance().tank.get(p.getUniqueId()) == 0) {
            setItem(k,7,Material.IRON_DOOR,"§8Tank",1,3,"mode tortue",10,"seconds",10,"minutes","4 coeurs","slowness 2");
        } else if (Main.getInstance().tank.get(p.getUniqueId()) == 2) {
            setItem(k,7,Material.IRON_DOOR,"§8Tank",2,3,"mode tortue",10,"seconds",8,"minutes","4 coeurs","slowness 2");
        } else if (Main.getInstance().tank.get(p.getUniqueId()) == 3) {
            setItem(k,7,Material.IRON_DOOR,"§8Tank",3,5,"mode tortue",10,"seconds",8,"minutes","4 coeurs","slowness 2");
        } else if (Main.getInstance().tank.get(p.getUniqueId()) == 4) {
            setItem(k,7,Material.IRON_DOOR,"§8Tank",4,5,"mode tortue",30,"seconds",8,"minutes","4 coeurs","slowness 2");
        } else {
            setItem(k,7,Material.IRON_DOOR,"§8Tank",5,5,"mode tortue",50,"seconds",5,"minutes","4 coeurs","slowness 2");
        }

        p.openInventory(k);
    }
    private static void setItem(Inventory inventory,int i,Material material,String kit,int level,int arrow,String ultimate,int wait,String waitType,String advantage,String inconvenience){
        String[] loreArray = new String[]{"§7-Arc + "+arrow+" flèches", "§7-épée en pierre", "§7-Capacité ultime :"+ultimate, "§7toutes les "+wait+" "+waitType, "§7-avantage: ", "§7-"+advantage, "§7-inconvénient:", "§7-"+inconvenience};
        List<String> lore = Arrays.asList(loreArray);
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(kit+" "+level+"/5").setLore(lore).toItemStack();
        inventory.setItem(i,itemStack);
    }
    private static void setItem(Inventory inventory,int i,Material material,String kit,int level,int arrow,String ultimate,String advantage,String inconvenience){
        String[] loreArray = new String[]{"§7-Arc + "+arrow+" flèches", "§7-épée en pierre", "§7-Capacité ultime :"+ultimate, "§7-avantage: ", "§7-"+advantage, "§7-inconvénient:", "§7-"+inconvenience};
        List<String> lore = Arrays.asList(loreArray);
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(kit+" "+level+"/5").setLore(lore).toItemStack();
        inventory.setItem(i,itemStack);
    }
    private static void setItem(Inventory inventory,int i,Material material,String kit,int level,int arrow,String sword,String ultimate,int wait,String waitType,String advantage,String inconvenience){
        String[] loreArray = new String[]{"§7-Arc + "+arrow+" flèches", "§7-"+sword, "§7-Capacité ultime : "+ultimate, "§7toutes les "+wait+" "+waitType, "§7-avantage: ", "§7-"+advantage, "§7-inconvénient:", "§7-"+inconvenience};
        List<String> lore = Arrays.asList(loreArray);
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(kit+" "+level+"/5").setLore(lore).toItemStack();
        inventory.setItem(i,itemStack);
    }
    private static void setItem(Inventory inventory,int i,Material material,String kit,int level,int arrow,String ultimate,int time,String timeType,int wait,String waitType,String advantage,String inconvenience){
        String[] loreArray = new String[]{"§7-Arc + "+arrow+" flèches", "§7-épée en pierre", "§7-Capacité ultime : "+ultimate+" pendant "+time+" "+timeType, "§7toutes les "+wait+" "+waitType, "§7-avantage: ", "§7-"+advantage, "§7-inconvénient:", "§7-"+inconvenience};
        List<String> lore = Arrays.asList(loreArray);
        ItemStack itemStack = new ItemBuilder(material).setDisplayName(kit+" "+level+"/5").setLore(lore).toItemStack();
        inventory.setItem(i,itemStack);
    }

}
