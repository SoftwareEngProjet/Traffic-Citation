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
    private Integer id;
    private String license;
    private String make;
    private Byte stolen;
    private Byte registered;
    private Byte wanted;
    private Integer driverId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "license")
    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Basic
    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Basic
    @Column(name = "stolen")
    public Byte getStolen() {
        return stolen;
    }

    public void setStolen(Byte stolen) {
        this.stolen = stolen;
    }

    @Basic
    @Column(name = "registered")
    public Byte getRegistered() {
        return registered;
    }

    public void setRegistered(Byte registered) {
        this.registered = registered;
    }

    @Basic
    @Column(name = "wanted")
    public Byte getWanted() {
        return wanted;
    }

    public void setWanted(Byte wanted) {
        this.wanted = wanted;
    }

    @Basic
    @Column(name = "driver_id")
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) &&
                Objects.equals(license, vehicle.license) &&
                Objects.equals(make, vehicle.make) &&
                Objects.equals(stolen, vehicle.stolen) &&
                Objects.equals(registered, vehicle.registered) &&
                Objects.equals(wanted, vehicle.wanted) &&
                Objects.equals(driverId, vehicle.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license, make, stolen, registered, wanted, driverId);
    }
}
