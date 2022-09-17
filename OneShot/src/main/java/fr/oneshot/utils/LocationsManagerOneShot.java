package fr.oneshot.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LocationsManagerOneShot {
    // CREATION DU LOCATIONS.YML
    public File file = new File("plugins/OneShot", "locations_oneshot.yml");
    public FileConfiguration locations = YamlConfiguration.loadConfiguration(this.file);

    // METHODE POUR SET LES POSITIONS
    public void setPos1(Location pos, int number_pos) {
        String categorie = "oneshot_pos" + number_pos;
        this.locations.set(categorie + ".world", pos.getWorld().getName());
        this.locations.set(categorie + ".x", pos.getX());
        this.locations.set(categorie + ".y", pos.getY());
        this.locations.set(categorie + ".z", pos.getZ());
        this.locations.set(categorie + ".yaw", pos.getYaw());
        this.locations.set(categorie + ".pitch", pos.getPitch());
        saveLocations();
    }

    public void setPos2(Location pos, int number_pos) {
        String categorie = "oneshot_pos" + number_pos;
        this.locations.set(categorie + ".world", pos.getWorld().getName());
        this.locations.set(categorie + ".x", pos.getX());
        this.locations.set(categorie + ".y", pos.getY());
        this.locations.set(categorie + ".z", pos.getZ());
        this.locations.set(categorie + ".yaw", pos.getYaw());
        this.locations.set(categorie + ".pitch", pos.getPitch());
        saveLocations();
    }

    public void setPos3(Location pos, int number_pos) {
        String categorie = "oneshot_pos" + number_pos;
        this.locations.set(categorie + ".world", pos.getWorld().getName());
        this.locations.set(categorie + ".x", pos.getX());
        this.locations.set(categorie + ".y", pos.getY());
        this.locations.set(categorie + ".z", pos.getZ());
        this.locations.set(categorie + ".yaw", pos.getYaw());
        this.locations.set(categorie + ".pitch", pos.getPitch());
        saveLocations();
    }

    public void setPos4(Location pos, int number_pos) {
        String categorie = "oneshot_pos" + number_pos;
        this.locations.set(categorie + ".world", pos.getWorld().getName());
        this.locations.set(categorie + ".x", pos.getX());
        this.locations.set(categorie + ".y", pos.getY());
        this.locations.set(categorie + ".z", pos.getZ());
        this.locations.set(categorie + ".yaw", pos.getYaw());
        this.locations.set(categorie + ".pitch", pos.getPitch());
        saveLocations();
    }

    public void setPos5(Location pos, int number_pos) {
        String categorie = "oneshot_pos" + number_pos;
        this.locations.set(categorie + ".world", pos.getWorld().getName());
        this.locations.set(categorie + ".x", pos.getX());
        this.locations.set(categorie + ".y", pos.getY());
        this.locations.set(categorie + ".z", pos.getZ());
        this.locations.set(categorie + ".yaw", pos.getYaw());
        this.locations.set(categorie + ".pitch", pos.getPitch());
        saveLocations();
    }

    // METHODE POUR SET LE LOBBY

    // METHODES POUR SE TP AU DIFFERENTES POSITIONS
    public Location getPos1() {
        String categorie = "oneshot_pos1";
        World w = Bukkit.getWorld(locations.getString(categorie + ".world"));
        double x = locations.getDouble(categorie + ".x");
        double y = locations.getDouble(categorie + ".y");
        double z = locations.getDouble(categorie + ".z");
        Location pos1 = new Location(w, x, y, z);
        pos1.setYaw(locations.getInt(categorie + ".yaw"));
        pos1.setPitch(locations.getInt(categorie + ".pitch"));
        return pos1;
    }

    public Location getPos2() {
        String categorie = "oneshot_pos2";
        World w = Bukkit.getWorld(locations.getString(categorie + ".world"));
        double x = locations.getDouble(categorie + ".x");
        double y = locations.getDouble(categorie + ".y");
        double z = locations.getDouble(categorie + ".z");
        Location pos2 = new Location(w, x, y, z);
        pos2.setYaw(locations.getInt(categorie + ".yaw"));
        pos2.setPitch(locations.getInt(categorie + ".pitch"));
        return pos2;
    }

    public Location getPos3() {
        String categorie = "oneshot_pos3";
        World w = Bukkit.getWorld(locations.getString(categorie + ".world"));
        double x = locations.getDouble(categorie + ".x");
        double y = locations.getDouble(categorie + ".y");
        double z = locations.getDouble(categorie + ".z");
        Location pos3 = new Location(w, x, y, z);
        pos3.setYaw(locations.getInt(categorie + ".yaw"));
        pos3.setPitch(locations.getInt(categorie + ".pitch"));
        return pos3;
    }

    public Location getPos4() {
        String categorie = "oneshot_pos4";
        World w = Bukkit.getWorld(locations.getString(categorie + ".world"));
        double x = locations.getDouble(categorie + ".x");
        double y = locations.getDouble(categorie + ".y");
        double z = locations.getDouble(categorie + ".z");
        Location pos4 = new Location(w, x, y, z);
        pos4.setYaw(locations.getInt(categorie + ".yaw"));
        pos4.setPitch(locations.getInt(categorie + ".pitch"));
        return pos4;
    }

    public Location getPos5() {
        String categorie = "oneshot_pos5";
        World w = Bukkit.getWorld(locations.getString(categorie + ".world"));
        double x = locations.getDouble(categorie + ".x");
        double y = locations.getDouble(categorie + ".y");
        double z = locations.getDouble(categorie + ".z");
        Location pos5 = new Location(w, x, y, z);
        pos5.setYaw(locations.getInt(categorie + ".yaw"));
        pos5.setPitch(locations.getInt(categorie + ".pitch"));
        return pos5;
    }

    // METHODE POUR TP AU LOBBY DU JEU
    public Location getLobby() {
        String categorie = "lobby_oneshot";
        World w = Bukkit.getWorld(locations.getString(categorie + ".world"));
        double x = locations.getDouble(categorie + ".x");
        double y = locations.getDouble(categorie + ".y");
        double z = locations.getDouble(categorie + ".z");
        Location lobby = new Location(w, x, y, z);
        lobby.setYaw(locations.getInt(categorie + ".yaw"));
        lobby.setPitch(locations.getInt(categorie + ".pitch"));
        return lobby;
    }

    public void setLobby(Location lobby) {
        String categorie = "lobby_oneshot";

        this.locations.set(categorie + ".world", lobby.getWorld().getName());
        this.locations.set(categorie + ".x", lobby.getX());
        this.locations.set(categorie + ".y", lobby.getY());
        this.locations.set(categorie + ".z", lobby.getZ());
        this.locations.set(categorie + ".yaw", lobby.getYaw());
        this.locations.set(categorie + ".pitch", lobby.getPitch());
        saveLocations();
    }

    // METHODE POUR SAUVEGARDER LA CONFIG
    public void saveLocations() {
        try {
            this.locations.save(this.file);
        } catch (Exception exception) {
        }
    }
}
