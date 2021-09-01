package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_ITEM", schema = "HIS", catalog = "")
public class OperationItemEntity {
    private long operationId;
    private String operationName;
    private Long operationPrice;
    private String operationType;
    private String operationDress;
    private String operationIndication;
    private String operationTaboo;
    private OperationRoomEntity room;
    private Long operationZt;
    private List<SurgeryDrugEntity> shuqiandrug;
    private List<SurgeryConsumablesEntity> hczjb;

    @Id
    @Column(name = "OPERATION_ID")
    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
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
    @Column(name = "OPERATION_PRICE")
    public Long getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(Long operationPrice) {
        this.operationPrice = operationPrice;
    }

    @Basic
    @Column(name = "OPERATION_TYPE")
    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Basic
    @Column(name = "OPERATION_DRESS")
    public String getOperationDress() {
        return operationDress;
    }

    public void setOperationDress(String operationDress) {
        this.operationDress = operationDress;
    }

    @Basic
    @Column(name = "OPERATION_INDICATION")
    public String getOperationIndication() {
        return operationIndication;
    }

    public void setOperationIndication(String operationIndication) {
        this.operationIndication = operationIndication;
    }

    @Basic
    @Column(name = "OPERATION_ZT")
    public long getOperationZt() {
        return operationZt;
    }

    public void setOperationZt(long operationZt) {
        this.operationZt = operationZt;
    }

    @Basic
    @Column(name = "OPERATION_TABOO")
    public String getOperationTaboo() {
        return operationTaboo;
    }

    public void setOperationTaboo(String operationTaboo) {
        this.operationTaboo = operationTaboo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationItemEntity that = (OperationItemEntity) o;
        return operationId == that.operationId && Objects.equals(operationName, that.operationName) && Objects.equals(operationPrice, that.operationPrice) && Objects.equals(operationType, that.operationType) && Objects.equals(operationDress, that.operationDress) && Objects.equals(operationIndication, that.operationIndication) && Objects.equals(operationTaboo, that.operationTaboo ) && Objects.equals(operationZt,that.operationZt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, operationName, operationPrice, operationType, operationDress, operationIndication, operationTaboo,operationZt);
    }

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID")
    public OperationRoomEntity getRoom() {
        return room;
    }

    public void setRoom(OperationRoomEntity room) {
        this.room = room;
    }

    @OneToMany(mappedBy = "opeation")
    public List<SurgeryDrugEntity> getShuqiandrug() {
        return shuqiandrug;
    }

    public void setShuqiandrug(List<SurgeryDrugEntity> shuqiandrug) {
        this.shuqiandrug = shuqiandrug;
    }

    @OneToMany(mappedBy = "operationitems")
    public List<SurgeryConsumablesEntity> getHczjb() {
        return hczjb;
    }

    public void setHczjb(List<SurgeryConsumablesEntity> hczjb) {
        this.hczjb = hczjb;
    }
}
