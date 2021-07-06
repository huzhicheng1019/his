package cn.gson.his.model.pojos.lrn;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PHYSICAL_MEAL", schema = "HIS", catalog = "")
public class PhysicalMealEntity {
    private Integer physicalId;
    private Integer mealId;

    @Basic
    @Column(name = "PHYSICAL_ID")
    public Integer getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(Integer physicalId) {
        this.physicalId = physicalId;
    }

    @Basic
    @Column(name = "MEAL_ID")
    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalMealEntity that = (PhysicalMealEntity) o;
        return Objects.equals(physicalId, that.physicalId) &&
                Objects.equals(mealId, that.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(physicalId, mealId);
    }
}
