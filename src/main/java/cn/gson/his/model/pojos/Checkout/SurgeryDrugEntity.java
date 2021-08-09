package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SURGERY_DRUG", schema = "HIS", catalog = "")
public class SurgeryDrugEntity {
    private long dId;
    private Long dNum;
    private Long dPrice;
    private OperationItemEntity opeation;
    private YpEntity drug;

    @Id
    @Column(name = "D_ID")
    public long getdId() {
        return dId;
    }

    public void setdId(long dId) {
        this.dId = dId;
    }


    @Basic
    @Column(name = "D_NUM")
    public Long getdNum() {
        return dNum;
    }

    public void setdNum(Long dNum) {
        this.dNum = dNum;
    }

    @Basic
    @Column(name = "D_PRICE")
    public Long getdPrice() {
        return dPrice;
    }

    public void setdPrice(Long dPrice) {
        this.dPrice = dPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurgeryDrugEntity that = (SurgeryDrugEntity) o;
        return dId == that.dId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dId, dNum, dPrice);
    }

    @ManyToOne
    @JoinColumn(name = "OPERATION_ID", referencedColumnName = "OPERATION_ID")
    public OperationItemEntity getOpeation() {
        return opeation;
    }

    public void setOpeation(OperationItemEntity opeation) {
        this.opeation = opeation;
    }

    @ManyToOne
    @JoinColumn(name = "DRUG_ID", referencedColumnName = "DRUG_ID")
    public YpEntity getDrug() {
        return drug;
    }

    public void setDrug(YpEntity drug) {
        this.drug = drug;
    }
}
