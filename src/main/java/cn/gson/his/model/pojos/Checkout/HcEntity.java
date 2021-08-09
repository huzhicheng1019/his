package cn.gson.his.model.pojos.Checkout;

import cn.gson.his.model.pojos.Drug.GysEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CON", schema = "HIS")
public class HcEntity {
    private int conId;
    private String conName;
    private String conGe;
    private String bzq;
    private GysEntity gys;
    private Long conPrice;
    private String dw;
    private Long drugPfprice;
    private String yf;
    private Integer zdkcs;
    private String conSm;
    private String kszt;
    private Integer gesl;
    private String shdw;
    private List<SurgeryConsumablesEntity> shuqianhc;

    @OneToMany(mappedBy = "con")
    public List<SurgeryConsumablesEntity> getShuqianhc() {
        return shuqianhc;
    }

    public void setShuqianhc(List<SurgeryConsumablesEntity> shuqianhc) {
        this.shuqianhc = shuqianhc;
    }

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
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
    public String getBzq() {
        return bzq;
    }

    public void setBzq(String bzq) {
        this.bzq = bzq;
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

    @Basic
    @Column(name = "CON_SM")
    public String getConSm() {
        return conSm;
    }

    public void setConSm(String conSm) {
        this.conSm = conSm;
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
        HcEntity conEntity = (HcEntity) o;
        return conId == conEntity.conId &&
                Objects.equals(conName, conEntity.conName) &&
                Objects.equals(conGe, conEntity.conGe) &&
                Objects.equals(bzq, conEntity.bzq) &&
                Objects.equals(gys, conEntity.gys) &&
                Objects.equals(conPrice, conEntity.conPrice) &&
                Objects.equals(dw, conEntity.dw) &&
                Objects.equals(drugPfprice, conEntity.drugPfprice) &&
                Objects.equals(yf, conEntity.yf) &&
                Objects.equals(zdkcs, conEntity.zdkcs)&&
                Objects.equals(kszt, conEntity.kszt) &&
                Objects.equals(gesl, conEntity.gesl) &&
                Objects.equals(shdw, conEntity.shdw) &&
                Objects.equals(conSm, conEntity.conSm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conId, conName, conGe, bzq, gys, conPrice, dw, drugPfprice, yf, zdkcs,conSm,kszt,gesl,shdw);
    }
}
