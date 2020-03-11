/******************************************************************************
 * File Name: School.java                                                     *
 * Initial Version                                                            *
 ******************************************************************************
 * School object which represents driving school which is an option when cited*
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Package
package Entities;

// Imports
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class School {
    private Integer id;
    private Date dayOne;
    private Date dayTwo;
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
    @Column(name = "day_one")
    public Date getDayOne() {
        return dayOne;
    }

    public void setDayOne(Date dayOne) {
        this.dayOne = dayOne;
    }

    @Basic
    @Column(name = "day_two")
    public Date getDayTwo() {
        return dayTwo;
    }

    public void setDayTwo(Date dayTwo) {
        this.dayTwo = dayTwo;
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
        School school = (School) o;
        return Objects.equals(id, school.id) &&
                Objects.equals(dayOne, school.dayOne) &&
                Objects.equals(dayTwo, school.dayTwo) &&
                Objects.equals(driverId, school.driverId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayOne, dayTwo, driverId);
    }
}
