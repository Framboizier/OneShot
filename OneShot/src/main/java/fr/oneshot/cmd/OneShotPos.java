package fr.oneshot.cmd;

import fr.oneshot.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OneShotPos implements CommandExecutor {
    String prefix = Main.prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("setoneshotpos")) {
                if (p.isOp()) {
                    if (args.length == 0) {
                        p.sendMessage(prefix + "§c/setoneshotpos [numéro]");
                        return true;
                    }
                    if (args.length == 1) {
                        int pos = Integer.valueOf(args[0]);
                        if (args[0].equalsIgnoreCase("1")) {

                            Location pos_loc = p.getLocation();
                            Main.getInstance().locations.setPos1(pos_loc, pos);
                        }
                        if (args[0].equalsIgnoreCase("2")) {

                            Location pos_loc = p.getLocation();
                            Main.getInstance().locations.setPos2(pos_loc, pos);
                        }
                        if (args[0].equalsIgnoreCase("3")) {

                            Location pos_loc = p.getLocation();
                            Main.getInstance().locations.setPos3(pos_loc, pos);
                        }
                        if (args[0].equalsIgnoreCase("4")) {

                            Location pos_loc = p.getLocation();
                            Main.getInstance().locations.setPos4(pos_loc, pos);
                        }
                        if (args[0].equalsIgnoreCase("5")) {

                            Location pos_loc = p.getLocation();
                            Main.getInstance().locations.setPos5(pos_loc, pos);
                        }


                        p.sendMessage("§7La position §d" + pos + " §7a été défini !");
                    }
                }
            }


        }
        return false;
    }
}
