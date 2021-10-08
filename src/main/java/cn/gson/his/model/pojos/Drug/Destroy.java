package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Destroy {
    private String destroyId;
    private Employee employee;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp destroyDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp sqdate;
    private Integer destroyZt;
    private String bz;
    private Integer why;
    private Employee shr;

    @Id
    @Column(name = "DESTROY_ID", nullable = false, precision = 0)
    public String getDestroyId() {
        return destroyId;
    }

    public void setDestroyId(String destroyId) {
        this.destroyId = destroyId;
    }

    @ManyToOne
    @JoinColumn(name = "ZXR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }



    @ManyToOne
    @JoinColumn(name = "SHR", referencedColumnName = "EMP_ID")
    public Employee getShr() {
        return shr;
    }

    public void setShr(Employee shr) {
        this.shr = shr;
    }

    @Basic
    @Column(name = "DESTROY_DATE", nullable = true)
    public Timestamp getDestroyDate() {
        return destroyDate;
    }

    public void setDestroyDate(Timestamp destroyDate) {
        this.destroyDate = destroyDate;
    }

    @Basic
    @Column(name = "SQDATE", nullable = true)
    public Timestamp getSqdate() {
        return sqdate;
    }

    public void setSqdate(Timestamp sqdate) {
        this.sqdate = sqdate;
    }

    @Basic
    @Column(name = "DESTROY_ZT", nullable = true, precision = 0)
    public Integer getDestroyZt() {
        return destroyZt;
    }

    public void setDestroyZt(Integer destroyZt) {
        this.destroyZt = destroyZt;
    }

    @Basic
    @Column(name = "BZ", nullable = true, length = 3072)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "WHY")
    public Integer getWhy() {
        return why;
    }

    public void setWhy(Integer why) {
        this.why = why;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destroy destroy = (Destroy) o;
        return Objects.equals(destroyId, destroy.destroyId) && Objects.equals(employee, destroy.employee) && Objects.equals(destroyDate, destroy.destroyDate) && Objects.equals(sqdate, destroy.sqdate) && Objects.equals(destroyZt, destroy.destroyZt) && Objects.equals(bz, destroy.bz) && Objects.equals(why, destroy.why) && Objects.equals(shr, destroy.shr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destroyId, employee, destroyDate, sqdate, destroyZt, bz, why,shr);
    }
}
