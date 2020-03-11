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
import java.util.Objects;

@Entity
public class Ticket {
    private Integer offenseId;

    @Id
    @Column(name = "offense_id")
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(offenseId, ticket.offenseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offenseId);
    }
}
