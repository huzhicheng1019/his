package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DOCTOR_STOP", schema = "HIS", catalog = "")
public class DoctorStopEntity {
    private int stoId;
    private Timestamp stoDate;
    private Integer enId;
    private Integer doctorId;
    private String stoCause;
    private String regMark;

    @Id
    @Column(name = "STO_ID")
    public int getStoId() {
        return stoId;
    }

    public void setStoId(int stoId) {
        this.stoId = stoId;
    }

    @Basic
    @Column(name = "STO_DATE")
    public Timestamp getStoDate() {
        return stoDate;
    }

    public void setStoDate(Timestamp stoDate) {
        this.stoDate = stoDate;
    }

    @Basic
    @Column(name = "EN_ID")
    public Integer getEnId() {
        return enId;
    }

    public void setEnId(Integer enId) {
        this.enId = enId;
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
    @Column(name = "STO_CAUSE")
    public String getStoCause() {
        return stoCause;
    }

    public void setStoCause(String stoCause) {
        this.stoCause = stoCause;
    }

    @Basic
    @Column(name = "REG_MARK")
    public String getRegMark() {
        return regMark;
    }

    public void setRegMark(String regMark) {
        this.regMark = regMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorStopEntity that = (DoctorStopEntity) o;
        return stoId == that.stoId &&
                Objects.equals(stoDate, that.stoDate) &&
                Objects.equals(enId, that.enId) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(stoCause, that.stoCause) &&
                Objects.equals(regMark, that.regMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stoId, stoDate, enId, doctorId, stoCause, regMark);
    }

    @Override
    public String toString() {
        return "DoctorStopEntity{" +
                "stoId=" + stoId +
                ", stoDate=" + stoDate +
                ", enId=" + enId +
                ", doctorId=" + doctorId +
                ", stoCause='" + stoCause + '\'' +
                ", regMark='" + regMark + '\'' +
                '}';
    }
}
