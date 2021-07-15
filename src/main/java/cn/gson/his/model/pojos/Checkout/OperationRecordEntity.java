package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_RECORD", schema = "HIS", catalog = "")
public class OperationRecordEntity {
    private int operationRecordId;
    private Integer untitled1;
    private Timestamp operationRecordTime;
    private Integer operationRecordRoom;
    private String operationRecordReslut;

    @Id
    @Column(name = "OPERATION_RECORD_ID")
    public int getOperationRecordId() {
        return operationRecordId;
    }

    public void setOperationRecordId(int operationRecordId) {
        this.operationRecordId = operationRecordId;
    }

    @Basic
    @Column(name = "UNTITLED1")
    public Integer getUntitled1() {
        return untitled1;
    }

    public void setUntitled1(Integer untitled1) {
        this.untitled1 = untitled1;
    }

    @Basic
    @Column(name = "OPERATION_RECORD_TIME")
    public Timestamp getOperationRecordTime() {
        return operationRecordTime;
    }

    public void setOperationRecordTime(Timestamp operationRecordTime) {
        this.operationRecordTime = operationRecordTime;
    }

    @Basic
    @Column(name = "OPERATION_RECORD_ROOM")
    public Integer getOperationRecordRoom() {
        return operationRecordRoom;
    }

    public void setOperationRecordRoom(Integer operationRecordRoom) {
        this.operationRecordRoom = operationRecordRoom;
    }

    @Basic
    @Column(name = "OPERATION_RECORD_RESLUT")
    public String getOperationRecordReslut() {
        return operationRecordReslut;
    }

    public void setOperationRecordReslut(String operationRecordReslut) {
        this.operationRecordReslut = operationRecordReslut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationRecordEntity that = (OperationRecordEntity) o;
        return operationRecordId == that.operationRecordId &&
                Objects.equals(untitled1, that.untitled1) &&
                Objects.equals(operationRecordTime, that.operationRecordTime) &&
                Objects.equals(operationRecordRoom, that.operationRecordRoom) &&
                Objects.equals(operationRecordReslut, that.operationRecordReslut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationRecordId, untitled1, operationRecordTime, operationRecordRoom, operationRecordReslut);
    }
}
