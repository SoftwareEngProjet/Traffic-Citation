/******************************************************************************
 * File Name: OffenseHasTrafficCodesPK.java                                   *
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
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OffenseHasTrafficCodesPK implements Serializable {
    // Variables
    private Integer offenseId;
    private Integer trafficCodesId;

    // No-arg Constructor
    public OffenseHasTrafficCodesPK() {
        offenseId = 0;
        trafficCodesId = 0;
    }

    // Multi-arg Constructor
    public OffenseHasTrafficCodesPK(Integer offenseId, Integer trafficCodesId) {
        this.offenseId = offenseId;
        this.trafficCodesId = trafficCodesId;
    }

    /* --- Class Methods Below ---
     * 1. Offense ID
     * 2. Traffic Codes ID
     */

    // Offense ID
    @Column(name = "offense_id")
    @Id
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    // Traffic Codes ID
    @Column(name = "traffic_codes_id")
    @Id
    public Integer getTrafficCodesId() {
        return trafficCodesId;
    }

    public void setTrafficCodesId(Integer trafficCodesId) {
        this.trafficCodesId = trafficCodesId;
    }
}
