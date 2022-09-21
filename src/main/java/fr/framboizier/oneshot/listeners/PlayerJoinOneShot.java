package fr.framboizier.oneshot.listeners;

import fr.framboizier.oneshot.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoinOneShot implements Listener {

    @EventHandler
    public void playerjoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();


        Main.getInstance().database.createAccountOneShot(p.getUniqueId());
        Main.getInstance().bddUpdate.getUpdateBdd(p);


        Main.getInstance().game.add(p);
        p.teleport(Main.getInstance().locations.getPos());
        p.setGameMode(GameMode.ADVENTURE);
        p.setHealthScale(6.0);
        p.setMaxHealth(6.0);
        p.setHealth(6);
        p.setFoodLevel(20);

        Main.getInstance().killstreak.put(p, 0);
        Main.getInstance().kit.put(p, "oneshot");
        Main.getInstance().playercooldown.put(p.getUniqueId(), false);
        p.setWalkSpeed(0.2F);

        p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        p.removePotionEffect(PotionEffectType.SPEED);
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 254, true, false));
        p.getInventory().clear();
        p.setAllowFlight(false);
        Main.getInstance().play.itemHub(p);
    }

    @EventHandler
    public void playerquit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Main.getInstance().bddUpdate.setUpdateBdd(p);
    }
}
