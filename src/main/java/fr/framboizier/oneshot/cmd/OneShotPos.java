package fr.framboizier.oneshot.cmd;

import fr.framboizier.oneshot.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OneShotPos implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.isOp()) {
                Main.getInstance().locations.setPos(p.getLocation());
                p.sendMessage("la position a été défini !");
                return true;
            }
            p.sendMessage("§cVous n'avez pas la permission !");
            return false;
        }
        return false;
    }
}
