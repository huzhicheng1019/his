package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TRANSFER", schema = "HIS", catalog = "")
public class TransferEntity {
    private int trId;
    private String trCause;
    private String regMark;
    private Integer oldDepa;
    private Integer newDepa;
    private Integer trIs;
    private Timestamp trDate;
    private Integer oldDoctorId;
    private String oldDoctorName;
    private Integer newDoctorId;
    private String newDoctorName;

    @Id
    @Column(name = "TR_ID")
    public int getTrId() {
        return trId;
    }

    public void setTrId(int trId) {
        this.trId = trId;
    }

    @Basic
    @Column(name = "TR_CAUSE")
    public String getTrCause() {
        return trCause;
    }

    public void setTrCause(String trCause) {
        this.trCause = trCause;
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
    @Column(name = "OLD_DEPA")
    public Integer getOldDepa() {
        return oldDepa;
    }

    public void setOldDepa(Integer oldDepa) {
        this.oldDepa = oldDepa;
    }

    @Basic
    @Column(name = "NEW_DEPA")
    public Integer getNewDepa() {
        return newDepa;
    }

    public void setNewDepa(Integer newDepa) {
        this.newDepa = newDepa;
    }

    @Basic
    @Column(name = "TR_IS")
    public Integer getTrIs() {
        return trIs;
    }

    public void setTrIs(Integer trIs) {
        this.trIs = trIs;
    }

    @Basic
    @Column(name = "TR_DATE")
    public Timestamp getTrDate() {
        return trDate;
    }

    public void setTrDate(Timestamp trDate) {
        this.trDate = trDate;
    }

    @Basic
    @Column(name = "OLD_DOCTOR_ID")
    public Integer getOldDoctorId() {
        return oldDoctorId;
    }

    public void setOldDoctorId(Integer oldDoctorId) {
        this.oldDoctorId = oldDoctorId;
    }

    @Basic
    @Column(name = "OLD_DOCTOR_NAME")
    public String getOldDoctorName() {
        return oldDoctorName;
    }

    public void setOldDoctorName(String oldDoctorName) {
        this.oldDoctorName = oldDoctorName;
    }

    @Basic
    @Column(name = "NEW_DOCTOR_ID")
    public Integer getNewDoctorId() {
        return newDoctorId;
    }

    public void setNewDoctorId(Integer newDoctorId) {
        this.newDoctorId = newDoctorId;
    }

    @Basic
    @Column(name = "NEW_DOCTOR_NAME")
    public String getNewDoctorName() {
        return newDoctorName;
    }

    public void setNewDoctorName(String newDoctorName) {
        this.newDoctorName = newDoctorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferEntity that = (TransferEntity) o;
        return trId == that.trId &&
                Objects.equals(trCause, that.trCause) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(oldDepa, that.oldDepa) &&
                Objects.equals(newDepa, that.newDepa) &&
                Objects.equals(trIs, that.trIs) &&
                Objects.equals(trDate, that.trDate) &&
                Objects.equals(oldDoctorId, that.oldDoctorId) &&
                Objects.equals(oldDoctorName, that.oldDoctorName) &&
                Objects.equals(newDoctorId, that.newDoctorId) &&
                Objects.equals(newDoctorName, that.newDoctorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trId, trCause, regMark, oldDepa, newDepa, trIs, trDate, oldDoctorId, oldDoctorName, newDoctorId, newDoctorName);
    }
}
