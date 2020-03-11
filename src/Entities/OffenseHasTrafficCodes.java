package Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "offense_has_traffic_codes", schema = "mydb")
@IdClass(OffenseHasTrafficCodesPK.class)
public class OffenseHasTrafficCodes {
    private Integer offenseId;
    private Integer trafficCodesId;

    @Id
    @Column(name = "offense_id")
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    @Id
    @Column(name = "traffic_codes_id")
    public Integer getTrafficCodesId() {
        return trafficCodesId;
    }

    public void setTrafficCodesId(Integer trafficCodesId) {
        this.trafficCodesId = trafficCodesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffenseHasTrafficCodes that = (OffenseHasTrafficCodes) o;
        return Objects.equals(offenseId, that.offenseId) &&
                Objects.equals(trafficCodesId, that.trafficCodesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offenseId, trafficCodesId);
    }
}
