package cn.gson.his.model.pojos.InHospital;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DOCTOR_ENJOINS", schema = "HIS", catalog = "")
public class DoctorEnjoinsEntity {
    private int ensId;
    private Integer enId;
    private Integer drugId;
    private String drugName;
    private String drugType;
    private String drugGe;
    private String drugDw;
    private String drugYf;
    @JsonFormat(timezone="GMT+8")
    private Timestamp ensStart;
    @JsonFormat(timezone = "GMT+8")
    private Timestamp ensEnd;
    private String drugDosage;
    private Integer ensAmount;
    private Long drugPrice;
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
    @Column(name = "DRUG_NAME")
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Basic
    @Column(name = "DRUG_TYPE")
    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    @Basic
    @Column(name = "DRUG_GE")
    public String getDrugGe() {
        return drugGe;
    }

    public void setDrugGe(String drugGe) {
        this.drugGe = drugGe;
    }

    @Basic
    @Column(name = "DRUG_DW")
    public String getDrugDw() {
        return drugDw;
    }

    public void setDrugDw(String drugDw) {
        this.drugDw = drugDw;
    }

    @Basic
    @Column(name = "DRUG_YF")
    public String getDrugYf() {
        return drugYf;
    }

    public void setDrugYf(String drugYf) {
        this.drugYf = drugYf;
    }

    @Basic
    @Column(name = "DRUG_DOSAGE")
    public String getDrugDosage() {
        return drugDosage;
    }

    public void setDrugDosage(String drugDosage) {
        this.drugDosage = drugDosage;
    }

    @Basic
    @Column(name = "ENS_AMOUNT")
    public Integer getEnsAmount() {
        return ensAmount;
    }

    public void setEnsAmount(Integer ensAmount) {
        this.ensAmount = ensAmount;
    }

    @Basic
    @Column(name = "DRUG_PRICE")
    public Long getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Long drugPrice) {
        this.drugPrice = drugPrice;
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
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(drugType, that.drugType) &&
                Objects.equals(drugGe, that.drugGe) &&
                Objects.equals(drugDw, that.drugDw) &&
                Objects.equals(drugYf, that.drugYf) &&
                Objects.equals(drugDosage, that.drugDosage) &&
                Objects.equals(ensAmount, that.ensAmount) &&
                Objects.equals(drugPrice, that.drugPrice) &&
                Objects.equals(ensState, that.ensState) &&
                Objects.equals(ensType, that.ensType) &&
                Objects.equals(ensCount, that.ensCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ensId, enId, drugId, drugName, drugType, drugGe, drugDw, drugYf, drugDosage, ensAmount, drugPrice, ensState, ensType, ensCount);
    }

    @Basic
    @Column(name = "ens_start")
    public Timestamp getEnsStart() {
        return ensStart;
    }

    public void setEnsStart(Timestamp ensStart) {
        this.ensStart = ensStart;
    }
    @Basic
    @Column(name = "ens_end")
    public Timestamp getEnsEnd() {
        return ensEnd;
    }

    public void setEnsEnd(Timestamp ensEnd) {
        this.ensEnd = ensEnd;
    }

    @Override
    public String toString() {
        return "DoctorEnjoinsEntity{" +
                "ensId=" + ensId +
                ", enId=" + enId +
                ", drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugType='" + drugType + '\'' +
                ", drugGe='" + drugGe + '\'' +
                ", drugDw='" + drugDw + '\'' +
                ", drugYf='" + drugYf + '\'' +
                ", ensStart=" + ensStart +
                ", ensEnd=" + ensEnd +
                ", drugDosage='" + drugDosage + '\'' +
                ", ensAmount=" + ensAmount +
                ", drugPrice=" + drugPrice +
                ", ensState=" + ensState +
                ", ensType=" + ensType +
                ", ensCount=" + ensCount +
                '}';
    }
}
