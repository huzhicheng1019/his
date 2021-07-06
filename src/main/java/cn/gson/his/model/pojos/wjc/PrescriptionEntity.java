package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PRESCRIPTION", schema = "HIS", catalog = "")
public class PrescriptionEntity {
    private int presNo;
    private Integer recordId;
    private Integer cardNo;
    private String presName;
    private Timestamp presDate;
    private Integer doctorName;
    private Integer newSee;
    private Integer patientNo;
    private String priveType;
    private String explain;
    private Long totalPrice;
    private Integer medicineType;

    @Id
    @Column(name = "PRES_NO")
    public int getPresNo() {
        return presNo;
    }

    public void setPresNo(int presNo) {
        this.presNo = presNo;
    }

    @Basic
    @Column(name = "RECORD_ID")
    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "CARD_NO")
    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
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
    @Column(name = "DOCTOR_NAME")
    public Integer getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(Integer doctorName) {
        this.doctorName = doctorName;
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
    @Column(name = "PATIENT_NO")
    public Integer getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(Integer patientNo) {
        this.patientNo = patientNo;
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
