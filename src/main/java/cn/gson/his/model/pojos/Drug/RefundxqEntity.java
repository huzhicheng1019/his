package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "REFUNDXQ", schema = "HIS", catalog = "")
public class RefundxqEntity {
    private int pillsxqId;
    private Integer productId;
    private String productName;
    private Integer productFl;
    private Integer sl;
    private Long drugPrice;
    private String dw;
    private String yf;
    private String drugGe;
    private String drugSm;
    private String ph;
    private String bz;
    private Integer refundId;

    @Id
    @Column(name = "PILLSXQ_ID")
    public int getPillsxqId() {
        return pillsxqId;
    }

    public void setPillsxqId(int pillsxqId) {
        this.pillsxqId = pillsxqId;
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
    @Column(name = "SL")
    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    @Basic
    @Column(name = "DRUG_PRICE")
    public Long getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Long drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Basic
    @Column(name = "DW")
    public String getDw() {
        return dw;
    }

    public void setDw(String dw) {
        this.dw = dw;
    }

    @Basic
    @Column(name = "YF")
    public String getYf() {
        return yf;
    }

    public void setYf(String yf) {
        this.yf = yf;
    }

    @Basic
    @Column(name = "DRUG_GE")
    public String getDrugGe() {
        return drugGe;
    }

    public void setDrugGe(String drugGe) {
        this.drugGe = drugGe;
    }

    @Basic
    @Column(name = "DRUG_SM")
    public String getDrugSm() {
        return drugSm;
    }

    public void setDrugSm(String drugSm) {
        this.drugSm = drugSm;
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
    @Column(name = "REFUND_ID")
    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefundxqEntity that = (RefundxqEntity) o;
        return pillsxqId == that.pillsxqId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(sl, that.sl) &&
                Objects.equals(drugPrice, that.drugPrice) &&
                Objects.equals(dw, that.dw) &&
                Objects.equals(yf, that.yf) &&
                Objects.equals(drugGe, that.drugGe) &&
                Objects.equals(drugSm, that.drugSm) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(bz, that.bz) &&
                Objects.equals(refundId, that.refundId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pillsxqId, productId, productName, productFl, sl, drugPrice, dw, yf, drugGe, drugSm, ph, bz, refundId);
    }
}
