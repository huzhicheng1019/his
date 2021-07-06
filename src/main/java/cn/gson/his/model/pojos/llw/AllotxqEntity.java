package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ALLOTXQ", schema = "HIS", catalog = "")
public class AllotxqEntity {
    private int allotxqId;
    private Integer allotId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer sl;
    private String ph;
    private String bz;
    private Integer libraryId;
    private Integer libraryxqId;

    @Id
    @Column(name = "ALLOTXQ_ID")
    public int getAllotxqId() {
        return allotxqId;
    }

    public void setAllotxqId(int allotxqId) {
        this.allotxqId = allotxqId;
    }

    @Basic
    @Column(name = "ALLOT_ID")
    public Integer getAllotId() {
        return allotId;
    }

    public void setAllotId(Integer allotId) {
        this.allotId = allotId;
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

    @Basic
    @Column(name = "LIBRARY_ID")
    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Basic
    @Column(name = "LIBRARYXQ_ID")
    public Integer getLibraryxqId() {
        return libraryxqId;
    }

    public void setLibraryxqId(Integer libraryxqId) {
        this.libraryxqId = libraryxqId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllotxqEntity that = (AllotxqEntity) o;
        return allotxqId == that.allotxqId &&
                Objects.equals(allotId, that.allotId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(bz, that.bz) &&
                Objects.equals(libraryId, that.libraryId) &&
                Objects.equals(libraryxqId, that.libraryxqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allotxqId, allotId, productId, productName, productFl, sl, ph, bz, libraryId, libraryxqId);
    }
}
