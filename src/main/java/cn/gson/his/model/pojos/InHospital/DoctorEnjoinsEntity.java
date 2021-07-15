package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DOCTOR_ENJOINS", schema = "HIS", catalog = "")
public class DoctorEnjoinsEntity {
    private int ensId;
    private Integer enId;
    private Integer drugId;
    private Integer ensState;
    private Integer ensType;
    private Integer ensCount;

    @Id
    @Column(name = "ENS_ID")
    public int getEnsId() {
        return ensId;
    }

    public void setEnsId(int ensId) {
        this.ensId = ensId;
    }

    @Basic
    @Column(name = "EN_ID")
    public Integer getEnId() {
        return enId;
    }

    public void setEnId(Integer enId) {
        this.enId = enId;
    }

    @Basic
    @Column(name = "DRUG_ID")
    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    @Basic
    @Column(name = "ENS_STATE")
    public Integer getEnsState() {
        return ensState;
    }

    public void setEnsState(Integer ensState) {
        this.ensState = ensState;
    }

    @Basic
    @Column(name = "ENS_TYPE")
    public Integer getEnsType() {
        return ensType;
    }

    public void setEnsType(Integer ensType) {
        this.ensType = ensType;
    }

    @Basic
    @Column(name = "ENS_COUNT")
    public Integer getEnsCount() {
        return ensCount;
    }

    public void setEnsCount(Integer ensCount) {
        this.ensCount = ensCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEnjoinsEntity that = (DoctorEnjoinsEntity) o;
        return ensId == that.ensId &&
                Objects.equals(enId, that.enId) &&
                Objects.equals(drugId, that.drugId) &&
                Objects.equals(ensState, that.ensState) &&
                Objects.equals(ensType, that.ensType) &&
                Objects.equals(ensCount, that.ensCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ensId, enId, drugId, ensState, ensType, ensCount);
    }
}
