package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_DRUGS", schema = "HIS", catalog = "")
public class OperationDrugsEntity {
    private int operationDrugsId;
    private Integer operationItemId;

    @Id
    @Column(name = "OPERATION_DRUGS_ID")
    public int getOperationDrugsId() {
        return operationDrugsId;
    }

    public void setOperationDrugsId(int operationDrugsId) {
        this.operationDrugsId = operationDrugsId;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_ID")
    public Integer getOperationItemId() {
        return operationItemId;
    }

    public void setOperationItemId(Integer operationItemId) {
        this.operationItemId = operationItemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationDrugsEntity that = (OperationDrugsEntity) o;
        return operationDrugsId == that.operationDrugsId &&
                Objects.equals(operationItemId, that.operationItemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationDrugsId, operationItemId);
    }
}
