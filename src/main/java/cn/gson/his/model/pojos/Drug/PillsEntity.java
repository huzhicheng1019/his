package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PILLS", schema = "HIS")
public class PillsEntity {
    private String pillsId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp pillsDate;
    private String fylyId;
    private Integer fylyFl;
    private Employee employee;
    private Long zje;
    private LibraryInfoEntity library;
    private Long tqje;
    private Integer fqzt;
    private Integer zt;
    private Long bjje;
    private Long yfje;
    private Long sfje;

    @Id
    @Column(name = "PILLS_ID")
    public String getPillsId() {
        return pillsId;
    }

    public void setPillsId(String pillsId) {
        this.pillsId = pillsId;
    }

    @Basic
    @Column(name = "PILLS_DATE")
    public Timestamp getPillsDate() {
        return pillsDate;
    }

    public void setPillsDate(Timestamp pillsDate) {
        this.pillsDate = pillsDate;
    }

    @Basic
    @Column(name = "FYLY_ID")
    public String getFylyId() {
        return fylyId;
    }

    public void setFylyId(String fylyId) {
        this.fylyId = fylyId;
    }

    @Basic
    @Column(name = "FYLY_FL")
    public Integer getFylyFl() {
        return fylyFl;
    }

    public void setFylyFl(Integer fylyFl) {
        this.fylyFl = fylyFl;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FYR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "ZJE")
    public Long getZje() {
        return zje;
    }

    public void setZje(Long zje) {
        this.zje = zje;
    }


    @Basic
    @Column(name = "TQJE")
    public Long getTqje() {
        return tqje;
    }

    public void setTqje(Long tqje) {
        this.tqje = tqje;
    }

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "LIBRARY_ID")
    public LibraryInfoEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryInfoEntity library) {
        this.library = library;
    }



    @Basic
    @Column(name = "FQZT", nullable = true, precision = 8)
    public Integer getFqzt() {
        return fqzt;
    }

    public void setFqzt(Integer fqzt) {
        this.fqzt = fqzt;
    }

    @Basic
    @Column(name = "ZT", nullable = true, precision = 8)
    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    @Basic
    @Column(name = "BJJE", nullable = true, precision = 8)
    public Long getBjje() {
        return bjje;
    }

    public void setBjje(Long bjje) {
        this.bjje = bjje;
    }

    @Basic
    @Column(name = "YFJE", nullable = true, precision = 8)
    public Long getYfje() {
        return yfje;
    }

    public void setYfje(Long yfje) {
        this.yfje = yfje;
    }

    @Basic
    @Column(name = "SFJE", nullable = true, precision = 8)
    public Long getSfje() {
        return sfje;
    }

    public void setSfje(Long sfje) {
        this.sfje = sfje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PillsEntity that = (PillsEntity) o;
        return pillsId == that.pillsId &&
                Objects.equals(pillsDate, that.pillsDate) &&
                Objects.equals(fylyId, that.fylyId) &&
                Objects.equals(fylyFl, that.fylyFl) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(tqje, that.tqje) &&
                Objects.equals(fqzt, that.fqzt) &&
                Objects.equals(zt, that.zt) &&
                Objects.equals(bjje, that.bjje) &&
                Objects.equals(yfje, that.yfje) &&
                Objects.equals(sfje, that.sfje) &&
                Objects.equals(library, that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pillsId, pillsDate, fylyId, fylyFl, employee, zje, library,tqje,fqzt,zt,bjje,yfje,sfje);
    }
}
