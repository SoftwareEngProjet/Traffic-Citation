/******************************************************************************
 * File Name: Officer.java                                                    *
 * Initial Version                                                            *
 ******************************************************************************
 * Officer object used to create officers which are required to cite people   *
 * (c) 2020 Uncanny-Varsett Traffic Citation                                  *
 ******************************************************************************
 * Created By: Matt Ferlaino                                                  *
 * Date:       Mar 11th 2020                                                  *
 ******************************************************************************/

// Package
package Entities;

// Import
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Officer {
    // Variables
    private Integer id;
    private String name;

    // No-arg Constructor
    public Officer() {
        id = 0;
        name = "";
    }

    // Multi-arg Constructor
    public Officer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /* --- Class Methods Below ---
     * 1. ID
     * 2. Name
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

    // Name
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
