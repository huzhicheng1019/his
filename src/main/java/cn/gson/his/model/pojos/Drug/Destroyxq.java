package cn.gson.his.model.pojos.Drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Destroyxq {
    private Integer destroyxqId;
    private Integer destroyId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer sl;
    private String ph;
    private String why;
    private String bz;
    private LibraryInfoEntity library;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp scdate;
    private String ge;
    private GysEntity gys;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp gqdate;
    private Long price;
    private String kszt;
    private Integer gesl;
    private String shdw;
    private Long sjprice;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "DESTROYXQ_ID", nullable = false, precision = 0)
    public Integer getDestroyxqId() {
        return destroyxqId;
    }

    public void setDestroyxqId(Integer destroyxqId) {
        this.destroyxqId = destroyxqId;
    }

    @Basic
    @Column(name = "DESTROY_ID", nullable = true, precision = 0)
    public Integer getDestroyId() {
        return destroyId;
    }

    public void setDestroyId(Integer destroyId) {
        this.destroyId = destroyId;
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
    @Column(name = "WHY", nullable = true, length = 3072)
    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    @Basic
    @Column(name = "BZ", nullable = true, length = 3072)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "LIBRARY_ID")
    public LibraryInfoEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryInfoEntity library) {
        this.library = library;
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

    @Basic
    @Column(name = "KSZT", nullable = true, length = 255)
    public String getKszt() {
        return kszt;
    }

    public void setKszt(String kszt) {
        this.kszt = kszt;
    }

    @Basic
    @Column(name = "GESL", nullable = true, precision = 0)
    public Integer getGesl() {
        return gesl;
    }

    public void setGesl(Integer gesl) {
        this.gesl = gesl;
    }

    @Basic
    @Column(name = "SHDW", nullable = true, length = 255)
    public String getShdw() {
        return shdw;
    }

    public void setShdw(String shdw) {
        this.shdw = shdw;
    }

    @Basic
    @Column(name = "SJPRICE", nullable = true, precision = 0)
    public Long getSjprice() {
        return sjprice;
    }

    public void setSjprice(Long sjprice) {
        this.sjprice = sjprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destroyxq destroyxq = (Destroyxq) o;
        return Objects.equals(destroyxqId, destroyxq.destroyxqId) && Objects.equals(destroyId, destroyxq.destroyId) && Objects.equals(productId, destroyxq.productId) && Objects.equals(productName, destroyxq.productName) && Objects.equals(productFl, destroyxq.productFl) && Objects.equals(sl, destroyxq.sl) && Objects.equals(ph, destroyxq.ph) && Objects.equals(why, destroyxq.why) && Objects.equals(bz, destroyxq.bz) && Objects.equals(library, destroyxq.library) && Objects.equals(scdate, destroyxq.scdate) && Objects.equals(ge, destroyxq.ge) && Objects.equals(gys, destroyxq.gys) && Objects.equals(gqdate, destroyxq.gqdate) && Objects.equals(price, destroyxq.price) && Objects.equals(kszt, destroyxq.kszt) && Objects.equals(gesl, destroyxq.gesl) && Objects.equals(shdw, destroyxq.shdw) && Objects.equals(sjprice, destroyxq.sjprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destroyxqId, destroyId, productId, productName, productFl, sl, ph, why, bz, library, scdate, ge, gys, gqdate, price, kszt, gesl, shdw, sjprice);
    }
}
