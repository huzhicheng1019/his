package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_RECORD", schema = "HIS", catalog = "")
public class OperationRecordEntity {
    private int recordId;
    private Integer roomId;
    private Timestamp recordTime;
    private Timestamp recordEnd;
    private Long operationId;
    private String operationName;
    private String regMark;
    private String regName;
    private Integer doctorId;
    private String doctorMame;
    private Integer nurseId;
    private String nurseName;
    private Long recordMoney;
    private String recordSurgicl;

    @Id
    @Column(name = "RECORD_ID")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "ROOM_ID")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "RECORD_TIME")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "RECORD_END")
    public Timestamp getRecordEnd() {
        return recordEnd;
    }

    public void setRecordEnd(Timestamp recordEnd) {
        this.recordEnd = recordEnd;
    }

    @Basic
    @Column(name = "OPERATION_ID")
    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    @Basic
    @Column(name = "OPERATION_NAME")
    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
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
    @Column(name = "REG_NAME")
    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName;
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
    @Column(name = "DOCTOR_MAME")
    public String getDoctorMame() {
        return doctorMame;
    }

    public void setDoctorMame(String doctorMame) {
        this.doctorMame = doctorMame;
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
    @Column(name = "NURSE_NAME")
    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    @Basic
    @Column(name = "RECORD_MONEY")
    public Long getRecordMoney() {
        return recordMoney;
    }

    public void setRecordMoney(Long recordMoney) {
        this.recordMoney = recordMoney;
    }

    @Basic
    @Column(name = "RECORD_SURGICL")
    public String getRecordSurgicl() {
        return recordSurgicl;
    }

    public void setRecordSurgicl(String recordSurgicl) {
        this.recordSurgicl = recordSurgicl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationRecordEntity that = (OperationRecordEntity) o;
        return recordId == that.recordId &&
                Objects.equals(roomId, that.roomId) &&
                Objects.equals(recordTime, that.recordTime) &&
                Objects.equals(recordEnd, that.recordEnd) &&
                Objects.equals(operationId, that.operationId) &&
                Objects.equals(operationName, that.operationName) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(regName, that.regName) &&
                Objects.equals(doctorId, that.doctorId) &&
                Objects.equals(doctorMame, that.doctorMame) &&
                Objects.equals(nurseId, that.nurseId) &&
                Objects.equals(nurseName, that.nurseName) &&
                Objects.equals(recordMoney, that.recordMoney) &&
                Objects.equals(recordSurgicl, that.recordSurgicl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, roomId, recordTime, recordEnd, operationId, operationName, regMark, regName, doctorId, doctorMame, nurseId, nurseName, recordMoney, recordSurgicl);
    }
}
