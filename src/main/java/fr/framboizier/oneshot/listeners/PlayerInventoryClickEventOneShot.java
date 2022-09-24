package fr.framboizier.oneshot.listeners;

import fr.framboizier.oneshot.Main;
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
                if (Main.getInstance().getKit().get(p).equals("oneshot")) {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().getKit().put(p, "oneshot");
                p.sendMessage("§7Vous avez choisi le kit OneShot !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.IRON_SWORD)) {
                if (Main.getInstance().getGuerrier().get(p.getUniqueId()).equals(0)) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.getInstance().getKit().get(p).equals("guerrier")) {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().getKit().put(p, "guerrier");
                p.sendMessage("§7Vous avez choisi le kit Guerrier !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.SLIME_BALL)) {
                if (Main.getInstance().getAcrobate().get(p.getUniqueId()).equals(0)) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.getInstance().getKit().get(p).equals("acrobate")) {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().getKit().put(p, "acrobate");
                p.sendMessage("§7Vous avez choisi le kit Acrobate !");
                p.closeInventory();
            }
            if (it.getType().equals(Material.IRON_DOOR)) {
                if (Main.getInstance().getTank().get(p.getUniqueId()).equals(0)) {
                    p.sendMessage("§cVous n'avez pas ce kit !");
                    p.closeInventory();
                    return;
                }
                if (Main.getInstance().getKit().get(p).equals("tank")) {
                    p.sendMessage("§cVous avez deja ce kit d'activé !");
                    p.closeInventory();
                    return;
                }
                Main.getInstance().getKit().put(p, "tank");
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
