package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PLAN_INFO", schema = "HIS")
public class PlanInfoEntity {
    private String planId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp planDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp planCgdate;
    private Employee employee;
    private String zje;
    private String bz;
    private Integer zt;
    private Employee shr;

    @Id
    @Column(name = "PLAN_ID")
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
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

    @ManyToOne
    @JoinColumn(name = "ZDR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    @Basic
    @Column(name = "ZT")
    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    @ManyToOne
    @JoinColumn(name = "SHR", referencedColumnName = "EMP_ID")
    public Employee getShr() {
        return shr;
    }

    public void setShr(Employee shr) {
        this.shr = shr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanInfoEntity that = (PlanInfoEntity) o;
        return planId == that.planId &&
                Objects.equals(planDate, that.planDate) &&
                Objects.equals(planCgdate, that.planCgdate) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(zt, that.zt) &&
                Objects.equals(shr, that.shr) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, planDate, planCgdate, employee, zje, bz,zt,shr);
    }
}
