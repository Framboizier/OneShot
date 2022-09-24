package fr.framboizier.oneshot;

import fr.framboizier.oneshot.cmd.OneShotHub;
import fr.framboizier.oneshot.cmd.OneShotPos;
import fr.framboizier.oneshot.cmd.OneShotUpdateBdd;
import fr.framboizier.oneshot.listeners.*;
import fr.framboizier.oneshot.mysql.BddAddHashMap;
import fr.framboizier.oneshot.mysql.BddManager;
import fr.framboizier.oneshot.utils.Kits;
import fr.framboizier.oneshot.utils.LocationsManagerOneShot;
import fr.framboizier.oneshot.utils.PlayOneShot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {
    private static Main instance;


    private final String prefix = "§6§lOneShot §7» ";

    private final HashMap<UUID, Integer> coins = new HashMap<>();
    private final HashMap<UUID, Integer> kills = new HashMap<>();
    private final HashMap<UUID, Integer> bow = new HashMap<>();
    private final HashMap<UUID, Integer> guerrier = new HashMap<>();
    private final HashMap<UUID, Integer> acrobate = new HashMap<>();
    private final HashMap<UUID, Integer> tank = new HashMap<>();


    private final HashMap<Player, Integer> killstreak = new HashMap<>();
    private final HashMap<Player, String> kit = new HashMap<>();
    private final Map<UUID, Boolean> playercooldown = new HashMap<>();
    private PlayOneShot play;
    private LocationsManagerOneShot locations;
    private BddManager database;
    private Kits kits;
    private BddAddHashMap bddAddHashMap;
    private final ArrayList<Player> invunerability = new ArrayList();
    private final ArrayList<Player> game = new ArrayList();
    private final ArrayList<Player> tortue = new ArrayList();

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        registersCommands();
        registersListeners();
        locations = new LocationsManagerOneShot();
        play = new PlayOneShot();
        kits = new Kits();
        bddAddHashMap = new BddAddHashMap();
        database = new BddManager("jdbc:mysql://", this.getConfig().getString("DB.Host"), this.getConfig().getString("DB.DB_Name"), this.getConfig().getString("DB.Username"), this.getConfig().getString("DB.Password"));
        database.connexion();
        instance = this;
        saveDefaultConfig();
    }

    public void registersCommands() {
        getCommand("setoneshothub").setExecutor(new OneShotHub());
        getCommand("setoneshotpos").setExecutor(new OneShotPos());
        getCommand("updatebdd").setExecutor(new OneShotUpdateBdd());
    }

    public void registersListeners() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new PlayerInteractOneShot(), this);
        pm.registerEvents(new PlayerInventoryClickEventOneShot(), this);
        pm.registerEvents(new PlayerProjecticleHitOneShot(), this);
        pm.registerEvents(new PlayerBreakOneShot(), this);
        pm.registerEvents(new PlayerPlaceOneShot(), this);
        pm.registerEvents(new PickupItemOneShot(), this);
        pm.registerEvents(new PlayerJoinOneShot(), this);
        pm.registerEvents(new PLayerFlyOneShot(), this);
    }

    public String getPrefix() {
        return prefix;
    }

    public HashMap<UUID, Integer> getCoins() {
        return coins;
    }

    public HashMap<UUID, Integer> getKills() {
        return kills;
    }

    public HashMap<UUID, Integer> getBow() {
        return bow;
    }

    public HashMap<UUID, Integer> getGuerrier() {
        return guerrier;
    }

    public HashMap<UUID, Integer> getAcrobate() {
        return acrobate;
    }

    public HashMap<UUID, Integer> getTank() {
        return tank;
    }

    public HashMap<Player, Integer> getKillstreak() {
        return killstreak;
    }

    public HashMap<Player, String> getKit() {
        return kit;
    }

    public Map<UUID, Boolean> getPlayerCoolDown() {
        return playercooldown;
    }

    public PlayOneShot getPlay() {
        return play;
    }

    public LocationsManagerOneShot getLocations() {
        return locations;
    }

    public BddManager getDatabaseManager() {
        return database;
    }

    public Kits getKits() {
        return kits;
    }

    public BddAddHashMap getBddUpdate() {
        return bddAddHashMap;
    }

    public ArrayList<Player> getInvunerability() {
        return invunerability;
    }

    public ArrayList<Player> getGame() {
        return game;
    }

    public ArrayList<Player> getTortue() {
        return tortue;
    }

}
