package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRESCRIPTIONS", schema = "HIS", catalog = "")
public class PrescriptionsEntity {
    private int chineseNo;
    private Integer chineseId;
    private Integer cCount;
    private Long cPrice;
    private Integer presNo;
    private Integer wSkin;
    private String wSkinresult;
    private Integer presId;
    private Integer cState;
    private Integer pType;

    @Id
    @Column(name = "CHINESE_NO")
    public int getChineseNo() {
        return chineseNo;
    }

    public void setChineseNo(int chineseNo) {
        this.chineseNo = chineseNo;
    }

    @Basic
    @Column(name = "CHINESE_ID")
    public Integer getChineseId() {
        return chineseId;
    }

    public void setChineseId(Integer chineseId) {
        this.chineseId = chineseId;
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
    @Column(name = "PRES_ID")
    public Integer getPresId() {
        return presId;
    }

    public void setPresId(Integer presId) {
        this.presId = presId;
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
    public Integer getpType() {
        return pType;
    }

    public void setpType(Integer pType) {
        this.pType = pType;
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
