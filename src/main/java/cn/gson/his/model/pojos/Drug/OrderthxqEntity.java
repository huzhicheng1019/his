package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ORDERTHXQ", schema = "HIS", catalog = "")
public class OrderthxqEntity {
    private int orderthxqId;
    private Integer productId;
    private String productName;
    private Integer productFl;
    private Integer orderthId;
    private Integer sl;
    private String ph;
    private Timestamp mfg;
    private Long price;
    private Integer libraryId;

    @Id
    @Column(name = "ORDERTHXQ_ID")
    public int getOrderthxqId() {
        return orderthxqId;
    }

    public void setOrderthxqId(int orderthxqId) {
        this.orderthxqId = orderthxqId;
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
    @Column(name = "ORDERTH_ID")
    public Integer getOrderthId() {
        return orderthId;
    }

    public void setOrderthId(Integer orderthId) {
        this.orderthId = orderthId;
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
    @Column(name = "MFG")
    public Timestamp getMfg() {
        return mfg;
    }

    public void setMfg(Timestamp mfg) {
        this.mfg = mfg;
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
    @Column(name = "LIBRARY_ID")
    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderthxqEntity that = (OrderthxqEntity) o;
        return orderthxqId == that.orderthxqId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(orderthId, that.orderthId) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(mfg, that.mfg) &&
                Objects.equals(price, that.price) &&
                Objects.equals(libraryId, that.libraryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderthxqId, productId, productName, productFl, orderthId, sl, ph, mfg, price, libraryId);
    }
}
