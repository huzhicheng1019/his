package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SURGERY_CONSUMABLES", schema = "HIS", catalog = "")
public class SurgeryConsumablesEntity {
    private long consumablesId;
    private Long consumablesNum;
    private Long consumablesPrice;
    private OperationItemEntity operationitems;
    private HcEntity con;

    @Id
    @Column(name = "CONSUMABLES_ID")
    public long getConsumablesId() {
        return consumablesId;
    }

    public void setConsumablesId(long consumablesId) {
        this.consumablesId = consumablesId;
    }


    @Basic
    @Column(name = "CONSUMABLES_NUM")
    public Long getConsumablesNum() {
        return consumablesNum;
    }

    public void setConsumablesNum(Long consumablesNum) {
        this.consumablesNum = consumablesNum;
    }

    @Basic
    @Column(name = "CONSUMABLES_PRICE")
    public Long getConsumablesPrice() {
        return consumablesPrice;
    }

    public void setConsumablesPrice(Long consumablesPrice) {
        this.consumablesPrice = consumablesPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurgeryConsumablesEntity that = (SurgeryConsumablesEntity) o;
        return consumablesId == that.consumablesId &&  Objects.equals(consumablesNum, that.consumablesNum) && Objects.equals(consumablesPrice, that.consumablesPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consumablesId, consumablesNum, consumablesPrice);
    }

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID", referencedColumnName = "OPERATION_ID")
    public OperationItemEntity getOperationitems() {
        return operationitems;
    }

    public void setOperationitems(OperationItemEntity operationitems) {
        this.operationitems = operationitems;
    }

    @ManyToOne
    @JoinColumn(name = "CON_ID", referencedColumnName = "CON_ID")
    public HcEntity getCon() {
        return con;
    }

    public void setCon(HcEntity con) {
        this.con = con;
    }
}
