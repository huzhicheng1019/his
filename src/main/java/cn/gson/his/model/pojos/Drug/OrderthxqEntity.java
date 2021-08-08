package cn.gson.his.model.pojos.Drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ORDERTHXQ", schema = "HIS")
public class OrderthxqEntity {
    private int orderthxqId;
    private Integer productId;
    private String productName;
    private String productFl;
    private String orderthId;
    private Integer sl;
    private String ph;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp mfg;
    private Long price;
    private String ge;
    private GysEntity gys;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp gqdate;
    private String kszt;
    private Integer gesl;
    private String shdw;


    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
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
    public String getProductFl() {
        return productFl;
    }

    public void setProductFl(String productFl) {
        this.productFl = productFl;
    }

    @Basic
    @Column(name = "ORDERTH_ID")
    public String getOrderthId() {
        return orderthId;
    }

    public void setOrderthId(String orderthId) {
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
    @Column(name = "GE")
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
    @Column(name = "GQDATE")
    public Timestamp getGqdate() {
        return gqdate;
    }

    public void setGqdate(Timestamp gqdate) {
        this.gqdate = gqdate;
    }

    @Basic
    @Column(name = "KSZT")
    public String getKszt() {
        return kszt;
    }

    public void setKszt(String kszt) {
        this.kszt = kszt;
    }

    @Basic
    @Column(name = "GESL")
    public Integer getGesl() {
        return gesl;
    }

    public void setGesl(Integer gesl) {
        this.gesl = gesl;
    }

    @Basic
    @Column(name = "Shdw")
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
                Objects.equals(ge, that.ge) &&
                Objects.equals(gys, that.gys) &&
                Objects.equals(kszt, that.kszt) &&
                Objects.equals(gesl, that.gesl) &&
                Objects.equals(shdw, that.shdw) &&
                Objects.equals(gqdate, that.gqdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderthxqId, productId, productName, productFl, orderthId, sl, ph, mfg, price, ge,gys,gqdate,kszt,gesl,shdw);
    }

    @Override
    public String toString() {
        return "OrderthxqEntity{" +
                "orderthxqId=" + orderthxqId +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productFl='" + productFl + '\'' +
                ", orderthId='" + orderthId + '\'' +
                ", sl=" + sl +
                ", ph='" + ph + '\'' +
                ", mfg=" + mfg +
                ", price=" + price +
                ", ge='" + ge + '\'' +
                ", gys=" + gys +
                ", gqdate=" + gqdate +
                ", kszt='" + kszt + '\'' +
                ", gesl=" + gesl +
                ", shdw='" + shdw + '\'' +
                '}';
    }
}
