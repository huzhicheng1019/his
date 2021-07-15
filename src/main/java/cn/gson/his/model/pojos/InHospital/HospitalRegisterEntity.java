package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "HOSPITAL_REGISTER", schema = "HIS", catalog = "")
public class HospitalRegisterEntity {
    private int regId;
    private String regMark;
    private Timestamp regDate;
    private Integer patientNo;
    private String regName;
    private Integer depaId;
    private Integer doctorId;
    private String doctorName;
    private Integer regIs;



    @Id
    @Column(name = "REG_ID")
    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
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
    @Column(name = "REG_DATE")
    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
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
    @Column(name = "REG_NAME")
    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
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
    @Column(name = "DOCTOR_ID")
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "DOCTOR_NAME")
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name = "REG_IS")
    public Integer getRegIs() {
        return regIs;
    }

    public void setRegIs(Integer regIs) {
        this.regIs = regIs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalRegisterEntity that = (HospitalRegisterEntity) o;
        return regId == that.regId &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(regDate, that.regDate) &&
                Objects.equals(patientNo, that.patientNo) &&
                Objects.equals(regName, that.regName) &&
                Objects.equals(depaId, that.depaId) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(regIs, that.regIs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regId, regMark, regDate, patientNo, regName, depaId, doctorId, doctorName, regIs);
    }
}
