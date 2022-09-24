package fr.framboizier.oneshot.cmd;

import fr.framboizier.oneshot.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OneShotHub implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        String prefix = "§6§lOneShot §7» ";
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                Main.getInstance().getLocations().setHub(p.getLocation());
                p.sendMessage("§aAction effectuée avec succès !");
                return true;
            }
            p.sendMessage(prefix + "§cVous n'avez pas la permission !");
            return false;

        }

        return false;
    }
}
