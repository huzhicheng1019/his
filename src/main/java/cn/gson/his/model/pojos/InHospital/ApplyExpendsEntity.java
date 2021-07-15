package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "APPLY_EXPENDS", schema = "HIS", catalog = "")
public class ApplyExpendsEntity {
    private int expsId;
    private Integer conId;
    private String expsName;
    private Integer expsCount;
    private String expsRemark;
    private Integer expId;

    @Id
    @Column(name = "EXPS_ID")
    public int getExpsId() {
        return expsId;
    }

    public void setExpsId(int expsId) {
        this.expsId = expsId;
    }

    @Basic
    @Column(name = "CON_ID")
    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    @Basic
    @Column(name = "EXPS_NAME")
    public String getExpsName() {
        return expsName;
    }

    public void setExpsName(String expsName) {
        this.expsName = expsName;
    }

    @Basic
    @Column(name = "EXPS_COUNT")
    public Integer getExpsCount() {
        return expsCount;
    }

    public void setExpsCount(Integer expsCount) {
        this.expsCount = expsCount;
    }

    @Basic
    @Column(name = "EXPS_REMARK")
    public String getExpsRemark() {
        return expsRemark;
    }

    public void setExpsRemark(String expsRemark) {
        this.expsRemark = expsRemark;
    }

    @Basic
    @Column(name = "EXP_ID")
    public Integer getExpId() {
        return expId;
    }

    public void setExpId(Integer expId) {
        this.expId = expId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplyExpendsEntity that = (ApplyExpendsEntity) o;
        return expsId == that.expsId &&
                Objects.equals(conId, that.conId) &&
                Objects.equals(expsName, that.expsName) &&
                Objects.equals(expsCount, that.expsCount) &&
                Objects.equals(expsRemark, that.expsRemark) &&
                Objects.equals(expId, that.expId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expsId, conId, expsName, expsCount, expsRemark, expId);
    }
}
