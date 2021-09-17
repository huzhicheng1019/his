package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHANGEPART", schema = "HIS", catalog = "")
public class ChangepartEntity {
    private int changepartNo;//详情编号
    private String changetestNo;//化验项目编号
    private CheckoutEntity checkoutNo;//化验单外键
    private String checkoutResult;//化验结果

    @Id
    @Column(name = "CHANGEPART_NO")
    public int getChangepartNo() {
        return changepartNo;
    }

    public void setChangepartNo(int changepartNo) {
        this.changepartNo = changepartNo;
    }

    @Basic
    @Column(name = "CHANGETEST_NO")
    public String getChangetestNo() {
        return changetestNo;
    }

    public void setChangetestNo(String changetestNo) {
        this.changetestNo = changetestNo;
    }

    @OneToOne
    @Column(name = "CHECKOUT_NO",nullable = false)
    public CheckoutEntity getCheckoutNo() {
        return checkoutNo;
    }

    public void setCheckoutNo(CheckoutEntity checkoutNo) {
        this.checkoutNo = checkoutNo;
    }

    @Basic
    @Column(name = "CHECKOUT_RESULT")
    public String getCheckoutResult() {
        return checkoutResult;
    }

    public void setCheckoutResult(String checkoutResult) {
        this.checkoutResult = checkoutResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChangepartEntity that = (ChangepartEntity) o;
        return changepartNo == that.changepartNo &&
                Objects.equals(changetestNo, that.changetestNo) &&
                Objects.equals(checkoutNo, that.checkoutNo) &&
                Objects.equals(checkoutResult, that.checkoutResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changepartNo, changetestNo, checkoutNo, checkoutResult);
    }
}
