package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CON", schema = "HIS", catalog = "")
public class ConEntity {
    private int conId;
    private String conName;
    private String conGe;
    private Integer bzq;
    private Integer gysId;
    private Long conPrice;
    private String dw;
    private Long drugPfprice;
    private String yf;
    private Integer zdkcs;

    @Id
    @Column(name = "CON_ID")
    public int getConId() {
        return conId;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    @Basic
    @Column(name = "CON_NAME")
    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    @Basic
    @Column(name = "CON_GE")
    public String getConGe() {
        return conGe;
    }

    public void setConGe(String conGe) {
        this.conGe = conGe;
    }

    @Basic
    @Column(name = "BZQ")
    public Integer getBzq() {
        return bzq;
    }

    public void setBzq(Integer bzq) {
        this.bzq = bzq;
    }

    @Basic
    @Column(name = "GYS_ID")
    public Integer getGysId() {
        return gysId;
    }

    public void setGysId(Integer gysId) {
        this.gysId = gysId;
    }

    @Basic
    @Column(name = "CON_PRICE")
    public Long getConPrice() {
        return conPrice;
    }

    public void setConPrice(Long conPrice) {
        this.conPrice = conPrice;
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
    @Column(name = "DRUG_PFPRICE")
    public Long getDrugPfprice() {
        return drugPfprice;
    }

    public void setDrugPfprice(Long drugPfprice) {
        this.drugPfprice = drugPfprice;
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
        ConEntity conEntity = (ConEntity) o;
        return conId == conEntity.conId &&
                Objects.equals(conName, conEntity.conName) &&
                Objects.equals(conGe, conEntity.conGe) &&
                Objects.equals(bzq, conEntity.bzq) &&
                Objects.equals(gysId, conEntity.gysId) &&
                Objects.equals(conPrice, conEntity.conPrice) &&
                Objects.equals(dw, conEntity.dw) &&
                Objects.equals(drugPfprice, conEntity.drugPfprice) &&
                Objects.equals(yf, conEntity.yf) &&
                Objects.equals(zdkcs, conEntity.zdkcs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conId, conName, conGe, bzq, gysId, conPrice, dw, drugPfprice, yf, zdkcs);
    }
}
