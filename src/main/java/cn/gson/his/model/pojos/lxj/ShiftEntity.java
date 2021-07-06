package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "SHIFT", schema = "HIS", catalog = "")
public class ShiftEntity {
    private int shiId;
    private String shiName;
    private Timestamp startTime;
    private Timestamp stopTime;
    private Integer shiType;

    @Id
    @Column(name = "SHI_ID")
    public int getShiId() {
        return shiId;
    }

    public void setShiId(int shiId) {
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
        ShiftEntity that = (ShiftEntity) o;
        return shiId == that.shiId &&
                Objects.equals(shiName, that.shiName) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(stopTime, that.stopTime) &&
                Objects.equals(shiType, that.shiType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shiId, shiName, startTime, stopTime, shiType);
    }
}
