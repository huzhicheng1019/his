package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "STOJL", schema = "HIS", catalog = "")
public class StojlEntity {
    private int stojlId;
    private Integer stoId;
    private String productName;
    private Integer productId;
    private String productFl;
    private Integer sl;
    private String ph;
    private String bz;

    @Id
    @Column(name = "STOJL_ID")
    public int getStojlId() {
        return stojlId;
    }

    public void setStojlId(int stojlId) {
        this.stojlId = stojlId;
    }

    @Basic
    @Column(name = "STO_ID")
    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
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
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    @Basic
    @Column(name = "BZ")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StojlEntity that = (StojlEntity) o;
        return stojlId == that.stojlId &&
                Objects.equals(stoId, that.stoId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stojlId, stoId, productName, productId, productFl, sl, ph, bz);
    }
}
