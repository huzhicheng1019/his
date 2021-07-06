package cn.gson.his.model.pojos.hzc;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "BED", schema = "HIS", catalog = "")
public class BedEntity {
    private int bedId;
    private Integer depaId;
    private Integer bedIs;
    private Long bedCost;

    @Id
    @Column(name = "BED_ID")
    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    @Basic
    @Column(name = "DEPA_ID")
    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    @Basic
    @Column(name = "BED_IS")
    public Integer getBedIs() {
        return bedIs;
    }

    public void setBedIs(Integer bedIs) {
        this.bedIs = bedIs;
    }

    @Basic
    @Column(name = "BED_COST")
    public Long getBedCost() {
        return bedCost;
    }

    public void setBedCost(Long bedCost) {
        this.bedCost = bedCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BedEntity bedEntity = (BedEntity) o;
        return bedId == bedEntity.bedId &&
                Objects.equals(depaId, bedEntity.depaId) &&
                Objects.equals(bedIs, bedEntity.bedIs) &&
                Objects.equals(bedCost, bedEntity.bedCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedId, depaId, bedIs, bedCost);
    }
}
