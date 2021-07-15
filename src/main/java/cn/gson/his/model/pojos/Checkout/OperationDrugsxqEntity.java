package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_DRUGSXQ", schema = "HIS", catalog = "")
public class OperationDrugsxqEntity {
    private int drugxqId;
    private Integer operationDrugsId;
    private Integer drugId;
    private String drugSm;
    private String dw;
    private Integer drugType;
    private String drugGe;
    private Integer drugCount;

    @Id
    @Column(name = "DRUGXQ_ID")
    public int getDrugxqId() {
        return drugxqId;
    }

    public void setDrugxqId(int drugxqId) {
        this.drugxqId = drugxqId;
    }

    @Basic
    @Column(name = "OPERATION_DRUGS_ID")
    public Integer getOperationDrugsId() {
        return operationDrugsId;
    }

    public void setOperationDrugsId(Integer operationDrugsId) {
        this.operationDrugsId = operationDrugsId;
    }

    @Basic
    @Column(name = "DRUG_ID")
    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    @Basic
    @Column(name = "DRUG_SM")
    public String getDrugSm() {
        return drugSm;
    }

    public void setDrugSm(String drugSm) {
        this.drugSm = drugSm;
    }

    @Basic
    @Column(name = "DW")
    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    @Basic
    @Column(name = "DRUG_TYPE")
    public Integer getDrugType() {
        return drugType;
    }

    public void setDrugType(Integer drugType) {
        this.drugType = drugType;
    }

    @Basic
    @Column(name = "DRUG_GE")
    public String getDrugGe() {
        return drugGe;
    }

    public void setDrugGe(String drugGe) {
        this.drugGe = drugGe;
    }

    @Basic
    @Column(name = "DRUG_COUNT")
    public Integer getDrugCount() {
        return drugCount;
    }

    public void setDrugCount(Integer drugCount) {
        this.drugCount = drugCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationDrugsxqEntity that = (OperationDrugsxqEntity) o;
        return drugxqId == that.drugxqId &&
                Objects.equals(operationDrugsId, that.operationDrugsId) &&
                Objects.equals(drugId, that.drugId) &&
                Objects.equals(drugSm, that.drugSm) &&
                Objects.equals(dw, that.dw) &&
                Objects.equals(drugType, that.drugType) &&
                Objects.equals(drugGe, that.drugGe) &&
                Objects.equals(drugCount, that.drugCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugxqId, operationDrugsId, drugId, drugSm, dw, drugType, drugGe, drugCount);
    }
}
