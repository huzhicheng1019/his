package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * 押金缴费表
 */

@Entity
@Table(name = "PREPAY", schema = "HIS", catalog = "")
public class PrepayEntity {
    private int preId;
    private String regMark;
    private Double preBalance;
    private Long preArrearage;

    //押金详表
    private List<PrepayDetailsEntity> prepayDetails;

    //病人信息
    private PatientdataEntity patientdata;

    @OneToOne
    public PatientdataEntity getPatientdata() {
        return patientdata;
    }

    public void setPatientdata(PatientdataEntity patientdata) {
        this.patientdata = patientdata;
    }

    //住院登记表
    private HospitalRegisterEntity hospitalRegisterEntity;

    @OneToOne
    public HospitalRegisterEntity getHospitalRegisterEntity() {
        return hospitalRegisterEntity;
    }

    public void setHospitalRegisterEntity(HospitalRegisterEntity hospitalRegisterEntity) {
        this.hospitalRegisterEntity = hospitalRegisterEntity;
    }

    @OneToMany
    public List<PrepayDetailsEntity> getPrepayDetails() {
        return prepayDetails;
    }

    public void setPrepayDetails(List<PrepayDetailsEntity> prepayDetails) {
        this.prepayDetails = prepayDetails;
    }

    @Id
    @Column(name = "PRE_ID")
    public int getPreId() {
        return preId;
    }

    public void setPreId(int preId) {
        this.preId = preId;
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
    @Column(name = "PRE_BALANCE")
    public Double getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(Double preBalance) {
        this.preBalance = preBalance;
    }

    @Basic
    @Column(name = "PRE_ARREARAGE")
    public Long getPreArrearage() {
        return preArrearage;
    }

    public void setPreArrearage(Long preArrearage) {
        this.preArrearage = preArrearage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrepayEntity that = (PrepayEntity) o;
        return preId == that.preId &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(preBalance, that.preBalance) &&
                Objects.equals(preArrearage, that.preArrearage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preId, regMark, preBalance, preArrearage);
    }

    @Override
    public String toString() {
        return "PrepayEntity{" +
                "preId=" + preId +
                ", regMark='" + regMark + '\'' +
                ", preBalance=" + preBalance +
                ", preArrearage=" + preArrearage +
                ", prepayDetails=" + prepayDetails +
                ", patientdata=" + patientdata +
                ", hospitalRegisterEntity=" + hospitalRegisterEntity +
                '}';
    }
}
