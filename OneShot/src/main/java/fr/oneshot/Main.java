package fr.oneshot;

import fr.oneshot.Mysql.BddManager;
import fr.oneshot.Mysql.PlayerInfo;
import fr.oneshot.cmd.OneShotHub;
import fr.oneshot.cmd.OneShotPos;
import fr.oneshot.listeners.*;
import fr.oneshot.utils.LocationsManagerOneShot;
import fr.oneshot.utils.PlayOneShot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin {
    public static String prefix = "§6§lOneShot §7» ";
    public static Main instance;
    public static HashMap<Player, Integer> killstreak = new HashMap<>();
    public static HashMap<Player, String> kit = new HashMap<>();
    public PlayOneShot play;
    public LocationsManagerOneShot locations;
    public BddManager database;
    public PlayerInfo pm;
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
        database = new BddManager("jdbc:mysql://", this.getConfig().getString("DB.Host"), this.getConfig().getString("DB.DB_Name"), this.getConfig().getString("DB.Username"), this.getConfig().getString("DB.Password"));
        database.connexion();
        instance = this;
        saveDefaultConfig();
    }

    public void registersCommands() {
        getCommand("setoneshothub").setExecutor(new OneShotHub());
        getCommand("setoneshotpos").setExecutor(new OneShotPos());

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
