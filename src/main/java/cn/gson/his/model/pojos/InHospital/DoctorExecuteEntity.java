package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
@Table(name = "DOCTOR_EXECUTE", schema = "HIS", catalog = "")
public class DoctorExecuteEntity {
    private int exeId;
    private Timestamp exeDate;
    private Integer ensId;
    private Integer nurseId;
    private String nurseName;
    private String regMark;
    private Integer drugId;
    private String drugName;
    private String drugGe;
    private String drugDw;
    private Integer drugCount;
    private Long drugPrice;

    //主要登记表对象
    private HospitalRegisterEntity hospitalRegister;
    //科室对象
    private Department department;



    @Id
    @Column(name = "EXE_ID")
    public int getExeId() {
        return exeId;
    }

    public void setExeId(int exeId) {
        this.exeId = exeId;
    }

    @Basic
    @Column(name = "EXE_DATE")
    public Timestamp getExeDate() {
        return exeDate;
    }

    public void setExeDate(Timestamp exeDate) {
        this.exeDate = exeDate;
    }

    @Basic
    @Column(name = "ENS_ID")
    public Integer getEnsId() {
        return ensId;
    }

    public void setEnsId(Integer ensId) {
        this.ensId = ensId;
    }

    @Basic
    @Column(name = "NURSE_ID")
    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    @Basic
    @Column(name = "NURSE_NAME")
    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    @Basic
    @Column(name = "REG_MARK")
    public String getRegMark() {
        return regMark;
    }

    public void setRegMark(String regMark) {
        this.regMark = regMark;
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
    @Column(name = "DRUG_COUNT")
    public Integer getDrugCount() {
        return drugCount;
    }

    public void setDrugCount(Integer drugCount) {
        this.drugCount = drugCount;
    }

    @Basic
    @Column(name = "DRUG_PRICE")
    public Long getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Long drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorExecuteEntity that = (DoctorExecuteEntity) o;
        return exeId == that.exeId &&
                Objects.equals(exeDate, that.exeDate) &&
                Objects.equals(ensId, that.ensId) &&
                Objects.equals(nurseId, that.nurseId) &&
                Objects.equals(nurseName, that.nurseName) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(drugId, that.drugId) &&
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(drugGe, that.drugGe) &&
                Objects.equals(drugDw, that.drugDw) &&
                Objects.equals(drugCount, that.drugCount) &&
                Objects.equals(drugPrice, that.drugPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exeId, exeDate, ensId, nurseId, nurseName, regMark, drugId, drugName, drugGe, drugDw, drugCount, drugPrice);
    }

    @Override
    public String toString() {
        return "DoctorExecuteEntity{" +
                "exeId=" + exeId +
                ", exeDate=" + exeDate +
                ", ensId=" + ensId +
                ", nurseId=" + nurseId +
                ", nurseName='" + nurseName + '\'' +
                ", regMark='" + regMark + '\'' +
                ", drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugGe='" + drugGe + '\'' +
                ", drugDw='" + drugDw + '\'' +
                ", drugCount=" + drugCount +
                ", drugPrice=" + drugPrice +
                ", hospitalRegister=" + hospitalRegister +
                ", department=" + department +
                '}';
    }
}
