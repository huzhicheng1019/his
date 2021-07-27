package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT", schema = "HIS")
public class ProductEntity {
    private int planxqId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer planId;
    private Long price;
    private Integer sl;
    private String ge;
    private GysEntity gys;


    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
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
    @Column(name = "GE")
    public String getGe() {
        return ge;
    }

    public void setGe(String ge) {
        this.ge = ge;
    }

    @ManyToOne
    @JoinColumn(name = "GYS_ID", referencedColumnName = "GYS_ID")
    public GysEntity getGys() {
        return gys;
    }

    public void setGys(GysEntity gys) {
        this.gys = gys;
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
                Objects.equals(gys, that.gys) &&
                Objects.equals(ge, that.ge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planxqId, productId, productName, productFl, planId, price, sl, ge,gys);
    }
}
