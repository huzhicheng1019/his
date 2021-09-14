package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PAYPART", schema = "HIS", catalog = "")
public class PaypartEntity {
    private int paypartNo;
    private PayEntity payNo;
    private String drugName;
    private Integer drugQuantity;
    private Long drugPrice;
    private String checklistName;
    private Long checklistPrice;
    private String changetestName;
    private Long changetestPrice;

    @Id
    @Column(name = "PAYPART_NO")
    public int getPaypartNo() {
        return paypartNo;
    }

    public void setPaypartNo(int paypartNo) {
        this.paypartNo = paypartNo;
    }

    @OneToOne
    @Column(name = "PAY_NO",nullable = false)
    public PayEntity getPayNo() {
        return payNo;
    }

    public void setPayNo(PayEntity payNo) {
        this.payNo = payNo;
    }

    @Basic
    @Column(name = "DRUG_NAME")
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Basic
    @Column(name = "DRUG_QUANTITY")
    public Integer getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(Integer drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    @Basic
    @Column(name = "DRUG_PRICE")
    public Long getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Long drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Basic
    @Column(name = "CHECKLIST_NAME")
    public String getChecklistName() {
        return checklistName;
    }

    public void setChecklistName(String checklistName) {
        this.checklistName = checklistName;
    }

    @Basic
    @Column(name = "CHECKLIST_PRICE")
    public Long getChecklistPrice() {
        return checklistPrice;
    }

    public void setChecklistPrice(Long checklistPrice) {
        this.checklistPrice = checklistPrice;
    }

    @Basic
    @Column(name = "CHANGETEST_NAME ")
    public String getChangetestName() {
        return changetestName;
    }

    public void setChangetestName(String changetestName) {
        this.changetestName = changetestName;
    }

    @Basic
    @Column(name = "CHANGETEST_PRICE")
    public Long getChangetestPrice() {
        return changetestPrice;
    }

    public void setChangetestPrice(Long changetestPrice) {
        this.changetestPrice = changetestPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaypartEntity that = (PaypartEntity) o;
        return paypartNo == that.paypartNo &&
                Objects.equals(payNo, that.payNo) &&
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(drugQuantity, that.drugQuantity) &&
                Objects.equals(drugPrice, that.drugPrice) &&
                Objects.equals(checklistName, that.checklistName) &&
                Objects.equals(checklistPrice, that.checklistPrice) &&
                Objects.equals(changetestName, that.changetestName) &&
                Objects.equals(changetestPrice, that.changetestPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paypartNo, payNo, drugName, drugQuantity, drugPrice, checklistName, checklistPrice, changetestName, changetestPrice);
    }
}
