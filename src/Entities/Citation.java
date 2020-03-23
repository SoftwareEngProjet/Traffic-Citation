/******************************************************************************
 * File Name: Citation.java                                                   *
 * Initial Version                                                            *
 ******************************************************************************
 * Citation object containing data pertaining to a citation from an officer   *
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
import java.sql.Date;
import java.util.Objects;

@Entity
public class Citation  extends Offense{
    // Variables
    private Integer offenseId;
    private Integer vehicleId;

    // No-arg Constructor
    public Citation() {
        offenseId = 0;
        vehicleId = 0;
    }

    // Multi-arg Constructor
    public Citation(Integer offenseId, Integer vehicleId) {
        this.offenseId = offenseId;
        this.vehicleId = vehicleId;
    }

    /* --- Class Methods Below ---
     * 1. Offense ID
     * 2. Vehicle ID
     */

    // Offense ID
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    // Vehicle ID
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }
}
