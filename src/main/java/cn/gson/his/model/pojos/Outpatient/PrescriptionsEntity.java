package cn.gson.his.model.pojos.Outpatient;

import cn.gson.his.model.pojos.Drug.DrugEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRESCRIPTIONS", schema = "HIS", catalog = "")
public class PrescriptionsEntity {
    private int chineseNo;//处方详情单号
    private Integer cCount;//数量
    private Long cPrice;//这个处方的总价
    private Integer presNo;//药品原来的价格
    private Integer wSkin;//是否皮试
    private String wSkinresult;//皮试结果
    private Integer cState;//收费状态
    private String pType;//类别
    private Integer chineseId;//药品(耗材)编号
    private String  ChineseName;//药品规格
    private String  ChineseGG;//药品规格
    private String  ChineseDW;//药品单位
    private String  ChineseYF;//药品用法

    private PrescriptionEntity presId;//处方编号
    @Id
    @Column(name = "CHINESE_ID")
    public Integer getChineseId() {
        return chineseId;
    }

    public void setChineseId(Integer chineseId) {
        this.chineseId = chineseId;
    }

    @OneToOne
    @Column(name = "PRES_ID",nullable = false)
    public PrescriptionEntity getPresId() {
        return presId;
    }

    public void setPresId(PrescriptionEntity presId) {
        this.presId = presId;
    }

    @Id
    @Column(name = "CHINESE_NO")
    public int getChineseNo() {
        return chineseNo;
    }

    public void setChineseNo(int chineseNo) {
        this.chineseNo = chineseNo;
    }


    @Basic
    @Column(name = "C_COUNT")
    public Integer getcCount() {
        return cCount;
    }

    public void setcCount(Integer cCount) {
        this.cCount = cCount;
    }

    @Basic
    @Column(name = "C_PRICE")
    public Long getcPrice() {
        return cPrice;
    }

    public void setcPrice(Long cPrice) {
        this.cPrice = cPrice;
    }

    @Basic
    @Column(name = "PRES_NO")
    public Integer getPresNo() {
        return presNo;
    }

    public void setPresNo(Integer presNo) {
        this.presNo = presNo;
    }

    @Basic
    @Column(name = "W_SKIN")
    public Integer getwSkin() {
        return wSkin;
    }

    public void setwSkin(Integer wSkin) {
        this.wSkin = wSkin;
    }

    @Basic
    @Column(name = "W_SKINRESULT")
    public String getwSkinresult() {
        return wSkinresult;
    }

    public void setwSkinresult(String wSkinresult) {
        this.wSkinresult = wSkinresult;
    }


    @Basic
    @Column(name = "C_STATE")
    public Integer getcState() {
        return cState;
    }

    public void setcState(Integer cState) {
        this.cState = cState;
    }

    @Basic
    @Column(name = "P_TYPE")
    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }
    @Basic
    @Column(name = "CHINESE_NAME")
    public String getChineseName() {
        return ChineseName;
    }

    public void setChineseName(String chineseName) {
        ChineseName = chineseName;
    }
    @Basic
    @Column(name = "CHINESE_GG")
    public String getChineseGG() {
        return ChineseGG;
    }

    public void setChineseGG(String chineseGG) {
        ChineseGG = chineseGG;
    }
    @Basic
    @Column(name = "CHINESE_DW")
    public String getChineseDW() {
        return ChineseDW;
    }

    public void setChineseDW(String chineseDW) {
        ChineseDW = chineseDW;
    }
    @Basic
    @Column(name = "CHINESE_YF")
    public String getChineseYF() {
        return ChineseYF;
    }

    public void setChineseYF(String chineseYF) {
        ChineseYF = chineseYF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionsEntity that = (PrescriptionsEntity) o;
        return chineseNo == that.chineseNo &&
                Objects.equals(chineseId, that.chineseId) &&
                Objects.equals(cCount, that.cCount) &&
                Objects.equals(cPrice, that.cPrice) &&
                Objects.equals(presNo, that.presNo) &&
                Objects.equals(wSkin, that.wSkin) &&
                Objects.equals(wSkinresult, that.wSkinresult) &&
                Objects.equals(presId, that.presId) &&
                Objects.equals(cState, that.cState) &&
                Objects.equals(pType, that.pType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chineseNo, chineseId, cCount, cPrice, presNo, wSkin, wSkinresult, presId, cState, pType);
    }
}
