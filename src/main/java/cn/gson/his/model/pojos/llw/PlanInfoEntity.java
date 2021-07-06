package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PLAN_INFO", schema = "HIS", catalog = "")
public class PlanInfoEntity {
    private int planId;
    private Timestamp planDate;
    private Timestamp planCgdate;
    private Integer zdr;
    private String zje;
    private String bz;

    @Id
    @Column(name = "PLAN_ID")
    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "PLAN_DATE")
    public Timestamp getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Timestamp planDate) {
        this.planDate = planDate;
    }

    @Basic
    @Column(name = "PLAN_CGDATE")
    public Timestamp getPlanCgdate() {
        return planCgdate;
    }

    public void setPlanCgdate(Timestamp planCgdate) {
        this.planCgdate = planCgdate;
    }

    @Basic
    @Column(name = "ZDR")
    public Integer getZdr() {
        return zdr;
    }

    public void setZdr(Integer zdr) {
        this.zdr = zdr;
    }

    @Basic
    @Column(name = "ZJE")
    public String getZje() {
        return zje;
    }

    public void setZje(String zje) {
        this.zje = zje;
    }

    @Basic
    @Column(name = "BZ")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanInfoEntity that = (PlanInfoEntity) o;
        return planId == that.planId &&
                Objects.equals(planDate, that.planDate) &&
                Objects.equals(planCgdate, that.planCgdate) &&
                Objects.equals(zdr, that.zdr) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, planDate, planCgdate, zdr, zje, bz);
    }
}
