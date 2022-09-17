package fr.oneshot.listeners;

import fr.oneshot.Main;
import fr.oneshot.Mysql.PlayerInfo;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInventoryClickEventOneShot implements Listener {
    private static final String Kit = "§7➤ §eSelection de kit";

    @EventHandler
    public void onInventory(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack it = e.getCurrentItem();
        PlayerInfo pinfo = new PlayerInfo(p);
        if (it == null) return;
        if (e.getInventory().getTitle().equalsIgnoreCase(Kit)) {
            e.setCancelled(true);
            if (it.getType().equals(Material.BOW)) {
                if (Main.kit.get(p) == "oneshot") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.kit.put(p, "oneshot");
                p.sendMessage("§7Vous avez choisi le kit OneShot !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.IRON_SWORD)) {
                if (pinfo.getGuerrier() == 0) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.kit.get(p) == "guerrier") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.kit.put(p, "guerrier");
                p.sendMessage("§7Vous avez choisi le kit Guerrier !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.SLIME_BALL)) {
                if (pinfo.getAcrobate() == 0) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.kit.get(p) == "acrobate") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.kit.put(p, "acrobate");
                p.sendMessage("§7Vous avez choisi le kit Acrobate !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.IRON_DOOR)) {
                if (pinfo.getTank() == 0) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.kit.get(p) == "tank") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.kit.put(p, "tank");
                p.sendMessage("§7Vous avez choisi le kit Tank !");
                p.closeInventory();
            }
        }
        if (p.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        if (e.getCurrentItem() != null) {
            e.setCancelled(true);
        }
        return;


    }
}
