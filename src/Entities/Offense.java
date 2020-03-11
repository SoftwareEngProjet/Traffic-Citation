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
    private Integer id;
    private Date date;
    private BigDecimal fine;
    private Byte paid;
    private Integer officerId;
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
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "fine")
    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    @Basic
    @Column(name = "paid")
    public Byte getPaid() {
        return paid;
    }

    public void setPaid(Byte paid) {
        this.paid = paid;
    }

    @Basic
    @Column(name = "officer_id")
    public Integer getOfficerId() {
        return officerId;
    }

    public void setOfficerId(Integer officerId) {
        this.officerId = officerId;
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
        Offense offense = (Offense) o;
        return Objects.equals(id, offense.id) &&
                Objects.equals(date, offense.date) &&
                Objects.equals(fine, offense.fine) &&
                Objects.equals(paid, offense.paid) &&
                Objects.equals(officerId, offense.officerId) &&
                Objects.equals(driverId, offense.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, fine, paid, officerId, driverId);
    }
}
