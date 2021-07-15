package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DOCTOR_ENJOIN", schema = "HIS", catalog = "")
public class DoctorEnjoinEntity {
    private int enId;
    private Timestamp enStart;
    private Timestamp enEnd;
    private String regMark;
    private Integer doctorId;
    private Integer enType;
    private Integer enState;
    private String enContent;

    @Id
    @Column(name = "EN_ID")
    public int getEnId() {
        return enId;
    }

    public void setEnId(int enId) {
        this.enId = enId;
    }

    @Basic
    @Column(name = "EN_START")
    public Timestamp getEnStart() {
        return enStart;
    }

    public void setEnStart(Timestamp enStart) {
        this.enStart = enStart;
    }

    @Basic
    @Column(name = "EN_END")
    public Timestamp getEnEnd() {
        return enEnd;
    }

    public void setEnEnd(Timestamp enEnd) {
        this.enEnd = enEnd;
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
    @Column(name = "DOCTOR_ID")
    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "EN_TYPE")
    public Integer getEnType() {
        return enType;
    }

    public void setEnType(Integer enType) {
        this.enType = enType;
    }

    @Basic
    @Column(name = "EN_STATE")
    public Integer getEnState() {
        return enState;
    }

    public void setEnState(Integer enState) {
        this.enState = enState;
    }

    @Basic
    @Column(name = "EN_CONTENT")
    public String getEnContent() {
        return enContent;
    }

    public void setEnContent(String enContent) {
        this.enContent = enContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorEnjoinEntity that = (DoctorEnjoinEntity) o;
        return enId == that.enId &&
                Objects.equals(enStart, that.enStart) &&
                Objects.equals(enEnd, that.enEnd) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(enType, that.enType) &&
                Objects.equals(enState, that.enState) &&
                Objects.equals(enContent, that.enContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enId, enStart, enEnd, regMark, doctorId, enType, enState, enContent);
    }
}
