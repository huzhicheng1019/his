package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DOCTORRECORD", schema = "HIS", catalog = "")
public class DoctorrecordEntity {
    private int recordNo;
    private String recordIdentity;
    private String recordName;
    private Integer patientNo;
    private String recordPhone;
    private Integer cardId;
    private String doctorName;
    private Integer doctorNo;
    private Integer recordIndoor;
    private String recordRecord;
    private Integer caseHissstory;

    @Id
    @Column(name = "RECORD_NO")
    public int getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }

    @Basic
    @Column(name = "RECORD_IDENTITY")
    public String getRecordIdentity() {
        return recordIdentity;
    }

    public void setRecordIdentity(String recordIdentity) {
        this.recordIdentity = recordIdentity;
    }

    @Basic
    @Column(name = "RECORD_NAME")
    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
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
    @Column(name = "RECORD_PHONE")
    public String getRecordPhone() {
        return recordPhone;
    }

    public void setRecordPhone(String recordPhone) {
        this.recordPhone = recordPhone;
    }

    @Basic
    @Column(name = "CARD_ID")
    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
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
    @Column(name = "DOCTOR_NO")
    public Integer getDoctorNo() {
        return doctorNo;
    }

    public void setDoctorNo(Integer doctorNo) {
        this.doctorNo = doctorNo;
    }

    @Basic
    @Column(name = "RECORD_INDOOR")
    public Integer getRecordIndoor() {
        return recordIndoor;
    }

    public void setRecordIndoor(Integer recordIndoor) {
        this.recordIndoor = recordIndoor;
    }

    @Basic
    @Column(name = "RECORD_RECORD")
    public String getRecordRecord() {
        return recordRecord;
    }

    public void setRecordRecord(String recordRecord) {
        this.recordRecord = recordRecord;
    }

    @Basic
    @Column(name = "CASE_HISSSTORY")
    public Integer getCaseHissstory() {
        return caseHissstory;
    }

    public void setCaseHissstory(Integer caseHissstory) {
        this.caseHissstory = caseHissstory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorrecordEntity that = (DoctorrecordEntity) o;
        return recordNo == that.recordNo &&
                Objects.equals(recordIdentity, that.recordIdentity) &&
                Objects.equals(recordName, that.recordName) &&
                Objects.equals(patientNo, that.patientNo) &&
                Objects.equals(recordPhone, that.recordPhone) &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(doctorNo, that.doctorNo) &&
                Objects.equals(recordIndoor, that.recordIndoor) &&
                Objects.equals(recordRecord, that.recordRecord) &&
                Objects.equals(caseHissstory, that.caseHissstory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordNo, recordIdentity, recordName, patientNo, recordPhone, cardId, doctorName, doctorNo, recordIndoor, recordRecord, caseHissstory);
    }
}
