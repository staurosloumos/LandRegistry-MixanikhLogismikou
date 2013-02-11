/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import Model.Land;
import UI.InsertRecord;
import UI.SearchRecord;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

/**
 *
 * @author laftsis-loumos
 */
public class DB {

    // Defines the driver type.
    public enum DriverType {

        MySQL,
        Oracle,
        Access
    }
    public static boolean LoginValue = false;
    public static String Username = "";
    public static boolean UserLocked;
    // Default driver name for MySQL.
    private static final String mySQLDriverName = "com.mysql.jdbc.Driver";
    // Connect to a database and return an instance of the connection.

    public static Connection dbConnect(String database, DriverType type) {
        try {
            Connection dbConn = null;
            // Load the driver.
            switch (type) {
                case MySQL:
                    Class.forName(mySQLDriverName);
                    break;
                default:
                    return null;
            }
            String url = "jdbc:mysql://localhost:3306/" + database + "?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "root";
            dbConn = (Connection) DriverManager.getConnection(url, username, password);
            // Return connection to the database.
            return dbConn;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Null if we reach here.
        return null;
    }

    // Checks for a successful logon.
    public static boolean AttempLoginWith(String useraname, String password, Connection dbConn) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            // Create the statement.
            ps = dbConn.prepareStatement("SELECT * FROM users");
            // Set the results.
            rs = ps.executeQuery();
            while (rs.next()) {
                String usrname = rs.getString(2);
                String passwd = rs.getString(3);
                boolean locked = rs.getBoolean(5);
                // Check for locking first.
                if (usrname.equals(useraname) && locked) {
                    UserLocked = true;
                    LoginValue = false;
                    break;
                }
                if (usrname.equals(useraname) && passwd.equals(password)) {
                    LoginValue = true;
                    Username = rs.getString(4);
                    break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(InsertRecord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(InsertRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /* End of while loop here. */
        return LoginValue;
    }

    // Insert a Land Object into the database.
    public static int dbInsertLand(Land l, Connection dbConn) {
        PreparedStatement ps = null;
        try {
            // Create the SQL from our Database.
            String SQL = "INSERT INTO lands (landName, landPlace, landKAEK, landType, landPlan, landSize, landOccupy, landPerson) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            // Prepare the statement.
            ps = dbConn.prepareStatement(SQL);
            // Set attributes.
            ps.setString(1, l.getLandName());
            ps.setString(2, l.getLandPlace());
            ps.setInt(3, l.getKAEK());
            ps.setString(4, l.getLandType());
            ps.setString(5, l.getLandInfo());
            ps.setDouble(6, l.getLandSize());
            ps.setString(7, l.getLandOwn());
            ps.setInt(8, l.getPersonID());
            // Execute the query.
            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }

    // Load into a combobox all the persons in the database.
    public static void dbLoadCombo(final JComboBox c, Connection dbConn) {
        // Declare variables.
        PreparedStatement ps = null;
        ResultSet rs = null;
        final ArrayList<String> allItems = new ArrayList<String>();
        try {
            // Create the SQL from our Database.
            String SQL = "SELECT * FROM persons";
            // Prepare the statement.
            ps = dbConn.prepareStatement(SQL);
            rs = ps.executeQuery();
            // Add items into the combo.
            while (rs.next()) {
                int personID = rs.getInt(1);
                String personName = rs.getString(2);
                String personFullName = rs.getString(3);
                if (personName != null) {
                    allItems.add(String.valueOf(personID) + " | " + personName + " " + personFullName);
                }
            }
            // In B phase, we will use swing utilities to spawn a new thread so the GUI is respondable.
            // We remember always that Swing is on EDT.
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    for (String item : allItems) {
                        // Add the item.
                        c.addItem(item);
                    }
                }
            });

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(InsertRecord.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(InsertRecord.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // Insert a Land Object into the database.
    public static int dbUpdateLand(Land l, Connection dbConn) {
        PreparedStatement ps = null;
        try {
            // Create the SQL from our Database.            
            String SQL = "UPDATE lands SET landName = ?, landPlace = ?, landKAEK = ?, landType = ?, landPlan = ?, landSize = ?, landOccupy = ?, "
                    + "landPerson = ? WHERE landID = ?";
            // Prepare the statement.
            ps = dbConn.prepareStatement(SQL);
            // Set attributes.
            ps.setString(1, l.getLandName());
            ps.setString(2, l.getLandPlace());
            ps.setInt(3, l.getKAEK());
            ps.setString(4, l.getLandType());
            ps.setString(5, l.getLandInfo());
            ps.setDouble(6, l.getLandSize());
            ps.setString(7, l.getLandOwn());
            ps.setInt(8, l.getPersonID());
            ps.setInt(9, l.getLandID());
            // Execute the query.
            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    // Lock the user only, IT can unlock.

    public static int LockUser(String user, Connection dbConn) {
        PreparedStatement ps = null;
        try {
            // Create the SQL from our Database.            
            String SQL = "UPDATE users SET UserLocked= ? "
                    + "WHERE username = ?";
            // Prepare the statement.
            ps = dbConn.prepareStatement(SQL);
            // Set attributes.
            ps.setBoolean(1, true);
            ps.setString(2, user);

            // Execute the query.
            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    // Insert a Land Object into the database.

    public static int dbUpdateLandNoPerson(Land l, Connection dbConn) {
        PreparedStatement ps = null;
        try {
            // Create the SQL from our Database.            
            String SQL = "UPDATE lands SET landName = ?, landPlace = ?, landKAEK = ?, landType = ?, landPlan = ?, landSize = ?, landOccupy = ? "
                    + "WHERE landID = ?";
            // Prepare the statement.
            ps = dbConn.prepareStatement(SQL);
            // Set attributes.
            ps.setString(1, l.getLandName());
            ps.setString(2, l.getLandPlace());
            ps.setInt(3, l.getKAEK());
            ps.setString(4, l.getLandType());
            ps.setString(5, l.getLandInfo());
            ps.setDouble(6, l.getLandSize());
            ps.setString(7, l.getLandOwn());
            ps.setInt(8, l.getLandID());
            // Execute the query.
            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    // Insert a Land Object into the database.

    public static int dbDeleteRecord(Land l, Connection dbConn) {
        PreparedStatement ps = null;
        try {
            // Create the SQL from our Database.            
            String SQL = "DELETE FROM lands "
                    + "WHERE landID = ?";
            // Prepare the statement.
            ps = dbConn.prepareStatement(SQL);
            // Set attributes.                   
            ps.setInt(1, l.getLandID());
            // Execute the query.
            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 0;
    }
    // Load into a combobox all the persons in the database.

    public static ResultSet dbSearchLands(Land l, Connection dbConn, boolean all) {
        // Declare variables.
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 1, KAEK = -1, person = -1;
        double LandSize = 0;
        boolean hasLandName = false;
        boolean hasLandPlace = false;
        boolean hasKAEK = false;
        boolean hasLandType = false;
        boolean hasLandPlan = false;
        boolean hasLandSize = false;
        boolean hasLandOwn = false;
        boolean hasLandPerson = false;
        String SQL = "SELECT * FROM lands WHERE landID IS NOT NULL";
        try {
            // Create the SQL from our Database.
            if (!l.getLandName().isEmpty()) {
                hasLandName = true;
                SQL += " AND landName LIKE ?";
            }
            if (!l.getLandPlace().isEmpty()) {
                hasLandPlace = true;
                SQL += " AND landPlace LIKE ?";
            }
            // Create the SQL from our Database.
            try {
                KAEK = l.getKAEK();
                if (KAEK > 0) {
                    hasKAEK = true;
                    SQL += " AND landKAEK = ?";
                }
            } catch (NumberFormatException ex) {
                hasKAEK = false;
            }
            if (!l.getLandType().isEmpty()) {
                hasLandType = true;
                SQL += " AND landPlace LIKE ?";
            }
            if (!l.getLandInfo().isEmpty()) {
                hasLandPlan = true;
                SQL += " AND landPlan LIKE ?";
            }
            // Create the SQL from our Database.
            try {
                LandSize = l.getLandSize();
                if (LandSize > 0) {
                    hasLandSize = true;
                    SQL += " AND landSize = ?";
                }
            } catch (NumberFormatException ex) {
                hasLandSize = false;
            }
            if (!l.getLandOwn().isEmpty()) {
                hasLandOwn = true;
                SQL += " AND landOccupy LIKE ?";
            }
            try {
                if (!all) {
                    person = l.getPersonID();
                    hasLandPerson = true;
                    SQL += " AND landPerson = ?";
                }
            } catch (NumberFormatException ex) {
                hasLandPerson = false;
            }
            // Prepare the statement.
            ps = dbConn.prepareStatement(SQL);
            if (hasLandName) {
                ps.setString(i++, l.getLandName() + "%");
            }
            if (hasLandPlace) {
                ps.setString(i++, l.getLandPlace() + "%");
            }
            if (hasKAEK) {
                ps.setInt(i++, KAEK);
            }
            if (hasLandType) {
                ps.setString(i++, l.getLandType() + "%");
            }
            if (hasLandPlan) {
                ps.setString(i++, l.getLandInfo() + "%");
            }
            if (hasLandSize) {
                ps.setDouble(i++, LandSize);
            }
            if (hasLandOwn) {
                ps.setString(i++, l.getLandOwn() + "%");
            }
            if (hasLandPerson) {
                ps.setInt(i++, person);
            }
            // Finally execute the query and get the results.
            rs = ps.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Return the dataset with the records from the SQL according to the input criteria.
        return rs;
    }
}
