package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "THE_HOSPITAL", schema = "HIS", catalog = "")
public class TheHospitalEntity {
    private int hospitalNo;
    private Integer patientNo;
    private Timestamp hospitalDate;
    private String hosptalHospital;
    private Integer depaId;
    private Integer hospitalState;

    @Id
    @Column(name = "HOSPITAL_NO")
    public int getHospitalNo() {
        return hospitalNo;
    }

    public void setHospitalNo(int hospitalNo) {
        this.hospitalNo = hospitalNo;
    }

    @Basic
    @Column(name = "PATIENT_NO")
    public Integer getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(Integer patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "HOSPITAL_DATE")
    public Timestamp getHospitalDate() {
        return hospitalDate;
    }

    public void setHospitalDate(Timestamp hospitalDate) {
        this.hospitalDate = hospitalDate;
    }

    @Basic
    @Column(name = "HOSPTAL_HOSPITAL")
    public String getHosptalHospital() {
        return hosptalHospital;
    }

    public void setHosptalHospital(String hosptalHospital) {
        this.hosptalHospital = hosptalHospital;
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
    @Column(name = "HOSPITAL_STATE")
    public Integer getHospitalState() {
        return hospitalState;
    }

    public void setHospitalState(Integer hospitalState) {
        this.hospitalState = hospitalState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheHospitalEntity that = (TheHospitalEntity) o;
        return hospitalNo == that.hospitalNo &&
                Objects.equals(patientNo, that.patientNo) &&
                Objects.equals(hospitalDate, that.hospitalDate) &&
                Objects.equals(hosptalHospital, that.hosptalHospital) &&
                Objects.equals(depaId, that.depaId) &&
                Objects.equals(hospitalState, that.hospitalState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalNo, patientNo, hospitalDate, hosptalHospital, depaId, hospitalState);
    }
}