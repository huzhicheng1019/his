package cn.gson.his.model.pojos.Drug;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "STOJL", schema = "HIS")
public class StojlEntity {
    private int stojlId;
    private StoEntity sto;
    private String productName;
    private Integer productId;
    private String productFl;
    private Integer sl;
    private String ph;
    private String bz;
    private String ge;
    private GysEntity gys;
    private Long price;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp scdate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp gqdate;


    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "STOJL_ID")
    public int getStojlId() {
        return stojlId;
    }

    public void setStojlId(int stojlId) {
        this.stojlId = stojlId;
    }

    @ManyToOne
    @JoinColumn(name = "STO_ID", referencedColumnName = "STO_ID")
    public StoEntity getSto() {
        return sto;
    }

    public void setSto(StoEntity sto) {
        this.sto = sto;
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
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
    @Column(name = "SCDATE")
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
    @Column(name = "GE")
    public String getGe() {
        return ge;
    }

    public void setGe(String ge) {
        this.ge = ge;
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
    @Column(name = "PRICE")
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
        StojlEntity that = (StojlEntity) o;
        return stojlId == that.stojlId &&
                Objects.equals(sto, that.sto) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(ge, that.ge) &&
                Objects.equals(gys, that.gys) &&
                Objects.equals(scdate, that.scdate) &&
                Objects.equals(gqdate, that.gqdate) &&
                Objects.equals(price, that.price) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stojlId, sto, productName, productId, productFl, sl, ph, bz,ge,gys,scdate,gqdate,price);
    }
}
