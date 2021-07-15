package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT", schema = "HIS", catalog = "")
public class ProductEntity {
    private int planxqId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer planId;
    private Long price;
    private Integer sl;
    private String ph;

    @Id
    @Column(name = "PLANXQ_ID")
    public int getPlanxqId() {
        return planxqId;
    }

    public void setPlanxqId(int planxqId) {
        this.planxqId = planxqId;
    }

    @Basic
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "PRODUCT_FL")
    public String getProductFl() {
        return productFl;
    }

    public void setProductFl(String productFl) {
        this.productFl = productFl;
    }

    @Basic
    @Column(name = "PLAN_ID")
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "SL")
    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    @Basic
    @Column(name = "PH")
    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return planxqId == that.planxqId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(planId, that.planId) &&
                Objects.equals(price, that.price) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(ph, that.ph);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planxqId, productId, productName, productFl, planId, price, sl, ph);
    }
}
