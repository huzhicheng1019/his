package cn.gson.his.model.pojos.lrn;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PHYSICAL_PARTICULARS", schema = "HIS", catalog = "")
public class PhysicalParticularsEntity {
    private int particularsId;
    private Integer mealId;
    private Integer physicalId;
    private Integer particularsZt;
    private Integer reserveId;

    @Id
    @Column(name = "PARTICULARS_ID")
    public int getParticularsId() {
        return particularsId;
    }

    public void setParticularsId(int particularsId) {
        this.particularsId = particularsId;
    }

    @Basic
    @Column(name = "MEAL_ID")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @Basic
    @Column(name = "PHYSICAL_ID")
    public Integer getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(Integer physicalId) {
        this.physicalId = physicalId;
    }

    @Basic
    @Column(name = "PARTICULARS_ZT")
    public Integer getParticularsZt() {
        return particularsZt;
    }

    public void setParticularsZt(Integer particularsZt) {
        this.particularsZt = particularsZt;
    }

    @Basic
    @Column(name = "RESERVE_ID")
    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalParticularsEntity that = (PhysicalParticularsEntity) o;
        return particularsId == that.particularsId &&
                Objects.equals(mealId, that.mealId) &&
                Objects.equals(physicalId, that.physicalId) &&
                Objects.equals(particularsZt, that.particularsZt) &&
                Objects.equals(reserveId, that.reserveId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(particularsId, mealId, physicalId, particularsZt, reserveId);
    }
}
