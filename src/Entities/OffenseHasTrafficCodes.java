/******************************************************************************
 * File Name: OffenseHasTrafficCodes.java                                     *
 * Initial Version                                                            *
 ******************************************************************************
 * OffenseHasTrafficCodes object                                              *
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Packages
package Entities;

// Imports
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "offense_has_traffic_codes", schema = "mydb")
@IdClass(OffenseHasTrafficCodesPK.class)
public class OffenseHasTrafficCodes {
    // Variables
    private Integer offenseId;
    private Integer trafficCodesId;

    // No-arg Constructor
    public OffenseHasTrafficCodes() {
        offenseId = 0;
        trafficCodesId = 0;
    }

    // Multi-arg Constructor
    public OffenseHasTrafficCodes(Integer offenseId, Integer trafficCodesId) {
        this.offenseId = offenseId;
        this.trafficCodesId = trafficCodesId;
    }

    /* --- Class Methods Below ---
     * 1. Offense ID
     * 2. Traffic Codes
     */

    // Offense ID
    @Id
    @Column(name = "offense_id")
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    // Traffic Codes
    @Id
    @Column(name = "traffic_codes_id")
    public Integer getTrafficCodesId() {
        return trafficCodesId;
    }

    public void setTrafficCodesId(Integer trafficCodesId) {
        this.trafficCodesId = trafficCodesId;
    }
}
