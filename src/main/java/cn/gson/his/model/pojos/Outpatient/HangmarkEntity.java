package cn.gson.his.model.pojos.Outpatient;

import cn.gson.his.model.pojos.lxj.Department;
import cn.gson.his.model.pojos.lxj.Employee;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "HANGMARK", schema = "HIS", catalog = "")
public class HangmarkEntity<HangType> {
    private int hangNo;
    //挂号的科室
    private Department department;
    //挂号的医生
    private Employee doctorName;
    private Employee registrantName;;//登记人
    private Timestamp hangDate;
    //患者信息外建
    private PatientdataEntity patie;
    private Long hangCharge;
    //挂号类型
    private HangtypeEntity hangType;
    private String timequantum;
    private Integer hangState;
    private Integer diagnoseState;

    @ManyToOne
    @JoinColumn(name = "Registrant_name",nullable = false)
    public Employee getRegistrantName() {
        return registrantName;
    }

    public void setRegistrantName(Employee registrantName) {
        this.registrantName = registrantName;
    }

    //科室
    @ManyToOne
    @JoinColumn(name = "HANG_ROOM",nullable = false)
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    //主治医师
    @ManyToOne
    @JoinColumn(name = "DOCTOR_NAME",nullable = false)
    public Employee getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(Employee doctorName) {
        this.doctorName = doctorName;
    }
    //患者资料
    @ManyToOne
    @JoinColumn(name = "PATIENT_NO",nullable = false)
    public PatientdataEntity getPatie() {
        return patie;
    }
    public void setPatie(PatientdataEntity patie) {
        this.patie = patie;
    }
    //挂号类型
    @ManyToOne
    @JoinColumn(name = "HANGTYPE_NO",nullable = false)
    public HangtypeEntity getHangType() {
        return hangType;
    }

    public void setHangType(HangtypeEntity hangType) {
        this.hangType = hangType;
    }
    @Id
    @Column(name = "HANG_NO")
    public int getHangNo() {
        return hangNo;
    }

    public void setHangNo(int hangNo) {
        this.hangNo = hangNo;
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
    @Column(name = "HANG_CHARGE")
    public Long getHangCharge() {
        return hangCharge;
    }

    public void setHangCharge(Long hangCharge) {
        this.hangCharge = hangCharge;
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
                Objects.equals(doctorName, that.doctorName) &&
                Objects.equals(registrantName, that.registrantName) &&
                Objects.equals(hangDate, that.hangDate) &&
                Objects.equals(hangCharge, that.hangCharge) &&
                Objects.equals(timequantum, that.timequantum) &&
                Objects.equals(hangState, that.hangState) &&
                Objects.equals(diagnoseState, that.diagnoseState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hangNo, registrantName, hangDate, hangCharge, timequantum, hangState, diagnoseState);
    }
}
