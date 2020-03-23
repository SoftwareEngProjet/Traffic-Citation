/******************************************************************************
 * File Name: ApplicationEntryPoint.java                                      *
 * Initial Version                                                            *
 ******************************************************************************
 * Applications main method                                                   *
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Package
package Entities;

// Imports
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;

public class DBConnection {
    // Variables
    private JTRCryptoSuite cipher;
    private Connection connect;

    // No-arg Constructor
    public DBConnection() {
        try {
            cipher = new JTRCryptoSuite("!!@@##$$%%^^&&**");
            connect = DriverManager.getConnection(
                    cipher.JTRDecrypt("US2d9xeSMuL9fMUIYDL0A/MQj/7UP+jVVgjMHWrFhDCoZPo7zX/vFbkcV2p5k+Eb"),
                    cipher.JTRDecrypt("3h6REVs10dHXrcIGBbVIPQ=="),
                    cipher.JTRDecrypt("1IEV/fKhXaElJXumYR3CdWgVPnnZzerHqmvazjhfO+U="));
        }


        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Multi-arg Constructor
    public DBConnection(String salt, String connectionURL, String plainTxtUsername, String plainTxtPassword) {
        try {
            cipher = new JTRCryptoSuite(salt);
            connect = DriverManager.getConnection(cipher.JTRDecrypt(cipher.JTREncrypt(connectionURL)),
                                                  cipher.JTRDecrypt(cipher.JTREncrypt(plainTxtUsername)),
                                                  cipher.JTRDecrypt(cipher.JTREncrypt(plainTxtPassword)));
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* -- DBConnection Methods --
     * 1. Driver
     * 2.
     * 3.
     * 4.
     */

    //  Driver Query Methods
    public Driver lookupDriverRecord(String licenseNumber) {
        try {
            ResultSet queryResult = connect.createStatement().executeQuery("SELECT * FROM driver WHERE name = '" + licenseNumber + "'");

            // Record not found
            if (!queryResult.next())
                return null;

            return new Driver(queryResult.getInt("id"),
                              queryResult.getString("name"),
                              queryResult.getByte("suspended"),
                              queryResult.getByte("revoked"),
                              queryResult.getDate("birthday"),
                              queryResult.getString("license"));
        }

        catch (Exception ex) {
            return null;
        }
    }

    // Offense Query Methods
    public int insertOffense(Offense offense) {
        // Inserts a new offense and returns its database ID
        int offenseID;
        try {
            String query = "INSERT INTO offense (`date`, fine, paid, officer_id, driver_id)" +
                    " VALUES (" + "'" + offense.getDate() + "\'," + offense.getFine() + ',' + offense.getPaid() + ',' +
                    offense.getOfficerId() + ',' + offense.getDriverId() + ");";
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            // Get database ID, Throw exception if this fails
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                offenseID = rs.getInt(1);
            }
            else {
                throw new Exception();
            }
        }
        catch (Exception ex) {
            return -1;
        }
        return offenseID;
    }

    // Citation Query Methods
    public void insertCitation(Citation citation) {
        // Inserts a new citation
        try {
            String query = "INSERT INTO citation (offense_id, vehicle_id) VALUES (" + citation.getOffenseId() + ',' + citation.getVehicleId() + ");";
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(query);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}