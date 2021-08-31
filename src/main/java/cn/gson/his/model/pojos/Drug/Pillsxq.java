package cn.gson.his.model.pojos.Drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Pillsxq {
    private Integer pillsxqId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer sl;
    private Long drugPrice;
    private String dw;
    private String drugGe;
    private String ph;
    private String bz;
    private String pillsId;
    private String kszt;
    private Integer gesl;
    private String shdw;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp scdate;
    private GysEntity gys;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp gqdate;
    private Long price;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "PILLSXQ_ID", nullable = false, precision = 0)
    public Integer getPillsxqId() {
        return pillsxqId;
    }

    public void setPillsxqId(Integer pillsxqId) {
        this.pillsxqId = pillsxqId;
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
    @Column(name = "PRODUCT_FL", nullable = true, precision = 0)
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
    @Column(name = "DRUG_PRICE", nullable = true, precision = 8)
    public Long getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Long drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Basic
    @Column(name = "DW", nullable = true, length = 1024)
    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }


    @Basic
    @Column(name = "DRUG_GE", nullable = true, length = 1024)
    public String getDrugGe() {
        return drugGe;
    }

    public void setDrugGe(String drugGe) {
        this.drugGe = drugGe;
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
    @Column(name = "PILLS_ID", nullable = true, precision = 0)
    public String getPillsId() {
        return pillsId;
    }

    public void setPillsId(String pillsId) {
        this.pillsId = pillsId;
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
    @Column(name = "SCDATE", nullable = true)
    public Timestamp getScdate() {
        return scdate;
    }

    public void setScdate(Timestamp scdate) {
        this.scdate = scdate;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pillsxq pillsxq = (Pillsxq) o;
        return Objects.equals(pillsxqId, pillsxq.pillsxqId) && Objects.equals(productId, pillsxq.productId) && Objects.equals(productName, pillsxq.productName) && Objects.equals(productFl, pillsxq.productFl) && Objects.equals(sl, pillsxq.sl) && Objects.equals(drugPrice, pillsxq.drugPrice) && Objects.equals(dw, pillsxq.dw) && Objects.equals(drugGe, pillsxq.drugGe) && Objects.equals(ph, pillsxq.ph) && Objects.equals(bz, pillsxq.bz) && Objects.equals(pillsId, pillsxq.pillsId) && Objects.equals(kszt, pillsxq.kszt) && Objects.equals(gesl, pillsxq.gesl) && Objects.equals(shdw, pillsxq.shdw) && Objects.equals(scdate, pillsxq.scdate) && Objects.equals(gys, pillsxq.gys) && Objects.equals(gqdate, pillsxq.gqdate)  && Objects.equals(price, pillsxq.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pillsxqId, productId, productName, productFl, sl, drugPrice, dw, drugGe, ph, bz, pillsId, kszt, gesl, shdw, scdate, gys, gqdate, price);
    }
}
