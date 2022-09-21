package fr.oneshot.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickupItemOneShot implements Listener {
    @EventHandler
    public void pickupItem(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        e.setCancelled(true);


    }

    @EventHandler
    public void playerdrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode().equals(GameMode.CREATIVE)) {
            return;
        }
        e.setCancelled(true);
    }
}
