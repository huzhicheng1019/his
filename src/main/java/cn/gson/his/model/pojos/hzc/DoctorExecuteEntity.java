package cn.gson.his.model.pojos.hzc;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DOCTOR_EXECUTE", schema = "HIS", catalog = "")
public class DoctorExecuteEntity {
    private int exeId;
    private Timestamp exeDate;
    private Integer enId;
    private Integer nurseId;
    private String regMark;
    private String exeText;

    @Id
    @Column(name = "EXE_ID")
    public int getExeId() {
        return exeId;
    }

    public void setExeId(int exeId) {
        this.exeId = exeId;
    }

    @Basic
    @Column(name = "EXE_DATE")
    public Timestamp getExeDate() {
        return exeDate;
    }

    public void setExeDate(Timestamp exeDate) {
        this.exeDate = exeDate;
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
    @Column(name = "NURSE_ID")
    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
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
    @Column(name = "EXE_TEXT")
    public String getExeText() {
        return exeText;
    }

    public void setExeText(String exeText) {
        this.exeText = exeText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorExecuteEntity that = (DoctorExecuteEntity) o;
        return exeId == that.exeId &&
                Objects.equals(exeDate, that.exeDate) &&
                Objects.equals(enId, that.enId) &&
                Objects.equals(nurseId, that.nurseId) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(exeText, that.exeText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exeId, exeDate, enId, nurseId, regMark, exeText);
    }
}
