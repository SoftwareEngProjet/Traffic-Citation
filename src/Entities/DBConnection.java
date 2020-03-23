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
     * 2. Offense
     * 3. Citation
     * 4.
     */

    //  Driver Query Methods
    public Driver lookupDriver(String licenseNumber) {
        try {
            ResultSet queryResult = connect.createStatement().executeQuery("SELECT * FROM driver WHERE license = '" + licenseNumber + "'");

            // Record not found
            if (!queryResult.next())
                return null;

            Driver newDriver = new Driver(queryResult.getInt("id"),
                                          queryResult.getString("name"),
                                          queryResult.getByte("suspended"),
                                          queryResult.getByte("revoked"),
                                          queryResult.getDate("birthday"),
                                          queryResult.getString("license"));

            // Queries
            String ticketQuery = "SELECT * FROM ticket JOIN offense ON ticket.offense_id = offense.id WHERE offense.driver_id = '" + newDriver.getId() + "'";
            String citationQuery = "SELECT * FROM citation JOIN offense ON citation.offense_id = offense.id WHERE offense.driver_id = '" + newDriver.getId() + "'";
            String warrantQuery = "SELECT * FROM warrant JOIN offense ON warrant.offense_id = offense.id WHERE offense.driver_id = '" + newDriver.getId() + "'";

            // Execute Queries
            ResultSet ticketQueryResult = connect.createStatement().executeQuery(ticketQuery);
            ResultSet citationQueryResult = connect.createStatement().executeQuery(citationQuery);
            ResultSet warrantQueryResult = connect.createStatement().executeQuery(warrantQuery);

            // Create Instances if we have successful queries
            if (ticketQueryResult.next()) {
                newDriver.getOffenses().add(new Offense(ticketQueryResult.getInt("id"),
                                                        ticketQueryResult.getDate("date"),
                                                        ticketQueryResult.getBigDecimal("fine"),
                                                        ticketQueryResult.getByte("paid"),
                                                        ticketQueryResult.getInt("officer_id"),
                                                        ticketQueryResult.getInt("driver_id"),
                                                        "Ticket Offense"));
            }

            if (citationQueryResult.next()) {
                newDriver.getOffenses().add(new Offense(citationQueryResult.getInt("id"),
                                                        citationQueryResult.getDate("date"),
                                                        citationQueryResult.getBigDecimal("fine"),
                                                        citationQueryResult.getByte("paid"),
                                                        citationQueryResult.getInt("officer_id"),
                                                        citationQueryResult.getInt("driver_id"),
                                                        "Citation Offense"));
            }

            if (warrantQueryResult.next()) {
                newDriver.getOffenses().add(new Offense(warrantQueryResult.getInt("id"),
                                                        warrantQueryResult.getDate("date"),
                                                        warrantQueryResult.getBigDecimal("fine"),
                                                        warrantQueryResult.getByte("paid"),
                                                        warrantQueryResult.getInt("officer_id"),
                                                        warrantQueryResult.getInt("driver_id"),
                                                        "Warrant Offense"));
            }
            
            return newDriver;
        }

        catch (Exception ex) {
            return null;
        }
    }

    // Offense Query Methods
    public int insertOffense(Offense offense) {
        // Inserts a new offense and returns its database ID
        try {
            int offenseID;

            String query = "INSERT INTO offense (`date`, fine, paid, officer_id, driver_id)" +
                           " VALUES (" + "'" + offense.getDate() + "\'," + offense.getFine() + ',' +
                           offense.getPaid() + ',' + offense.getOfficerId() + ',' + offense.getDriverId() + ")";

            Statement statement = connect.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            // Get database ID
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()){
                offenseID = result.getInt(1);
                return offenseID;
            }

            else
                return -1;
        }

        catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    // Citation Query Methods
    public void insertCitation(Citation citation) {
        // Inserts a new citation
        try {
            String query = "INSERT INTO citation (offense_id, vehicle_id) VALUES (" + citation.getOffenseId() + ','
                                                + citation.getVehicleId() + ")";
            Statement statement = connect.createStatement();
            statement.executeUpdate(query);
        }

        catch (Exception ex) {
            ex.printStackTrace();
        }
    }



}