package fr.oneshot.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LocationsManagerOneShot {
    // CREATION DU LOCATIONS.YML
    private File file = new File("plugins/OneShot", "locations_oneshot.yml");
    private FileConfiguration locations = YamlConfiguration.loadConfiguration(this.file);

    // METHODE POUR SET LES POSITIONS
    public FileConfiguration getFile(){
        return this.locations;
    }
    public Integer getNumber(){
        int number = locations.getInt("number_pos");
        return number;
    }
    public void setPos(Location pos){
        Object[] posString;
        String categorie;
        if (!locations.contains("number_pos")){
            locations.set("number_pos",0);
        }
        locations.set("number_pos",locations.getInt("number_pos")+1);
        categorie = "oneshot_pos"+locations.getString("number_pos");
        posString = new Object[]{pos.getWorld().getName(),pos.getX(), pos.getY(),pos.getZ(),pos.getYaw(),pos.getPitch()};
        locations.set(categorie,posString);
        saveLocations();
    }
    public void setHub(Location pos){
        Object[] posString = new Object[]{pos.getWorld().getName(),pos.getX(), pos.getY(),pos.getZ(),pos.getYaw(),pos.getPitch()};
        locations.set("oneshothub",posString);
        saveLocations();
    }
    public Location getPos(int pos){
        String categorie = "oneshot_pos"+pos;
        List<Object> list = (List<Object>) locations.getList(categorie);
        return getLocation(list);
    }
    public Location getPos(){
        List<Object> list = (List<Object>) locations.getList("oneshothub");
        return getLocation(list);
    }

    private Location getLocation(List<Object> list) {
        String string = (String) list.get(0);
        World world = Bukkit.getWorld(string);
        double yawDouble = (double) list.get(4);
        double pitchDouble = (double) list.get(5);
        float yaw = (float) yawDouble;
        float pitch = (float) pitchDouble;
        double x = (double) list.get(1);
        double y = (double) list.get(2);
        double z = (double) list.get(3);
        Location location = new Location(world,x,y,z,yaw,pitch);
        return location;
    }


    // METHODE POUR SAUVEGARDER LA CONFIG
    public void saveLocations() {
        try {
            this.locations.save(this.file);
        } catch (Exception exception) {
        }
    }
}
