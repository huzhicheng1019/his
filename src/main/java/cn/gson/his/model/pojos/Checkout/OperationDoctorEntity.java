package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_DOCTOR", schema = "HIS", catalog = "")
public class OperationDoctorEntity {
    private long doctorId;
    private Long employeeId;
    private String employeeZhiwei;
    private Long appId;

    @Id
    @Column(name = "DOCTOR_ID")
    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "EMPLOYEE_ID")
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "EMPLOYEE_ZHIWEI")
    public String getEmployeeZhiwei() {
        return employeeZhiwei;
    }

    public void setEmployeeZhiwei(String employeeZhiwei) {
        this.employeeZhiwei = employeeZhiwei;
    }

    @Basic
    @Column(name = "APP_ID")
    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationDoctorEntity that = (OperationDoctorEntity) o;
        return doctorId == that.doctorId && Objects.equals(employeeId, that.employeeId) && Objects.equals(employeeZhiwei, that.employeeZhiwei) && Objects.equals(appId, that.appId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, employeeId, employeeZhiwei, appId);
    }
}
