/******************************************************************************
 * File Name: Ticket.java                                                     *
 * Initial Version                                                            *
 ******************************************************************************
 * Ticket object used when a ticket is being assigned to a driver object      *
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Packages
package Entities;

// Imports
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Ticket extends Offense{
    // Variables
    private Integer offenseId;

    // No-arg Constructor
    public Ticket() {
        offenseId = 0;
    }

    // Multi-arg Constructor
    public Ticket(Integer offenseId) {
        this.offenseId = offenseId;
    }

    /* --- Class Methods Below ---
     * 1. Offense Id
     */

    // Offense Id
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

}
