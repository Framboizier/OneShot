package fr.framboizier.oneshot;

import fr.framboizier.oneshot.Mysql.BddAddHashMap;
import fr.framboizier.oneshot.cmd.OneShotHub;
import fr.framboizier.oneshot.cmd.OneShotPos;
import fr.framboizier.oneshot.cmd.OneShotUpdateBdd;
import fr.framboizier.oneshot.listeners.*;
import fr.framboizier.oneshot.utils.Kits;
import fr.framboizier.oneshot.utils.LocationsManagerOneShot;
import fr.framboizier.oneshot.utils.PlayOneShot;
import fr.framboizier.oneshot.Mysql.BddManager;
import fr.framboizier.oneshot.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {
    public static Main instance;
    public String prefix = "§6§lOneShot §7» ";
    public HashMap<UUID, Integer> coins = new HashMap<>();
    public HashMap<UUID, Integer> kills = new HashMap<>();
    public HashMap<UUID, Integer> bow = new HashMap<>();
    public HashMap<UUID, Integer> guerrier = new HashMap<>();
    public HashMap<UUID, Integer> acrobate = new HashMap<>();
    public HashMap<UUID, Integer> tank = new HashMap<>();


    public HashMap<Player, Integer> killstreak = new HashMap<>();
    public HashMap<Player, String> kit = new HashMap<>();
    public Map<UUID, Boolean> playercooldown = new HashMap<>();
    public PlayOneShot play;
    public LocationsManagerOneShot locations;
    public BddManager database;
    public Kits kits;
    public BddAddHashMap bddUpdate;
    public ArrayList<Player> invunerability = new ArrayList();
    public ArrayList<Player> game = new ArrayList();
    public ArrayList<Player> tortue = new ArrayList();

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
        bddUpdate = new BddAddHashMap();
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
}
