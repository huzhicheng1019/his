package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "CASE_HISTORY", schema = "HIS", catalog = "")
public class CaseHistoryEntity {
    private String caseHissstory;
    private String patientName;
    private String patientIdentity;
    private String patientNo;

    @Basic
    @Column(name = "CASE_HISSSTORY")
    public String getCaseHissstory() {
        return caseHissstory;
    }

    public void setCaseHissstory(String caseHissstory) {
        this.caseHissstory = caseHissstory;
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
    @Column(name = "PATIENT_IDENTITY")
    public String getPatientIdentity() {
        return patientIdentity;
    }

    public void setPatientIdentity(String patientIdentity) {
        this.patientIdentity = patientIdentity;
    }

    @Basic
    @Column(name = "PATIENT_NO")
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseHistoryEntity that = (CaseHistoryEntity) o;
        return Objects.equals(caseHissstory, that.caseHissstory) &&
                Objects.equals(patientName, that.patientName) &&
                Objects.equals(patientIdentity, that.patientIdentity) &&
                Objects.equals(patientNo, that.patientNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseHissstory, patientName, patientIdentity, patientNo);
    }
}
