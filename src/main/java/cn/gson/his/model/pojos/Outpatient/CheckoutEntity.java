package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHECKOUT", schema = "HIS", catalog = "")
public class CheckoutEntity {
    private int checkoutNo;
    private Integer checkoutId;
    private String checkoutCribe;
    private Long checkoutPrice;
    private Integer checkoutState;

    @Id
    @Column(name = "CHECKOUT_NO")
    public int getCheckoutNo() {
        return checkoutNo;
    }

    public void setCheckoutNo(int checkoutNo) {
        this.checkoutNo = checkoutNo;
    }

    @Basic
    @Column(name = "CHECKOUT_ID")
    public Integer getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Integer checkoutId) {
        this.checkoutId = checkoutId;
    }

    @Basic
    @Column(name = "CHECKOUT_CRIBE")
    public String getCheckoutCribe() {
        return checkoutCribe;
    }

    public void setCheckoutCribe(String checkoutCribe) {
        this.checkoutCribe = checkoutCribe;
    }

    @Basic
    @Column(name = "CHECKOUT_PRICE")
    public Long getCheckoutPrice() {
        return checkoutPrice;
    }

    public void setCheckoutPrice(Long checkoutPrice) {
        this.checkoutPrice = checkoutPrice;
    }

    @Basic
    @Column(name = "CHECKOUT_STATE")
    public Integer getCheckoutState() {
        return checkoutState;
    }

    public void setCheckoutState(Integer checkoutState) {
        this.checkoutState = checkoutState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckoutEntity that = (CheckoutEntity) o;
        return checkoutNo == that.checkoutNo &&
                Objects.equals(checkoutId, that.checkoutId) &&
                Objects.equals(checkoutCribe, that.checkoutCribe) &&
                Objects.equals(checkoutPrice, that.checkoutPrice) &&
                Objects.equals(checkoutState, that.checkoutState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkoutNo, checkoutId, checkoutCribe, checkoutPrice, checkoutState);
    }
}
