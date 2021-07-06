package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "HANGMARK", schema = "HIS", catalog = "")
public class HangmarkEntity {
    private int hangNo;
    private Integer hangRoom;
    private Integer doctorName;
    private Integer registrantName;
    private Timestamp hangDate;
    private Integer patientNo;
    private Long hangCharge;
    private Integer hangtypeNo;
    private String timequantum;
    private Integer hangState;
    private Integer diagnoseState;

    @Id
    @Column(name = "HANG_NO")
    public int getHangNo() {
        return hangNo;
    }

    public void setHangNo(int hangNo) {
        this.hangNo = hangNo;
    }

    @Basic
    @Column(name = "HANG_ROOM")
    public Integer getHangRoom() {
        return hangRoom;
    }

    public void setHangRoom(Integer hangRoom) {
        this.hangRoom = hangRoom;
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
    @Column(name = "REGISTRANT_NAME")
    public Integer getRegistrantName() {
        return registrantName;
    }

    public void setRegistrantName(Integer registrantName) {
        this.registrantName = registrantName;
    }

    @Basic
    @Column(name = "HANG_DATE")
    public Timestamp getHangDate() {
        return hangDate;
    }

    public void setHangDate(Timestamp hangDate) {
        this.hangDate = hangDate;
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
    @Column(name = "HANG_CHARGE")
    public Long getHangCharge() {
        return hangCharge;
    }

    public void setHangCharge(Long hangCharge) {
        this.hangCharge = hangCharge;
    }

    @Basic
    @Column(name = "HANGTYPE_NO")
    public Integer getHangtypeNo() {
        return hangtypeNo;
    }

    public void setHangtypeNo(Integer hangtypeNo) {
        this.hangtypeNo = hangtypeNo;
    }

    @Basic
    @Column(name = "TIMEQUANTUM")
    public String getTimequantum() {
        return timequantum;
    }

    public void setTimequantum(String timequantum) {
        this.timequantum = timequantum;
    }

    @Basic
    @Column(name = "HANG_STATE")
    public Integer getHangState() {
        return hangState;
    }

    public void setHangState(Integer hangState) {
        this.hangState = hangState;
    }

    @Basic
    @Column(name = "DIAGNOSE_STATE")
    public Integer getDiagnoseState() {
        return diagnoseState;
    }

    public void setDiagnoseState(Integer diagnoseState) {
        this.diagnoseState = diagnoseState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HangmarkEntity that = (HangmarkEntity) o;
        return hangNo == that.hangNo &&
                Objects.equals(hangRoom, that.hangRoom) &&
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(registrantName, that.registrantName) &&
                Objects.equals(hangDate, that.hangDate) &&
                Objects.equals(patientNo, that.patientNo) &&
                Objects.equals(hangCharge, that.hangCharge) &&
                Objects.equals(hangtypeNo, that.hangtypeNo) &&
                Objects.equals(timequantum, that.timequantum) &&
                Objects.equals(hangState, that.hangState) &&
                Objects.equals(diagnoseState, that.diagnoseState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hangNo, hangRoom, doctorName, registrantName, hangDate, patientNo, hangCharge, hangtypeNo, timequantum, hangState, diagnoseState);
    }
}
