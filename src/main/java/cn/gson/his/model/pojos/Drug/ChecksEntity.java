package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CHECKS", schema = "HIS")
public class ChecksEntity {
    private String checkId;
    private Timestamp checkDate;
    private LibraryInfoEntity library;
    private Employee employee;
    private String bz;
    private Integer pdlx;
    private Integer zt;

    @Id
    @Column(name = "CHECK_ID")
    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "CHECK_DATE")
    public Timestamp getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Timestamp checkDate) {
        this.checkDate = checkDate;
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
    @JoinColumn(name = "FZR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
    @Column(name = "PDLX")
    public Integer getPdlx() {
        return pdlx;
    }

    public void setPdlx(Integer pdlx) {
        this.pdlx = pdlx;
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
        ChecksEntity that = (ChecksEntity) o;
        return checkId == that.checkId &&
                Objects.equals(checkDate, that.checkDate) &&
                Objects.equals(library, that.library) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(pdlx, that.pdlx) &&
                Objects.equals(zt, that.zt) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkId, checkDate, library, employee, bz,zt,pdlx);
    }
}
