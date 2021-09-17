package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CANCEL_OPERATION", schema = "HIS", catalog = "")
public class CancelOperationEntity {
    private int canId;
    private String canCause;
    private String regMark;
    private Integer opsId;
    private Integer doctorId;
    private Timestamp canDate;


    public Timestamp getCanDate() {
        return canDate;
    }

    public void setCanDate(Timestamp canDate) {
        this.canDate = canDate;
    }

    @Id
    @Column(name = "CAN_ID")
    public int getCanId() {
        return canId;
    }

    public void setCanId(int canId) {
        this.canId = canId;
    }

    @Basic
    @Column(name = "CAN_CAUSE")
    public String getCanCause() {
        return canCause;
    }

    public void setCanCause(String canCause) {
        this.canCause = canCause;
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
    @Column(name = "OPS_ID")
    public Integer getOpsId() {
        return opsId;
    }

    public void setOpsId(Integer opsId) {
        this.opsId = opsId;
    }

    @Basic
    @Column(name = "DOCTOR_ID")
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CancelOperationEntity that = (CancelOperationEntity) o;
        return canId == that.canId &&
                Objects.equals(canCause, that.canCause) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(opsId, that.opsId) &&
                Objects.equals(doctorId, that.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(canId, canCause, regMark, opsId, doctorId);
    }

    @Override
    public String toString() {
        return "CancelOperationEntity{" +
                "canId=" + canId +
                ", canCause='" + canCause + '\'' +
                ", regMark='" + regMark + '\'' +
                ", opsId=" + opsId +
                ", doctorId=" + doctorId +
                ", canDate=" + canDate +
                '}';
    }
}
