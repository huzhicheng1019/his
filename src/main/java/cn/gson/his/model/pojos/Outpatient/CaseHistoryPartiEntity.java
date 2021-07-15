package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CASE_HISTORY_PARTI", schema = "HIS", catalog = "")
public class CaseHistoryPartiEntity {
    private int partiNo;
    private String chief;
    private String presents;
    private String previouss;
    private String checkup;
    private String suggestion;
    private String doctorName;
    private Integer doctorId;
    private Integer caseNo;

    @Id
    @Column(name = "PARTI_NO")
    public int getPartiNo() {
        return partiNo;
    }

    public void setPartiNo(int partiNo) {
        this.partiNo = partiNo;
    }

    @Basic
    @Column(name = "CHIEF")
    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    @Basic
    @Column(name = "PRESENTS")
    public String getPresents() {
        return presents;
    }

    public void setPresents(String presents) {
        this.presents = presents;
    }

    @Basic
    @Column(name = "PREVIOUSS")
    public String getPreviouss() {
        return previouss;
    }

    public void setPreviouss(String previouss) {
        this.previouss = previouss;
    }

    @Basic
    @Column(name = "CHECKUP")
    public String getCheckup() {
        return checkup;
    }

    public void setCheckup(String checkup) {
        this.checkup = checkup;
    }

    @Basic
    @Column(name = "SUGGESTION")
    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
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
    @Column(name = "DOCTOR_ID")
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "CASE_NO")
    public Integer getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(Integer caseNo) {
        this.caseNo = caseNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseHistoryPartiEntity that = (CaseHistoryPartiEntity) o;
        return partiNo == that.partiNo &&
                Objects.equals(chief, that.chief) &&
                Objects.equals(presents, that.presents) &&
                Objects.equals(previouss, that.previouss) &&
                Objects.equals(checkup, that.checkup) &&
                Objects.equals(suggestion, that.suggestion) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(caseNo, that.caseNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partiNo, chief, presents, previouss, checkup, suggestion, doctorName, doctorId, caseNo);
    }
}
