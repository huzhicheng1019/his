package cn.gson.his.model.pojos.Drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "LIBRARYXQ", schema = "HIS", catalog = "")
public class LibraryxqEntity {
    private int libraryxqId;
    private Integer productId;
    private String productName;
    private Integer productFl;
    private Integer kcs;
    private String ph;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp scdate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp gqdate;
    private Integer libraryId;
    private Long price;
    private String ge;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "LIBRARYXQ_ID")
    public int getLibraryxqId() {
        return libraryxqId;
    }

    public void setLibraryxqId(int libraryxqId) {
        this.libraryxqId = libraryxqId;
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
    @Column(name = "KCS")
    public Integer getKcs() {
        return kcs;
    }

    public void setKcs(Integer kcs) {
        this.kcs = kcs;
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
    @Column(name = "SCDATE")
    public Timestamp getScdate() {
        return scdate;
    }

    public void setScdate(Timestamp scdate) {
        this.scdate = scdate;
    }

    @Basic
    @Column(name = "GQDATE")
    public Timestamp getGqdate() {
        return gqdate;
    }

    public void setGqdate(Timestamp gqdate) {
        this.gqdate = gqdate;
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
    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "GE")
    public String getGe() {
        return ge;
    }

    public void setGe(String ge) {
        this.ge = ge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryxqEntity that = (LibraryxqEntity) o;
        return libraryxqId == that.libraryxqId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(kcs, that.kcs) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(scdate, that.scdate) &&
                Objects.equals(gqdate, that.gqdate) &&
                Objects.equals(libraryId, that.libraryId) &&
                Objects.equals(ge, that.ge) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryxqId, productId, productName, productFl, kcs, ph, scdate, gqdate, libraryId,ge,price);
    }

    @Override
    public String toString() {
        return "LibraryxqEntity{" +
                "libraryxqId=" + libraryxqId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productFl=" + productFl +
                ", kcs=" + kcs +
                ", ph='" + ph + '\'' +
                ", scdate=" + scdate +
                ", gqdate=" + gqdate +
                ", libraryId=" + libraryId +
                ", price=" + price +
                ", ge='" + ge + '\'' +
                '}';
    }
}
