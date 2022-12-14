package fr.framboizier.oneshot.mysql;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.UUID;

public class BddManager {
    private static Connection connection;
    private final String jdbcDriver = "com.mysql.jdbc.Driver";
    private final String urlbase;
    private final String host;
    private final String database;
    private final String username;
    private final String pass;
    private Statement statement;


    public BddManager(String urlbase, String host, String database, String username, String pass) {
        this.urlbase = urlbase;
        this.host = host;
        this.database = database;
        this.username = username;
        this.pass = pass;
    }

    public static Connection getConnection() {
        return connection;
    }

    private void createTable() {
        String myTableName = "CREATE TABLE OneShot("
                + "name VARCHAR (255) NOT NULL,"
                + "uuid VARCHAR(255),"
                + "ip VARCHAR(255),"
                + "coins INT(11),"
                + "kills INT(11),"
                + "bow INT(11),"
                + "guerrier INT(11),"
                + "acrobate INT(11),"
                + "tank INT(11),"
                + "PRIMARY KEY (name))";
        try {
            Class.forName(jdbcDriver);
            statement = connection.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        } catch (SQLException e) {
            System.out.println("An error has occurred on Table Creation or he's already created");
        } catch (ClassNotFoundException e) {
            System.out.println("An Mysql drivers were not found");
        }
    }

    public void addCoins(float amount, UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET coins = coins + ? WHERE uuid = ?");
            ps.setFloat(1, amount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addKills(UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET kills = kills + ? WHERE uuid = ?");
            ps.setFloat(1, 1);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delCoins(float amount, UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET coins = coins - ? WHERE uuid = ?");
            ps.setFloat(1, amount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getCoins(UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("SELECT coins FROM OneShot WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            Integer coins = 0;

            while (rs.next()) {
                coins = rs.getInt("coins");
            }
            ps.close();

            return coins;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public Integer getKills(UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("SELECT kills FROM OneShot WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            Integer kills = 0;

            while (rs.next()) {
                kills = rs.getInt("kills");
            }
            ps.close();

            return kills;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public Integer getBow(UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("SELECT bow FROM OneShot WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            Integer bow = 0;

            while (rs.next()) {
                bow = rs.getInt("bow");
            }
            ps.close();

            return bow;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public Integer getGuerrier(UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("SELECT guerrier FROM OneShot WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            Integer guerrier = 0;

            while (rs.next()) {
                guerrier = rs.getInt("guerrier");
            }
            ps.close();

            return guerrier;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }


    public Integer getAcrobate(UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("SELECT acrobate FROM OneShot WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            Integer acrobate = 0;

            while (rs.next()) {
                acrobate = rs.getInt("acrobate");
            }
            ps.close();

            return acrobate;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }


    public Integer getTank(UUID uuid) {
        try {
            PreparedStatement ps = BddManager.getConnection().prepareStatement("SELECT tank FROM OneShot WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            Integer tank = 0;

            while (rs.next()) {
                tank = rs.getInt("tank");
            }
            ps.close();

            return tank;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public void setCoins(UUID uuid, int ammount) {
        try {

            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET coins = ? WHERE uuid = ?");
            ps.setString(2, uuid.toString());
            ps.setInt(1, ammount);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setKills(UUID uuid, int ammount) {
        try {

            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET kills = ? WHERE uuid = ?");
            ps.setString(2, uuid.toString());
            ps.setInt(1, ammount);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBow(Player p, int ammount) {
        try {

            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET bow = ? WHERE uuid = ?");
            ps.setString(2, p.getUniqueId().toString());
            ps.setInt(1, ammount);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setGuerrier(Player p, int ammount) {
        try {

            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET guerrier = ? WHERE uuid = ?");
            ps.setString(2, p.getUniqueId().toString());
            ps.setInt(1, ammount);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setAcrobate(Player p, int ammount) {
        try {

            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET acrobate = ? WHERE uuid = ?");
            ps.setString(2, p.getUniqueId().toString());
            ps.setInt(1, ammount);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setTank(Player p, int ammount) {
        try {

            PreparedStatement ps = BddManager.getConnection().prepareStatement("UPDATE OneShot SET tank = ? WHERE uuid = ?");
            ps.setString(2, p.getUniqueId().toString());
            ps.setInt(1, ammount);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void connexion() { // M??thode de connexion
        if (!isOnline()) {
            try {
                connection = DriverManager.getConnection(this.urlbase + this.host + "/" + this.database, this.username, this.pass);
                System.out.println("[OneShot] Successfully connected to a database !");
                createTable();
                return;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public void disconnect() { // M??thode de d??connexion
        if (isOnline()) {
            try {
                connection.close();
                System.out.println("[OneShot] Successfully disconnected to a database !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isOnline() { // M??thode pour d??t??cter si la base de donn?? est en ligne ou non !
        try {
            return (connection != null) && (!connection.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void createAccountOneShot(UUID uuid) {

        if (!hasAccountOneShot(uuid)) {
            try {
                PreparedStatement ps = connection.prepareStatement("INSERT INTO OneShot (name, uuid, ip,coins, kills,bow,guerrier,acrobate,tank) VALUES (?, ?,?, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, Bukkit.getPlayer(uuid).getName());
                ps.setString(2, uuid.toString());
                ps.setString(3, Bukkit.getPlayer(uuid).getAddress().getHostString());
                ps.setInt(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 1);
                ps.setInt(7, 0);
                ps.setInt(8, 0);
                ps.setInt(9, 0);

                ps.execute();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
    }

    public boolean hasAccountOneShot(UUID uuid) {

        try {

            PreparedStatement ps = connection.prepareStatement("SELECT uuid FROM OneShot WHERE uuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
