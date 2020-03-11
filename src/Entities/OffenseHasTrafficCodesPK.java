package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OffenseHasTrafficCodesPK implements Serializable {
    private Integer offenseId;
    private Integer trafficCodesId;

    @Column(name = "offense_id")
    @Id
    public Integer getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(Integer offenseId) {
        this.offenseId = offenseId;
    }

    @Column(name = "traffic_codes_id")
    @Id
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
        OffenseHasTrafficCodesPK that = (OffenseHasTrafficCodesPK) o;
        return Objects.equals(offenseId, that.offenseId) &&
                Objects.equals(trafficCodesId, that.trafficCodesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offenseId, trafficCodesId);
    }
}
