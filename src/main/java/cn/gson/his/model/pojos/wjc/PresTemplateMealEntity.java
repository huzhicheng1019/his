package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRES_TEMPLATE_MEAL", schema = "HIS", catalog = "")
public class PresTemplateMealEntity {
    private int mealNo;
    private Integer paypartNo;
    private Integer drugId;
    private Integer checklistNo;
    private Integer changetestNo;

    @Id
    @Column(name = "MEAL_NO")
    public int getMealNo() {
        return mealNo;
    }

    public void setMealNo(int mealNo) {
        this.mealNo = mealNo;
    }

    @Basic
    @Column(name = "PAYPART_NO")
    public Integer getPaypartNo() {
        return paypartNo;
    }

    public void setPaypartNo(Integer paypartNo) {
        this.paypartNo = paypartNo;
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
    @Column(name = "CHECKLIST_NO")
    public Integer getChecklistNo() {
        return checklistNo;
    }

    public void setChecklistNo(Integer checklistNo) {
        this.checklistNo = checklistNo;
    }

    @Basic
    @Column(name = "CHANGETEST_NO")
    public Integer getChangetestNo() {
        return changetestNo;
    }

    public void setChangetestNo(Integer changetestNo) {
        this.changetestNo = changetestNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresTemplateMealEntity that = (PresTemplateMealEntity) o;
        return mealNo == that.mealNo &&
                Objects.equals(paypartNo, that.paypartNo) &&
                Objects.equals(drugId, that.drugId) &&
                Objects.equals(checklistNo, that.checklistNo) &&
                Objects.equals(changetestNo, that.changetestNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealNo, paypartNo, drugId, checklistNo, changetestNo);
    }
}
