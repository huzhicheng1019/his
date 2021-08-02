package cn.gson.his.model.pojos.Outpatient;

import cn.gson.his.model.pojos.Power.Employee;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PRESCRIPTION", schema = "HIS", catalog = "")
public class PrescriptionEntity {
    private int presNo;//处方编号
    private String presName;//处方名字
    private Timestamp presDate;//开处方时间
    private Integer newSee;//初复诊
    private String priveType;//费别
    private String explain;//诊断描述
    private Long totalPrice;//总价
    private Integer medicineType;//类型

    private DoctorrecordEntity recordId;//就诊号
    private CardEntity cardNo;//就诊卡号
    private Employee doctorName;//主治医生
    private PatientdataEntity patientNo;//患者信息

    @OneToOne
    @Column(name = "RECORD_ID",nullable = false)
    public DoctorrecordEntity getRecordId() {
        return recordId;
    }

    public void setRecordId(DoctorrecordEntity recordId) {
        this.recordId = recordId;
    }

    @OneToOne
    @Column(name = "CARD_NO",nullable = false)
    public CardEntity getCardNo() {
        return cardNo;
    }

    public void setCardNo(CardEntity cardNo) {
        this.cardNo = cardNo;
    }

    @OneToOne
    @Column(name = "DOCTOR_NAME",nullable = false)
    public Employee getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(Employee doctorName) {
        this.doctorName = doctorName;
    }

    @OneToOne
    @Column(name = "PATIENT_NO",nullable = false)
    public PatientdataEntity getPatientNo() {
        return patientNo;
    }
    public void setPatientNo(PatientdataEntity patientNo) {
        this.patientNo = patientNo;
    }

    @Id
    @Column(name = "PRES_NO")
    public int getPresNo() {
        return presNo;
    }

    public void setPresNo(int presNo) {
        this.presNo = presNo;
    }



    @Basic
    @Column(name = "PRES_NAME")
    public String getPresName() {
        return presName;
    }

    public void setPresName(String presName) {
        this.presName = presName;
    }

    @Basic
    @Column(name = "PRES_DATE")
    public Timestamp getPresDate() {
        return presDate;
    }

    public void setPresDate(Timestamp presDate) {
        this.presDate = presDate;
    }



    @Basic
    @Column(name = "NEW_SEE")
    public Integer getNewSee() {
        return newSee;
    }

    public void setNewSee(Integer newSee) {
        this.newSee = newSee;
    }


    @Basic
    @Column(name = "PRIVE_TYPE")
    public String getPriveType() {
        return priveType;
    }

    public void setPriveType(String priveType) {
        this.priveType = priveType;
    }

    @Basic
    @Column(name = "EXPLAIN")
    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    @Basic
    @Column(name = "TOTAL_PRICE")
    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "MEDICINE_TYPE")
    public Integer getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(Integer medicineType) {
        this.medicineType = medicineType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionEntity that = (PrescriptionEntity) o;
        return presNo == that.presNo &&
                Objects.equals(recordId, that.recordId) &&
                Objects.equals(cardNo, that.cardNo) &&
                Objects.equals(presName, that.presName) &&
                Objects.equals(presDate, that.presDate) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(newSee, that.newSee) &&
                Objects.equals(patientNo, that.patientNo) &&
                Objects.equals(priveType, that.priveType) &&
                Objects.equals(explain, that.explain) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(medicineType, that.medicineType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(presNo, recordId, cardNo, presName, presDate, doctorName, newSee, patientNo, priveType, explain, totalPrice, medicineType);
    }
}
