package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CASE_HISTORY", schema = "HIS", catalog = "")
public class CaseHistoryEntity {
    private int caseHissstory;//病历编号
    private String patientName;//患者姓名
    private String patientIdentity;//患者身份证
    private Integer caseState;//区分当前还是过往


    private PatientdataEntity patientNo;//患者外建

    private List<CaseHistoryPartiEntity> partiEntities;//病例详情集合

    @OneToMany
    public List<CaseHistoryPartiEntity> getPartiEntities() {
        return partiEntities;
    }

    public void setPartiEntities(List<CaseHistoryPartiEntity> partiEntities) {
        this.partiEntities = partiEntities;
    }

    @OneToOne
    @JoinColumn(name = "PATIENT_NO",nullable = false)
    public PatientdataEntity getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(PatientdataEntity patientNo) {
        this.patientNo = patientNo;
    }

    @Id
    @Column(name = "CASE_HISSSTORY")
    public int getCaseHissstory() {
        return caseHissstory;
    }

    public void setCaseHissstory(int caseHissstory) {
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
    @Column(name = "CASE_STATE")
    public Integer getCaseState(){ return caseState; }

    public void setCaseState(Integer caseState){ this.caseState = caseState; }
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
