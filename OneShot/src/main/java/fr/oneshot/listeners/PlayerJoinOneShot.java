package fr.oneshot.listeners;

import fr.oneshot.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoinOneShot implements Listener {
    String prefix = Main.prefix;

    @EventHandler
    public void playerjoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();


        Main.getInstance().database.createAccountOneShot(p.getUniqueId());


        Main.getInstance().game.add(p);
        p.teleport(Main.getInstance().locations.getLobby());
        p.setGameMode(GameMode.ADVENTURE);
        p.setHealthScale(6.0);
        p.setMaxHealth(6.0);
        p.setHealth(6);
        p.setFoodLevel(20);
        Main.killstreak.put(p, 0);
        Main.kit.put(p, "oneshot");
        PlayerInteractOneShot.playercooldown.put(p.getUniqueId(), false);
        p.setWalkSpeed(0.2F);

        p.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        p.removePotionEffect(PotionEffectType.SPEED);
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 254, true, false));
        p.getInventory().clear();
        p.setAllowFlight(false);
        ItemStack play = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta playM = play.getItemMeta();
        playM.setDisplayName(prefix + "§bJouer");
        play.setItemMeta(playM);


        ItemStack kit = new ItemStack(Material.CHEST, 1);
        ItemMeta kitM = kit.getItemMeta();
        kitM.setDisplayName("§eSelection de kit");
        kit.setItemMeta(kitM);

        p.getInventory().setItem(4, play);
        p.getInventory().setItem(8, kit);
    }
}
