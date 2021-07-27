package cn.gson.his.model.pojos.Power;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Schedu {
    private Integer scheId;
    private Employee emp;
    private String scheDate;
    private String startTime;
    private String stopTime;


    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "SCHE_ID")
    public Integer getScheId() {
        return scheId;
    }

    public void setScheId(Integer scheId) {
        this.scheId = scheId;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    @Basic
    @Column(name = "SCHE_DATE")
    public String getScheDate() {
        return scheDate;
    }

    public void setScheDate(String scheDate) {
        this.scheDate = scheDate;
    }

    @Basic
    @Column(name = "START_TIME")
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "STOP_TIME")
    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedu schedu = (Schedu) o;
        return Objects.equals(scheId, schedu.scheId) && Objects.equals(scheDate, schedu.scheDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheId, scheDate);
    }

    public Schedu(Employee emp, String scheDate, String startTime, String stopTime) {
        this.emp = emp;
        this.scheDate = scheDate;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public Schedu() {
    }

    @Override
    public String toString() {
        return "Schedu{" +
                "scheId=" + scheId +
                ", scheDate='" + scheDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", stopTime='" + stopTime + '\'' +
                '}';
    }
}
