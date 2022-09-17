package fr.oneshot.cmd;

import fr.oneshot.Main;
import org.bukkit.Location;
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

            if (cmd.getName().equalsIgnoreCase("setoneshothub")) {
                if (p.isOp()) {
                    Location lobby = p.getLocation();
                    Main.getInstance().locations.setLobby(lobby);
                    p.sendMessage("§aAction effectuée avec succès !");
                    return true;
                }
                p.sendMessage(prefix + "§cVous n'avez pas la permission !");
                return true;

            }
        }

        return false;
    }
}
