package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PHYSICAL_FRUIT", schema = "HIS", catalog = "")
public class PhysicalFruitEntity {
    private int fruitId;
    private Integer reserveId;
    private String fruitResult;
    private String fruitShow;

    @Id
    @Column(name = "FRUIT_ID")
    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    @Basic
    @Column(name = "RESERVE_ID")
    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    @Basic
    @Column(name = "FRUIT_RESULT")
    public String getFruitResult() {
        return fruitResult;
    }

    public void setFruitResult(String fruitResult) {
        this.fruitResult = fruitResult;
    }

    @Basic
    @Column(name = "FRUIT_SHOW")
    public String getFruitShow() {
        return fruitShow;
    }

    public void setFruitShow(String fruitShow) {
        this.fruitShow = fruitShow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalFruitEntity that = (PhysicalFruitEntity) o;
        return fruitId == that.fruitId &&
                Objects.equals(reserveId, that.reserveId) &&
                Objects.equals(fruitResult, that.fruitResult) &&
                Objects.equals(fruitShow, that.fruitShow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruitId, reserveId, fruitResult, fruitShow);
    }
}
