package fr.framboizier.oneshot.Mysql;

import fr.framboizier.oneshot.Main;
import org.bukkit.entity.Player;

public class BddAddHashMap {
    public void getUpdateBdd(Player p) {
        Main.getInstance().coins.put(p.getUniqueId(), Main.getInstance().database.getCoins(p.getUniqueId()));
        Main.getInstance().kills.put(p.getUniqueId(), Main.getInstance().database.getKills(p.getUniqueId()));
        Main.getInstance().bow.put(p.getUniqueId(), Main.getInstance().database.getBow(p.getUniqueId()));
        Main.getInstance().guerrier.put(p.getUniqueId(), Main.getInstance().database.getGuerrier(p.getUniqueId()));
        Main.getInstance().acrobate.put(p.getUniqueId(), Main.getInstance().database.getAcrobate(p.getUniqueId()));
        Main.getInstance().tank.put(p.getUniqueId(), Main.getInstance().database.getTank(p.getUniqueId()));
    }

    public void setUpdateBdd(Player p) {
        Main.getInstance().database.setCoins(p.getUniqueId(), Main.getInstance().coins.get(p.getUniqueId()));
        Main.getInstance().database.setKills(p.getUniqueId(), Main.getInstance().kills.get(p.getUniqueId()));
        Main.getInstance().database.setBow(p, Main.getInstance().bow.get(p.getUniqueId()));
        Main.getInstance().database.setGuerrier(p, Main.getInstance().guerrier.get(p.getUniqueId()));
        Main.getInstance().database.setAcrobate(p, Main.getInstance().acrobate.get(p.getUniqueId()));
        Main.getInstance().database.setTank(p, Main.getInstance().tank.get(p.getUniqueId()));
    }
}
