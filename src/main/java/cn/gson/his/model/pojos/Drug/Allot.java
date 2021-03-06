package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Allot {
    private String allotId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp allotDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")
    private Timestamp sqdate;
    private Employee employee;
    private LibraryInfoEntity library;//调入仓库
    private Integer zt;
    private Employee shr;

    @Id
    @Column(name = "ALLOT_ID", nullable = false, precision = 0)
    public String getAllotId() {
        return allotId;
    }

    public void setAllotId(String allotId) {
        this.allotId = allotId;
    }

    @Basic
    @Column(name = "ALLOT_DATE", nullable = true)
    public Timestamp getAllotDate() {
        return allotDate;
    }

    public void setAllotDate(Timestamp allotDate) {
        this.allotDate = allotDate;
    }

    @Basic
    @Column(name = "SQDATE", nullable = true)
    public Timestamp getSqdate() {
        return sqdate;
    }

    public void setSqdate(Timestamp sqdate) {
        this.sqdate = sqdate;
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
    @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "LIBRARY_ID")
    public LibraryInfoEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryInfoEntity library) {
        this.library = library;
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
    @Column(name = "ZT")
    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allot allot = (Allot) o;
        return Objects.equals(allotId, allot.allotId) && Objects.equals(allotDate, allot.allotDate) && Objects.equals(sqdate, allot.sqdate) && Objects.equals(zt, allot.zt) && Objects.equals(library, allot.library) && Objects.equals(shr, allot.shr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allotId, allotDate, sqdate, employee, library,zt,shr);
    }
}
