package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHUJL", schema = "HIS", catalog = "")
public class ChujlEntity {
    private int chujlId;
    private Integer productId;
    private String productName;
    private Integer productFl;
    private Integer sl;
    private String ph;
    private Integer chuId;

    @Id
    @Column(name = "CHUJL_ID")
    public int getChujlId() {
        return chujlId;
    }

    public void setChujlId(int chujlId) {
        this.chujlId = chujlId;
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
    public Integer getProductFl() {
        return productFl;
    }

    public void setProductFl(Integer productFl) {
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
    @Column(name = "CHU_ID")
    public Integer getChuId() {
        return chuId;
    }

    public void setChuId(Integer chuId) {
        this.chuId = chuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChujlEntity that = (ChujlEntity) o;
        return chujlId == that.chujlId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(chuId, that.chuId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chujlId, productId, productName, productFl, sl, ph, chuId);
    }
}
