package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Schedu {
    private Integer scheId;
    private Integer empId;
    private Timestamp startTime;
    private Timestamp stopTime;
    private Timestamp startDate;
    private Timestamp stopDate;


    @Id
    @Column(name = "SCHE_ID")
    public Integer getScheId() {
        return scheId;
    }

    public void setScheId(Integer scheId) {
        this.scheId = scheId;
    }

    @Basic
    @Column(name = "EMP_ID")
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "START_TIME")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "STOP_TIME")
    public Timestamp getStopTime() {
        return stopTime;
    }

    public void setStopTime(Timestamp stopTime) {
        this.stopTime = stopTime;
    }

    @Basic
    @Column(name = "START_DATE")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "STOP_DATE")
    public Timestamp getStopDate() {
        return stopDate;
    }

    public void setStopDate(Timestamp stopDate) {
        this.stopDate = stopDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedu schedu = (Schedu) o;
        return Objects.equals(scheId, schedu.scheId) && Objects.equals(empId, schedu.empId) && Objects.equals(startTime, schedu.startTime) && Objects.equals(stopTime, schedu.stopTime) && Objects.equals(startDate, schedu.startDate) && Objects.equals(stopDate, schedu.stopDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheId, empId, startTime, stopTime, startDate, stopDate);
    }
}
