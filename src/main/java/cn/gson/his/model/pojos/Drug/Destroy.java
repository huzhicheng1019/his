package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Destroy {
    private Integer destroyId;
    private Employee employee;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp destroyDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp sqdate;
    private Integer destroyZt;
    private String bz;
    private String shr;

    @Id
    @Column(name = "DESTROY_ID", nullable = false, precision = 0)
    public Integer getDestroyId() {
        return destroyId;
    }

    public void setDestroyId(Integer destroyId) {
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
    @Column(name = "SHR", nullable = true, length = 1024)
    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destroy destroy = (Destroy) o;
        return Objects.equals(destroyId, destroy.destroyId) && Objects.equals(employee, destroy.employee) && Objects.equals(destroyDate, destroy.destroyDate) && Objects.equals(sqdate, destroy.sqdate) && Objects.equals(destroyZt, destroy.destroyZt) && Objects.equals(bz, destroy.bz) && Objects.equals(shr, destroy.shr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destroyId, employee, destroyDate, sqdate, destroyZt, bz, shr);
    }
}
