package cn.gson.his.model.pojos.Outpatient;

import cn.gson.his.model.pojos.Power.Employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DOCTORRECORD", schema = "HIS", catalog = "")
public class DoctorrecordEntity {
    private int recordNo;//就诊记录编号
    private String recordIdentity;//患者身份证
    private String recordName;//患者名字
    private String recordPhone;//患者电话
    private String doctorName;//就诊医生名字
    private Integer recordIndoor;//就诊结果
    private String recordRecord;//诊断结果

    private Employee doctor;//主治医生对象
    private CardEntity card;//就诊卡对象
    private PatientdataEntity patient;//患者信对象
    private CaseHistoryEntity caseHissstory;//病历编号


    @OneToOne
    @JoinColumn(name = "DOCTOR_NO",nullable = false)
    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }
    @OneToOne
    @JoinColumn(name = "CARD_ID",nullable = false)
    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }
    @OneToOne
    @JoinColumn(name = "PATIENT_NO",nullable = false)
    public PatientdataEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientdataEntity patient) {
        this.patient = patient;
    }
    @OneToOne
    @JoinColumn(name = "CASE_HISSSTORY",nullable = false)
    public CaseHistoryEntity getCaseHissstory() {
        return caseHissstory;
    }

    public void setCaseHissstory(CaseHistoryEntity caseHissstory) {
        this.caseHissstory = caseHissstory;
    }

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
    @Column(name = "RECORD_PHONE")
    public String getRecordPhone() {
        return recordPhone;
    }
    public void setRecordPhone(String recordPhone) {
        this.recordPhone = recordPhone;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorrecordEntity that = (DoctorrecordEntity) o;
        return recordNo == that.recordNo &&
                Objects.equals(recordIdentity, that.recordIdentity) &&
                Objects.equals(recordName, that.recordName) &&
                Objects.equals(recordPhone, that.recordPhone) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(recordIndoor, that.recordIndoor) &&
                Objects.equals(recordRecord, that.recordRecord) &&
                Objects.equals(caseHissstory, that.caseHissstory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordNo, recordIdentity, recordName, recordPhone, doctorName, recordIndoor, recordRecord, caseHissstory);
    }
}
