package fr.oneshot.listeners;

import fr.oneshot.Main;
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
        if (it == null) return;
        if (e.getInventory().getTitle().equalsIgnoreCase(Kit)) {
            e.setCancelled(true);
            if (it.getType().equals(Material.BOW)) {
                if (Main.getInstance().kit.get(p) == "oneshot") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().kit.put(p, "oneshot");
                p.sendMessage("§7Vous avez choisi le kit OneShot !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.IRON_SWORD)) {
                if (Main.getInstance().guerrier.get(p.getUniqueId()) == 0) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.getInstance().kit.get(p) == "guerrier") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().kit.put(p, "guerrier");
                p.sendMessage("§7Vous avez choisi le kit Guerrier !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.SLIME_BALL)) {
                if (Main.getInstance().acrobate.get(p.getUniqueId()) == 0) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.getInstance().kit.get(p) == "acrobate") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().kit.put(p, "acrobate");
                p.sendMessage("§7Vous avez choisi le kit Acrobate !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.IRON_DOOR)) {
                if (Main.getInstance().tank.get(p.getUniqueId()) == 0) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.getInstance().kit.get(p) == "tank") {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().kit.put(p, "tank");
                p.sendMessage("§7Vous avez choisi le kit Tank !");
                p.closeInventory();
            }
        }
        if (e.getCurrentItem() != null) {
            e.setCancelled(true);
        }
        return;


    }
}
