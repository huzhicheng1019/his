package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_RECORD", schema = "HIS", catalog = "")
public class OperationRecordEntity {
    private long recordId;
    private Long roomId;
    private Timestamp recordTime;
    private Long operationId;
    private String zhuyuanNum;
    private Long recordType;
    private Long recordMoney;
    private String recordSurgicl;

    @Id
    @Column(name = "RECORD_ID")
    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "ROOM_ID")
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
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
    @Column(name = "OPERATION_ID")
    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    @Basic
    @Column(name = "ZHUYUAN_NUM")
    public String getZhuyuanNum() {
        return zhuyuanNum;
    }

    public void setZhuyuanNum(String zhuyuanNum) {
        this.zhuyuanNum = zhuyuanNum;
    }

    @Basic
    @Column(name = "RECORD_TYPE")
    public Long getRecordType() {
        return recordType;
    }

    public void setRecordType(Long recordType) {
        this.recordType = recordType;
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
        return recordId == that.recordId && Objects.equals(roomId, that.roomId) && Objects.equals(recordTime, that.recordTime) && Objects.equals(operationId, that.operationId) && Objects.equals(zhuyuanNum, that.zhuyuanNum) && Objects.equals(recordType, that.recordType) && Objects.equals(recordMoney, that.recordMoney) && Objects.equals(recordSurgicl, that.recordSurgicl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, roomId, recordTime, operationId, zhuyuanNum, recordType, recordMoney, recordSurgicl);
    }
}
