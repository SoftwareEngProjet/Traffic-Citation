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
import java.util.Objects;

@Entity
@Table(name = "traffic_codes", schema = "mydb")
public class TrafficCodes {
    private Integer id;
    private String description;
    private Byte violation;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "violation")
    public Byte getViolation() {
        return violation;
    }

    public void setViolation(Byte violation) {
        this.violation = violation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficCodes that = (TrafficCodes) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(violation, that.violation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, violation);
    }
}
