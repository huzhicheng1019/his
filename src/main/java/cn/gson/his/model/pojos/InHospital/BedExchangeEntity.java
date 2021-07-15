package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "BED_EXCHANGE", schema = "HIS", catalog = "")
public class BedExchangeEntity {
    private int excId;
    private Integer formerBer;
    private Integer nowBed;
    private String regMark;
    private Timestamp excDate;

    @Id
    @Column(name = "EXC_ID")
    public int getExcId() {
        return excId;
    }

    public void setExcId(int excId) {
        this.excId = excId;
    }

    @Basic
    @Column(name = "FORMER_BER")
    public Integer getFormerBer() {
        return formerBer;
    }

    public void setFormerBer(Integer formerBer) {
        this.formerBer = formerBer;
    }

    @Basic
    @Column(name = "NOW_BED")
    public Integer getNowBed() {
        return nowBed;
    }

    public void setNowBed(Integer nowBed) {
        this.nowBed = nowBed;
    }

    @Basic
    @Column(name = "REG_MARK")
    public String getRegMark() {
        return regMark;
    }

    public void setRegMark(String regMark) {
        this.regMark = regMark;
    }

    @Basic
    @Column(name = "EXC_DATE")
    public Timestamp getExcDate() {
        return excDate;
    }

    public void setExcDate(Timestamp excDate) {
        this.excDate = excDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BedExchangeEntity that = (BedExchangeEntity) o;
        return excId == that.excId &&
                Objects.equals(formerBer, that.formerBer) &&
                Objects.equals(nowBed, that.nowBed) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(excDate, that.excDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(excId, formerBer, nowBed, regMark, excDate);
    }
}
