package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "BEDS", schema = "HIS", catalog = "")
public class BedsEntity {
    private int bedsId;
    private Integer bedId;
    private String regMark;
    private String bedsName;
    private Integer nurseId;
    private String nurseName;
    private Timestamp bedsStart;
    private Timestamp bedsEnd;
    private Integer bedsIs;

    @Id
    @Column(name = "BEDS_ID")
    public int getBedsId() {
        return bedsId;
    }

    public void setBedsId(int bedsId) {
        this.bedsId = bedsId;
    }

    @Basic
    @Column(name = "BED_ID")
    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
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
    @Column(name = "BEDS_NAME")
    public String getBedsName() {
        return bedsName;
    }

    public void setBedsName(String bedsName) {
        this.bedsName = bedsName;
    }

    @Basic
    @Column(name = "NURSE_ID")
    public Integer getNurseId() {
        return nurseId;
    }

    public void setNurseId(Integer nurseId) {
        this.nurseId = nurseId;
    }

    @Basic
    @Column(name = "NURSE_NAME")
    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    @Basic
    @Column(name = "BEDS_START")
    public Timestamp getBedsStart() {
        return bedsStart;
    }

    public void setBedsStart(Timestamp bedsStart) {
        this.bedsStart = bedsStart;
    }

    @Basic
    @Column(name = "BEDS_END")
    public Timestamp getBedsEnd() {
        return bedsEnd;
    }

    public void setBedsEnd(Timestamp bedsEnd) {
        this.bedsEnd = bedsEnd;
    }

    @Basic
    @Column(name = "BEDS_IS")
    public Integer getBedsIs() {
        return bedsIs;
    }

    public void setBedsIs(Integer bedsIs) {
        this.bedsIs = bedsIs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BedsEntity that = (BedsEntity) o;
        return bedsId == that.bedsId &&
                Objects.equals(bedId, that.bedId) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(bedsName, that.bedsName) &&
                Objects.equals(nurseId, that.nurseId) &&
                Objects.equals(nurseName, that.nurseName) &&
                Objects.equals(bedsStart, that.bedsStart) &&
                Objects.equals(bedsEnd, that.bedsEnd) &&
                Objects.equals(bedsIs, that.bedsIs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedsId, bedId, regMark, bedsName, nurseId, nurseName, bedsStart, bedsEnd, bedsIs);
    }
}
