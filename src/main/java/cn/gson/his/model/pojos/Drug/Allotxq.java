package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Allotxq {
    private Integer allotxqId;
    private Integer allotId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer sl;
    private String ph;
    private String bz;
    private Timestamp scdate;
    private String ge;
    private GysEntity gys;
    private Timestamp gqdate;
    private Long price;
    private LibraryInfoEntity libraryto;//调离仓库


    @Id
    @Column(name = "ALLOTXQ_ID", nullable = false, precision = 0)
    public Integer getAllotxqId() {
        return allotxqId;
    }

    public void setAllotxqId(Integer allotxqId) {
        this.allotxqId = allotxqId;
    }

    @Basic
    @Column(name = "ALLOT_ID", nullable = true, precision = 0)
    public Integer getAllotId() {
        return allotId;
    }

    public void setAllotId(Integer allotId) {
        this.allotId = allotId;
    }

    @Basic
    @Column(name = "PRODUCT_ID", nullable = true, precision = 0)
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PRODUCT_NAME", nullable = true, length = 1024)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "PRODUCT_FL", nullable = true, length = 1024)
    public String getProductFl() {
        return productFl;
    }

    public void setProductFl(String productFl) {
        this.productFl = productFl;
    }

    @Basic
    @Column(name = "SL", nullable = true, precision = 0)
    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    @Basic
    @Column(name = "PH", nullable = true, length = 1024)
    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    @Basic
    @Column(name = "BZ", nullable = true, length = 3072)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "SCDATE", nullable = true)
    public Timestamp getScdate() {
        return scdate;
    }

    public void setScdate(Timestamp scdate) {
        this.scdate = scdate;
    }

    @Basic
    @Column(name = "GE", nullable = true, length = 1024)
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

    @Basic
    @Column(name = "GQDATE", nullable = true)
    public Timestamp getGqdate() {
        return gqdate;
    }

    public void setGqdate(Timestamp gqdate) {
        this.gqdate = gqdate;
    }

    @Basic
    @Column(name = "PRICE", nullable = true, precision = 8)
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "LIBRARYTO_ID", referencedColumnName = "LIBRARY_ID")
    public LibraryInfoEntity getLibraryto() {
        return libraryto;
    }

    public void setLibraryto(LibraryInfoEntity libraryto) {
        this.libraryto = libraryto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allotxq allotxq = (Allotxq) o;
        return Objects.equals(allotxqId, allotxq.allotxqId) && Objects.equals(allotId, allotxq.allotId) && Objects.equals(productId, allotxq.productId) && Objects.equals(productName, allotxq.productName) && Objects.equals(productFl, allotxq.productFl) && Objects.equals(sl, allotxq.sl) && Objects.equals(ph, allotxq.ph) && Objects.equals(bz, allotxq.bz) && Objects.equals(scdate, allotxq.scdate) && Objects.equals(ge, allotxq.ge) && Objects.equals(gys, allotxq.gys) && Objects.equals(gqdate, allotxq.gqdate) &&  Objects.equals(libraryto, allotxq.libraryto) && Objects.equals(price, allotxq.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allotxqId, allotId, productId, productName, productFl, sl, ph, bz, scdate, ge, gys, gqdate, libraryto, price);
    }
}
