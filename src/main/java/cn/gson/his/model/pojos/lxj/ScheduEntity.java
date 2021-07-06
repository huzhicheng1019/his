package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SCHEDU", schema = "HIS", catalog = "")
public class ScheduEntity {
    private int scheId;
    private Integer empId;
    private Timestamp startTime;
    private Timestamp stopTime;
    private Timestamp startDate;
    private Timestamp stopDate;

    @Id
    @Column(name = "SCHE_ID")
    public int getScheId() {
        return scheId;
    }

    public void setScheId(int scheId) {
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
        ScheduEntity that = (ScheduEntity) o;
        return scheId == that.scheId &&
                Objects.equals(empId, that.empId) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(stopTime, that.stopTime) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(stopDate, that.stopDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheId, empId, startTime, stopTime, startDate, stopDate);
    }
}
