package fr.oneshot.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class PLayerFlyOneShot implements Listener {
    @EventHandler
    public void playerfly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
            Block b = p.getWorld().getBlockAt(p.getLocation().subtract(0, 2, 0));
            if (!b.getType().equals(Material.AIR)) {
                p.setVelocity(p.getLocation().getDirection().multiply(0.2));
                p.setVelocity(new Vector(p.getVelocity().getX(), 0.6, p.getVelocity().getZ()));
            }
        }
    }
}
