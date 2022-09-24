package fr.framboizier.oneshot.mysql;

import fr.framboizier.oneshot.Main;
import org.bukkit.entity.Player;

public class BddAddHashMap {
    public void getUpdateBdd(Player p) {
        Main.getInstance().getCoins().put(p.getUniqueId(), Main.getInstance().getDatabaseManager().getCoins(p.getUniqueId()));
        Main.getInstance().getKills().put(p.getUniqueId(), Main.getInstance().getDatabaseManager().getKills(p.getUniqueId()));
        Main.getInstance().getBow().put(p.getUniqueId(), Main.getInstance().getDatabaseManager().getBow(p.getUniqueId()));
        Main.getInstance().getGuerrier().put(p.getUniqueId(), Main.getInstance().getDatabaseManager().getGuerrier(p.getUniqueId()));
        Main.getInstance().getAcrobate().put(p.getUniqueId(), Main.getInstance().getDatabaseManager().getAcrobate(p.getUniqueId()));
        Main.getInstance().getTank().put(p.getUniqueId(), Main.getInstance().getDatabaseManager().getTank(p.getUniqueId()));
    }

    public void setUpdateBdd(Player p) {
        Main.getInstance().getDatabaseManager().setCoins(p.getUniqueId(), Main.getInstance().getCoins().get(p.getUniqueId()));
        Main.getInstance().getDatabaseManager().setKills(p.getUniqueId(), Main.getInstance().getKills().get(p.getUniqueId()));
        Main.getInstance().getDatabaseManager().setBow(p, Main.getInstance().getBow().get(p.getUniqueId()));
        Main.getInstance().getDatabaseManager().setGuerrier(p, Main.getInstance().getGuerrier().get(p.getUniqueId()));
        Main.getInstance().getDatabaseManager().setAcrobate(p, Main.getInstance().getAcrobate().get(p.getUniqueId()));
        Main.getInstance().getDatabaseManager().setTank(p, Main.getInstance().getTank().get(p.getUniqueId()));
    }
}
