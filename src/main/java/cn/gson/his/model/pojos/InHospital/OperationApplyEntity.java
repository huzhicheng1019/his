package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_APPLY", schema = "HIS", catalog = "")
public class OperationApplyEntity {
    private int appId;
    private Integer doctorId;
    private String regMark;
    private Timestamp appDate;
    private String appText;

    @Id
    @Column(name = "APP_ID")
    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
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
    @Column(name = "REG_MARK")
    public String getRegMark() {
        return regMark;
    }

    public void setRegMark(String regMark) {
        this.regMark = regMark;
    }

    @Basic
    @Column(name = "APP_DATE")
    public Timestamp getAppDate() {
        return appDate;
    }

    public void setAppDate(Timestamp appDate) {
        this.appDate = appDate;
    }

    @Basic
    @Column(name = "APP_TEXT")
    public String getAppText() {
        return appText;
    }

    public void setAppText(String appText) {
        this.appText = appText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationApplyEntity that = (OperationApplyEntity) o;
        return appId == that.appId &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(appDate, that.appDate) &&
                Objects.equals(appText, that.appText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appId, doctorId, regMark, appDate, appText);
    }
}
