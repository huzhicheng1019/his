package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Shift {
    private Integer shiId;
    private String shiName;
    private Timestamp startTime;
    private Timestamp stopTime;
    private Integer shiType;

    @Id
    @Column(name = "SHI_ID")
    public Integer getShiId() {
        return shiId;
    }

    public void setShiId(Integer shiId) {
        this.shiId = shiId;
    }

    @Basic
    @Column(name = "SHI_NAME")
    public String getShiName() {
        return shiName;
    }

    public void setShiName(String shiName) {
        this.shiName = shiName;
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
    @Column(name = "SHI_TYPE")
    public Integer getShiType() {
        return shiType;
    }

    public void setShiType(Integer shiType) {
        this.shiType = shiType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return Objects.equals(shiId, shift.shiId) && Objects.equals(shiName, shift.shiName) && Objects.equals(startTime, shift.startTime) && Objects.equals(stopTime, shift.stopTime) && Objects.equals(shiType, shift.shiType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shiId, shiName, startTime, stopTime, shiType);
    }
}
