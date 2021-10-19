/******************************************************************************
 * File Name: TrafficCodes.java                                               *
 * Initial Version                                                            *
 ******************************************************************************
 * Traffic violations are represented in the traffic codes object for citation*
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Entities
package Entities;

// Imports
import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "traffic_codes", schema = "mydb")
public class TrafficCodes {
    // Variables
    private Integer id;
    private String description;
    private Byte violation;

    // No-arg Constructor
    public TrafficCodes() {
        id = 0;
        description = "";
        violation = violation;
    }

    // Multi-arg Constructor
    public TrafficCodes(Integer id, String description, Byte violation) {
        this.id = id;
        this.description = description;
        this.violation = violation;
    }

    /* --- Class Methods Below ---
     * 1. ID
     * 2. Description
     * 3. Violation
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

    // Description
    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Violation
    @Basic
    @Column(name = "violation")
    public Byte getViolation() {
        return violation;
    }

    public void setViolation(Byte violation) {
        this.violation = violation;
    }
}
