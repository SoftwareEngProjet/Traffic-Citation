/******************************************************************************
 * File Name: Vehicle.java                                                    *
 * Initial Version                                                            *
 ******************************************************************************
 * Vehicle object represents the info related to a driver's vehicle instance  *
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Packages
package Entities;

// Imports
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Vehicle {
    // Variables
    private Integer id;
    private String license;
    private String make;
    private Byte stolen;
    private Byte registered;
    private Byte wanted;
    private Integer driverId;

    // No-arg Constructor
    public Vehicle() {
        id = 0;
        license = "";
        make = "";
        stolen = 0;
        registered = 0;
        wanted = 0;
        driverId = 0;
    }

    // Multi-arg Constructor
    public Vehicle(Integer id, String license, String make, Byte stolen, Byte registered, Byte wanted, Integer driverId) {
        this.id = id;
        this.license = license;
        this.make = make;
        this.stolen = stolen;
        this.registered = registered;
        this.wanted = wanted;
        this.driverId = driverId;
    }

    /* --- Class Methods Below ---
     * 1. ID
     * 2. License
     * 3. Make
     * 4. Stolen
     * 5. Registered
     * 6. Wanted
     * 7. DriverID
     */

    // ID
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // License
    @Basic
    @Column(name = "license")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    // Make
    @Basic
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    // Stolen
    @Basic
    @Column(name = "stolen")
    public Byte getStolen() {
        return stolen;
    }

    public void setStolen(Byte stolen) {
        this.stolen = stolen;
    }

    // Registered
    @Basic
    @Column(name = "registered")
    public Byte getRegistered() {
        return registered;
    }

    public void setRegistered(Byte registered) {
        this.registered = registered;
    }

    // Wanted
    @Basic
    @Column(name = "wanted")
    public Byte getWanted() {
        return wanted;
    }

    public void setWanted(Byte wanted) {
        this.wanted = wanted;
    }

    // DriverID
    @Basic
    @Column(name = "driver_id")
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
