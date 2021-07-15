package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PATIENTDATA", schema = "HIS", catalog = "")
public class PatientdataEntity {
    private int patientNo;
    private String patientName;
    private String patientSex;

    @Override
    public String toString() {
        return "PatientdataEntity{" +
                "patientNo=" + patientNo +
                ", patientName='" + patientName + '\'' +
                ", patientSex='" + patientSex + '\'' +
                ", patientAge=" + patientAge +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientInsu='" + patientInsu + '\'' +
                ", patientIdentity='" + patientIdentity + '\'' +
                ", patientPirth='" + patientPirth + '\'' +
                '}';
    }

    private Integer patientAge;
    private String patientPhone;
    private String patientInsu;
    private String patientIdentity;
    private String patientPirth;

    @Id
    @Column(name = "PATIENT_NO")
    public int getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(int patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "PATIENT_NAME")
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Basic
    @Column(name = "PATIENT_SEX")
    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    @Basic
    @Column(name = "PATIENT_AGE")
    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    @Basic
    @Column(name = "PATIENT_PHONE")
    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    @Basic
    @Column(name = "PATIENT_INSU")
    public String getPatientInsu() {
        return patientInsu;
    }

    public void setPatientInsu(String patientInsu) {
        this.patientInsu = patientInsu;
    }

    @Basic
    @Column(name = "PATIENT_IDENTITY")
    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    @Basic
    @Column(name = "PATIENT_PIRTH")
    public String getPatientPirth() {
        return patientPirth;
    }

    public void setPatientPirth(String patientPirth) {
        this.patientPirth = patientPirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientdataEntity that = (PatientdataEntity) o;
        return patientNo == that.patientNo &&
                Objects.equals(patientName, that.patientName) &&
                Objects.equals(patientSex, that.patientSex) &&
                Objects.equals(patientAge, that.patientAge) &&
                Objects.equals(patientPhone, that.patientPhone) &&
                Objects.equals(patientInsu, that.patientInsu) &&
                Objects.equals(patientIdentity, that.patientIdentity) &&
                Objects.equals(patientPirth, that.patientPirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientNo, patientName, patientSex, patientAge, patientPhone, patientInsu, patientIdentity, patientPirth);
    }
}
