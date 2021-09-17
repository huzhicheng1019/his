package cn.gson.his.model.pojos.Drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Checkxq {
    private Integer checkxqId;
    private Integer productId;
    private String productName;
    private String checkId;
    private String productFl;
    private Integer sjkc;
    private Integer pdjg;
    private Integer kcs;
    private String ph;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp scdate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp gqdate;
    private Long price;
    private String ge;
    private GysEntity gys;
    private Long sjprice;
    private String kszt;
    private Integer gesl;
    private String shdw;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "CHECKXQ_ID", nullable = false, precision = 0)
    public Integer getCheckxqId() {
        return checkxqId;
    }

    public void setCheckxqId(Integer checkxqId) {
        this.checkxqId = checkxqId;
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
    @Column(name = "CHECK_ID", nullable = true, length = 255)
    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "PRODUCT_FL", nullable = true, precision = 0)
    public String getProductFl() {
        return productFl;
    }

    public void setProductFl(String productFl) {
        this.productFl = productFl;
    }

    @Basic
    @Column(name = "SJKC", nullable = true, precision = 0)
    public Integer getSjkc() {
        return sjkc;
    }

    public void setSjkc(Integer sjkc) {
        this.sjkc = sjkc;
    }

    @Basic
    @Column(name = "PDJG", nullable = true, precision = 0)
    public Integer getPdjg() {
        return pdjg;
    }

    public void setPdjg(Integer pdjg) {
        this.pdjg = pdjg;
    }

    @Basic
    @Column(name = "KCS", nullable = true, precision = 0)
    public Integer getKcs() {
        return kcs;
    }

    public void setKcs(Integer kcs) {
        this.kcs = kcs;
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
    @Column(name = "SCDATE", nullable = true)
    public Timestamp getScdate() {
        return scdate;
    }

    public void setScdate(Timestamp scdate) {
        this.scdate = scdate;
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
    @Column(name = "SJPRICE", nullable = true, precision = 0)
    public Long getSjprice() {
        return sjprice;
    }

    public void setSjprice(Long sjprice) {
        this.sjprice = sjprice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkxq checkxq = (Checkxq) o;
        return Objects.equals(checkxqId, checkxq.checkxqId) && Objects.equals(productId, checkxq.productId) && Objects.equals(productName, checkxq.productName) && Objects.equals(checkId, checkxq.checkId) && Objects.equals(productFl, checkxq.productFl) && Objects.equals(sjkc, checkxq.sjkc) && Objects.equals(pdjg, checkxq.pdjg) && Objects.equals(kcs, checkxq.kcs) && Objects.equals(ph, checkxq.ph) && Objects.equals(scdate, checkxq.scdate) && Objects.equals(gqdate, checkxq.gqdate) && Objects.equals(price, checkxq.price) && Objects.equals(ge, checkxq.ge) && Objects.equals(gys, checkxq.gys) && Objects.equals(sjprice, checkxq.sjprice) && Objects.equals(kszt, checkxq.kszt) && Objects.equals(gesl, checkxq.gesl) && Objects.equals(shdw, checkxq.shdw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkxqId, productId, productName, checkId, productFl, sjkc, pdjg, kcs, ph, scdate, gqdate, price, ge, gys, sjprice, kszt, gesl, shdw);
    }
}
