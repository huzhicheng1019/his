/**
 * 班次
 */
package cn.gson.his.model.pojos.Power;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Shift {
    private Integer shiId;//id
    private String shiName;//班次名
    private String startTime;//开始时间
    private String stopTime;//结束时间
    private ShiftType shiftType;//类别
    private Integer shiState;//状态


    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
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

    @ManyToOne
    @JoinColumn(name = "SHI_TYPE", referencedColumnName = "TYPE_ID")
    public ShiftType getShiftType() {
        return shiftType;
    }

    public void setShiftType(ShiftType shiftType) {
        this.shiftType = shiftType;
    }

    @Basic
    @Column(name = "SHI_STATE")
    public Integer getShiState() {
        return shiState;
    }

    public void setShiState(Integer shiState) {
        this.shiState = shiState;
    }

    public Shift(String shiName, String startTime, String stopTime, ShiftType shiftType) {
        this.shiName = shiName;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.shiftType = shiftType;
    }

    public Shift() {
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiId=" + shiId +
                ", shiName='" + shiName + '\'' +
                ", startTime=" + startTime +
                ", stopTime=" + stopTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return Objects.equals(shiId, shift.shiId) && Objects.equals(shiName, shift.shiName) && Objects.equals(startTime, shift.startTime) && Objects.equals(stopTime, shift.stopTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shiId, shiName, startTime, stopTime);
    }
}
