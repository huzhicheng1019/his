package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Premium {
    private String premiumId;
    private Long premiumPres;
    private Integer premiumPropores;
    private String proporesName;
    private Long premiumDoctor;
    private String doctorName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp premiumDate;
    private String premiumState;
    private PatientdataEntity patie;
    private String patientIdentity;
    private String tuiYuan;

    @Id
    @Column(name = "PREMIUM_ID", nullable = true, precision = 0)
    public String getPremiumId() {
        return premiumId;
    }

    public void setPremiumId(String premiumId) {
        this.premiumId = premiumId;
    }

    @Basic
    @Column(name = "PREMIUM_PRES", nullable = true, precision = 0)
    public Long getPremiumPres() {
        return premiumPres;
    }

    public void setPremiumPres(Long premiumPres) {
        this.premiumPres = premiumPres;
    }

    @Basic
    @Column(name = "PREMIUM_PROPORES", nullable = true, precision = 0)
    public Integer getPremiumPropores() {
        return premiumPropores;
    }

    public void setPremiumPropores(Integer premiumPropores) {
        this.premiumPropores = premiumPropores;
    }

    @Basic
    @Column(name = "PROPORES_NAME", nullable = true, length = 255)
    public String getProporesName() {
        return proporesName;
    }

    public void setProporesName(String proporesName) {
        this.proporesName = proporesName;
    }

    @Basic
    @Column(name = "PREMIUM_DOCTOR", nullable = true, precision = 0)
    public Long getPremiumDoctor() {
        return premiumDoctor;
    }

    public void setPremiumDoctor(Long premiumDoctor) {
        this.premiumDoctor = premiumDoctor;
    }

    @Basic
    @Column(name = "DOCTOR_NAME", nullable = true, length = 255)
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name = "PREMIUM_DATE", nullable = true)
    public Timestamp getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(Timestamp premiumDate) {
        this.premiumDate = premiumDate;
    }

    @Basic
    @Column(name = "PREMIUM_STATE", nullable = true, length = 255)
    public String getPremiumState() {
        return premiumState;
    }

    public void setPremiumState(String premiumState) {
        this.premiumState = premiumState;
    }

    @ManyToOne
    @JoinColumn(name = "PATIE", referencedColumnName = "PATIENT_NO")
    public PatientdataEntity getPatie() {
        return patie;
    }

    public void setPatie(PatientdataEntity patie) {
        this.patie = patie;
    }

    @Basic
    @Column(name = "PATIENT_IDENTITY", nullable = true, length = 255)
    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    @Basic
    @Column(name = "TUI_YUAN", nullable = true, length = 255)
    public String getTuiYuan() {
        return tuiYuan;
    }

    public void setTuiYuan(String tuiYuan) {
        this.tuiYuan = tuiYuan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premium premium = (Premium) o;
        return Objects.equals(premiumId, premium.premiumId) && Objects.equals(premiumPres, premium.premiumPres) && Objects.equals(premiumPropores, premium.premiumPropores) && Objects.equals(proporesName, premium.proporesName) && Objects.equals(premiumDoctor, premium.premiumDoctor) && Objects.equals(doctorName, premium.doctorName) && Objects.equals(premiumDate, premium.premiumDate) && Objects.equals(premiumState, premium.premiumState) && Objects.equals(patie, premium.patie) && Objects.equals(patientIdentity, premium.patientIdentity) && Objects.equals(tuiYuan, premium.tuiYuan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premiumId, premiumPres, premiumPropores, proporesName, premiumDoctor, doctorName, premiumDate, premiumState, patie, patientIdentity, tuiYuan);
    }
}
