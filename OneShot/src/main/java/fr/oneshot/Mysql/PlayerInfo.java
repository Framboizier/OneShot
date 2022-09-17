package fr.oneshot.Mysql;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerInfo {
    private static final Map<Player, PlayerInfo> playerInfo = new HashMap<Player, PlayerInfo>();
    private final Player p;
    private final BddManager bdd;

    public PlayerInfo(Player p) {
        this.p = p;
        this.bdd = new BddManager(p.getUniqueId());
        playerInfo.put(p, this);
    }

    public static PlayerInfo getInfosPlayer(Player p) {
        return playerInfo.get(p);
    }

    public Player getP() {
        return p;
    }

    public Integer getBow() {
        return bdd.getBow();
    }

    public Integer getGuerrier() {
        return bdd.getGuerrier();
    }

    public Integer getAcrobate() {
        return bdd.getAcrobate();
    }

    public Integer getTank() {
        return bdd.getTank();
    }
}
