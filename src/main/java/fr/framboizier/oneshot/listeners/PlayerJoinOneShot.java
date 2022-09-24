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


        Main.getInstance().getDatabaseManager().createAccountOneShot(p.getUniqueId());
        Main.getInstance().getBddUpdate().getUpdateBdd(p);


        Main.getInstance().getGame().add(p);
        p.teleport(Main.getInstance().getLocations().getPos());
        p.setGameMode(GameMode.ADVENTURE);
        p.setHealthScale(6.0);
        p.setMaxHealth(6.0);
        p.setHealth(6);
        p.setFoodLevel(20);

        Main.getInstance().getKillstreak().put(p, 0);
        Main.getInstance().getKit().put(p, "oneshot");
        Main.getInstance().getPlayerCoolDown().put(p.getUniqueId(), false);
        p.setWalkSpeed(0.2F);

        p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        p.removePotionEffect(PotionEffectType.SPEED);
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 254, true, false));
        p.getInventory().clear();
        p.setAllowFlight(false);
        Main.getInstance().getPlay().itemHub(p);
    }

    @EventHandler
    public void playerquit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Main.getInstance().getBddUpdate().setUpdateBdd(p);
    }
}
