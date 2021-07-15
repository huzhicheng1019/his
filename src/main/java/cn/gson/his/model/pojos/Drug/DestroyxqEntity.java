package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DESTROYXQ", schema = "HIS", catalog = "")
public class DestroyxqEntity {
    private int destroyxqId;
    private Integer destroyId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer sl;
    private String ph;
    private String why;
    private String bz;
    private Integer libraryId;
    private Integer libraryxqId;

    @Id
    @Column(name = "DESTROYXQ_ID")
    public int getDestroyxqId() {
        return destroyxqId;
    }

    public void setDestroyxqId(int destroyxqId) {
        this.destroyxqId = destroyxqId;
    }

    @Basic
    @Column(name = "DESTROY_ID")
    public Integer getDestroyId() {
        return destroyId;
    }

    public void setDestroyId(Integer destroyId) {
        this.destroyId = destroyId;
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
    @Column(name = "WHY")
    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
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
        DestroyxqEntity that = (DestroyxqEntity) o;
        return destroyxqId == that.destroyxqId &&
                Objects.equals(destroyId, that.destroyId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(why, that.why) &&
                Objects.equals(bz, that.bz) &&
                Objects.equals(libraryId, that.libraryId) &&
                Objects.equals(libraryxqId, that.libraryxqId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destroyxqId, destroyId, productId, productName, productFl, sl, ph, why, bz, libraryId, libraryxqId);
    }
}
