package cn.gson.his.model.pojos.Drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "LIBRARYXQ", schema = "HIS")
public class LibraryxqEntity {
    private int libraryxqId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer kcs;
    private String ph;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp scdate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp gqdate;
    private Integer libraryId;
    private Long price;
    private String ge;
    private Integer qskcs;
    private GysEntity gys;
    private Long sjprice;

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
    public String getProductFl() {
        return productFl;
    }

    public void setProductFl(String productFl) {
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

    @Basic
    @Column(name = "QSKCS")
    public Integer getQskcs() {
        return qskcs;
    }

    public void setQskcs(Integer qskcs) {
        this.qskcs = qskcs;
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
    @Column(name = "SJPRICE")
    public Long getSjprice() {
        return sjprice;
    }

    public void setSjprice(Long sjprice) {
        this.sjprice = sjprice;
    }


    public LibraryxqEntity() {
    }

    public LibraryxqEntity(Integer productId, String productName, String productFl, Integer kcs, String ph, Timestamp scdate, Timestamp gqdate, Integer libraryId, Long price, String ge, Integer qskcs, GysEntity gys, Long sjprice) {
        this.productId = productId;
        this.productName = productName;
        this.productFl = productFl;
        this.kcs = kcs;
        this.ph = ph;
        this.scdate = scdate;
        this.gqdate = gqdate;
        this.libraryId = libraryId;
        this.price = price;
        this.ge = ge;
        this.qskcs = qskcs;
        this.gys = gys;
        this.sjprice = sjprice;
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
                Objects.equals(qskcs, that.qskcs) &&
                Objects.equals(gys, that.gys) &&
                Objects.equals(sjprice, that.sjprice) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryxqId, productId, productName, productFl, kcs, ph, scdate, gqdate, libraryId,ge,price,qskcs,gys,sjprice);
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
                ", qskcs=" + qskcs +
                '}';
    }
}
