package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DRUG", schema = "HIS", catalog = "")
public class DrugEntity {
    private int drugId;
    private String drugName;
    private String drugGe;
    private GysEntity gys;
    private LbEntity lb;
    private String drugSm;
    private String bzq;
    private Long drugPfprice;
    private Long drugPrice;
    private String dw;
    private String yf;
    private Integer zdkcs;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "DRUG_ID")
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
    }

    @Basic
    @Column(name = "DRUG_NAME")
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
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
    @Column(name = "BZQ")
    public String getBzq() {
        return bzq;
    }

    public void setBzq(String bzq) {
        this.bzq = bzq;
    }

    @Basic
    @Column(name = "DRUG_PFPRICE")
    public Long getDrugPfprice() {
        return drugPfprice;
    }

    public void setDrugPfprice(Long drugPfprice) {
        this.drugPfprice = drugPfprice;
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
    @Column(name = "ZDKCS")
    public Integer getZdkcs() {
        return zdkcs;
    }

    public void setZdkcs(Integer zdkcs) {
        this.zdkcs = zdkcs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrugEntity that = (DrugEntity) o;
        return drugId == that.drugId &&
                Objects.equals(drugName, that.drugName) &&
                Objects.equals(drugGe, that.drugGe) &&
                Objects.equals(gys, that.gys) &&
                Objects.equals(lb, that.lb) &&
                Objects.equals(drugSm, that.drugSm) &&
                Objects.equals(bzq, that.bzq) &&
                Objects.equals(drugPfprice, that.drugPfprice) &&
                Objects.equals(drugPrice, that.drugPrice) &&
                Objects.equals(dw, that.dw) &&
                Objects.equals(yf, that.yf) &&
                Objects.equals(zdkcs, that.zdkcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugId, drugName, drugGe, gys, lb, drugSm, bzq, drugPfprice, drugPrice, dw, yf, zdkcs);
    }

    @ManyToOne
    @JoinColumn(name = "GYS_ID", referencedColumnName = "GYS_ID")
    public GysEntity getGys() {
        return gys;
    }

    public void setGys(GysEntity gys) {
        this.gys = gys;
    }

    @ManyToOne
    @JoinColumn(name = "LB_ID", referencedColumnName = "LB_ID")
    public LbEntity getLb() {
        return lb;
    }

    public void setLb(LbEntity lb) {
        this.lb = lb;
    }

}
