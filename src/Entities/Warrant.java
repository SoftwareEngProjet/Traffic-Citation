/******************************************************************************
 * File Name: Warrant.java                                                    *
 * Initial Version                                                            *
 ******************************************************************************
 * Warrant object instantiated when a driver commits a crime, from officer    *
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
public class Warrant extends Offense{
    // Variables
    private Integer offenseId;
    private String description;

    // No-arg Constructor
    public Warrant() {
        offenseId = 0;
        description = "";
    }

    // Multi-arg Constructor
    public Warrant(Integer offenseId, String description) {
        this.offenseId = offenseId;
        this.description = description;
    }

    /* --- Class Methods Below ---
     * 1. ID
     * 2. Description
     * 3. Violation
     */

    // Offense Id
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    // Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
