package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DOCTOR_LEAVE", schema = "HIS", catalog = "")
public class DoctorLeaveEntity {
    private int leaId;
    private String regMark;
    private Timestamp leaDate;
    private String leaCause;
    private Integer doctorId;
    private Integer leaIs;
    private String leaReason;

    @Id
    @Column(name = "LEA_ID")
    public int getLeaId() {
        return leaId;
    }

    public void setLeaId(int leaId) {
        this.leaId = leaId;
    }

    @Basic
    @Column(name = "REG_MARK")
    public String getRegMark() {
        return regMark;
    }

    public void setRegMark(String regMark) {
        this.regMark = regMark;
    }

    @Basic
    @Column(name = "LEA_DATE")
    public Timestamp getLeaDate() {
        return leaDate;
    }

    public void setLeaDate(Timestamp leaDate) {
        this.leaDate = leaDate;
    }

    @Basic
    @Column(name = "LEA_CAUSE")
    public String getLeaCause() {
        return leaCause;
    }

    public void setLeaCause(String leaCause) {
        this.leaCause = leaCause;
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
    @Column(name = "LEA_IS")
    public Integer getLeaIs() {
        return leaIs;
    }

    public void setLeaIs(Integer leaIs) {
        this.leaIs = leaIs;
    }

    @Basic
    @Column(name = "LEA_REASON")
    public String getLeaReason() {
        return leaReason;
    }

    public void setLeaReason(String leaReason) {
        this.leaReason = leaReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorLeaveEntity that = (DoctorLeaveEntity) o;
        return leaId == that.leaId &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(leaDate, that.leaDate) &&
                Objects.equals(leaCause, that.leaCause) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(leaIs, that.leaIs) &&
                Objects.equals(leaReason, that.leaReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaId, regMark, leaDate, leaCause, doctorId, leaIs, leaReason);
    }
}
