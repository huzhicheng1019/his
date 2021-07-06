package cn.gson.his.model.pojos.lrn;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_ITEM", schema = "HIS", catalog = "")
public class OperationItemEntity {
    private int operationItemId;
    private String operationItemName;
    private Long operationItemPrice;
    private String operationItemType;
    private String operationItemDress;
    private Integer depaId;
    private String operationItemIndication;
    private String operationItemAnaesthesia;
    private String operationItemTaboo;
    private String operationItemMatter;
    private Integer operationItemDrugs;

    @Id
    @Column(name = "OPERATION_ITEM_ID")
    public int getOperationItemId() {
        return operationItemId;
    }

    public void setOperationItemId(int operationItemId) {
        this.operationItemId = operationItemId;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_NAME")
    public String getOperationItemName() {
        return operationItemName;
    }

    public void setOperationItemName(String operationItemName) {
        this.operationItemName = operationItemName;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_PRICE")
    public Long getOperationItemPrice() {
        return operationItemPrice;
    }

    public void setOperationItemPrice(Long operationItemPrice) {
        this.operationItemPrice = operationItemPrice;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_TYPE")
    public String getOperationItemType() {
        return operationItemType;
    }

    public void setOperationItemType(String operationItemType) {
        this.operationItemType = operationItemType;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_DRESS")
    public String getOperationItemDress() {
        return operationItemDress;
    }

    public void setOperationItemDress(String operationItemDress) {
        this.operationItemDress = operationItemDress;
    }

    @Basic
    @Column(name = "DEPA_ID")
    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_INDICATION")
    public String getOperationItemIndication() {
        return operationItemIndication;
    }

    public void setOperationItemIndication(String operationItemIndication) {
        this.operationItemIndication = operationItemIndication;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_ANAESTHESIA")
    public String getOperationItemAnaesthesia() {
        return operationItemAnaesthesia;
    }

    public void setOperationItemAnaesthesia(String operationItemAnaesthesia) {
        this.operationItemAnaesthesia = operationItemAnaesthesia;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_TABOO")
    public String getOperationItemTaboo() {
        return operationItemTaboo;
    }

    public void setOperationItemTaboo(String operationItemTaboo) {
        this.operationItemTaboo = operationItemTaboo;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_MATTER")
    public String getOperationItemMatter() {
        return operationItemMatter;
    }

    public void setOperationItemMatter(String operationItemMatter) {
        this.operationItemMatter = operationItemMatter;
    }

    @Basic
    @Column(name = "OPERATION_ITEM_DRUGS")
    public Integer getOperationItemDrugs() {
        return operationItemDrugs;
    }

    public void setOperationItemDrugs(Integer operationItemDrugs) {
        this.operationItemDrugs = operationItemDrugs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationItemEntity that = (OperationItemEntity) o;
        return operationItemId == that.operationItemId &&
                Objects.equals(operationItemName, that.operationItemName) &&
                Objects.equals(operationItemPrice, that.operationItemPrice) &&
                Objects.equals(operationItemType, that.operationItemType) &&
                Objects.equals(operationItemDress, that.operationItemDress) &&
                Objects.equals(depaId, that.depaId) &&
                Objects.equals(operationItemIndication, that.operationItemIndication) &&
                Objects.equals(operationItemAnaesthesia, that.operationItemAnaesthesia) &&
                Objects.equals(operationItemTaboo, that.operationItemTaboo) &&
                Objects.equals(operationItemMatter, that.operationItemMatter) &&
                Objects.equals(operationItemDrugs, that.operationItemDrugs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationItemId, operationItemName, operationItemPrice, operationItemType, operationItemDress, depaId, operationItemIndication, operationItemAnaesthesia, operationItemTaboo, operationItemMatter, operationItemDrugs);
    }
}
