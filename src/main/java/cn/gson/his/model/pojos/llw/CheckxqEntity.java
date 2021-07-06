package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHECKXQ", schema = "HIS", catalog = "")
public class CheckxqEntity {
    private int checkxqId;
    private Integer productId;
    private String productName;
    private Integer checkId;
    private Integer productFl;
    private Integer sjkc;
    private Integer pdjg;

    @Id
    @Column(name = "CHECKXQ_ID")
    public int getCheckxqId() {
        return checkxqId;
    }

    public void setCheckxqId(int checkxqId) {
        this.checkxqId = checkxqId;
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
    @Column(name = "CHECK_ID")
    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "PRODUCT_FL")
    public Integer getProductFl() {
        return productFl;
    }

    public void setProductFl(Integer productFl) {
        this.productFl = productFl;
    }

    @Basic
    @Column(name = "SJKC")
    public Integer getSjkc() {
        return sjkc;
    }

    public void setSjkc(Integer sjkc) {
        this.sjkc = sjkc;
    }

    @Basic
    @Column(name = "PDJG")
    public Integer getPdjg() {
        return pdjg;
    }

    public void setPdjg(Integer pdjg) {
        this.pdjg = pdjg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckxqEntity that = (CheckxqEntity) o;
        return checkxqId == that.checkxqId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(checkId, that.checkId) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(sjkc, that.sjkc) &&
                Objects.equals(pdjg, that.pdjg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkxqId, productId, productName, checkId, productFl, sjkc, pdjg);
    }
}
