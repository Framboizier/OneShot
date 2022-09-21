package fr.oneshot.cmd;

import fr.oneshot.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OneShotUpdateBdd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            Main.getInstance().bddUpdate.getUpdateBdd(p);
            p.sendMessage("§aaction effectué avec succès !");
            return true;
        }
        return false;
    }


}
