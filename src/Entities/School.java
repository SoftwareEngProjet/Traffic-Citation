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
    // Variables
    private Integer id;
    private Date dayOne;
    private Date dayTwo;
    private Integer driverId;

    // No-arg Constructor
    public School() {
        id = 0;
        dayOne = new Date(new java.util.Date().getDate());
        dayTwo = new Date(new java.util.Date().getDate());
        driverId = 0;
    }

    // Multi-arg Constructor
    public School(Integer id, Date dayOne, Date dayTwo, Integer driverId) {
        this.id = id;
        this.dayOne = dayOne;
        this.dayTwo = dayTwo;
        this.driverId = driverId;
    }

    public School(Integer id, Date dayOne, Integer driverId) {
        this.id = id;
        this.dayOne = dayOne;
        this.driverId = driverId;
    }


    /* --- Class Methods Below ---
     * 1. ID
     * 2. Day One
     * 3. Day Two
     * 4. Driver Id
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

    // Day One
    @Basic
    @Column(name = "day_one")
    public Date getDayOne() {
        return dayOne;
    }

    public void setDayOne(Date dayOne) {
        this.dayOne = dayOne;
    }

    // Day Two
    @Basic
    @Column(name = "day_two")
    public Date getDayTwo() {
        return dayTwo;
    }

    public void setDayTwo(Date dayTwo) {
        this.dayTwo = dayTwo;
    }

    // Driver Id
    @Basic
    @Column(name = "driver_id")
    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }
}
