/******************************************************************************
 * File Name: Offense.java                                                    *
 * Initial Version                                                            *
 ******************************************************************************
 * Offense object which is filled by an officer for the traffic violations    *
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
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Offense {
    // Variables
    private Integer id;
    private Date date;
    private BigDecimal fine;
    private Byte paid;
    private Integer officerId;
    private Integer driverId;

    // No-arg Constructor
    public Offense() {
        id = 0;
        date = new Date(new java.util.Date().getDate());
        fine = BigDecimal.ZERO;
        paid = 0;
        officerId = 0;
        driverId = 0;
    }

    // Multi-arg Constructor
    public Offense(Integer id, Date date, BigDecimal fine, Byte paid, Integer officerId, Integer driverId) {
        this.id = id;
        this.date = date;
        this.fine = fine;
        this.paid = paid;
        this.officerId = officerId;
        this.driverId = driverId;
    }

    /* --- Class Methods Below ---
     * 1. ID
     * 2. Date
     * 3. Fine
     * 4. Paid
     * 5. Officer ID
     * 6. Driver ID
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

    // Date
    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Fine
    @Basic
    @Column(name = "fine")
    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    // Paid
    @Basic
    @Column(name = "paid")
    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }

    // Officer ID
    @Basic
    @Column(name = "officer_id")
    public Integer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
    }

    // Driver ID
    @Basic
    @Column(name = "driver_id")
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
