package Entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Citation {
    private Integer offenseId;
    private Integer vehicleId;

    @Id
    @Column(name = "offense_id")
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    @Basic
    @Column(name = "vehicle_id")
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citation citation = (Citation) o;
        return Objects.equals(offenseId, citation.offenseId) &&
                Objects.equals(vehicleId, citation.vehicleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offenseId, vehicleId);
    }
}
