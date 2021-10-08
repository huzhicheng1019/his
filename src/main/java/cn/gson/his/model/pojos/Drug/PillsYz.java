package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PILLS", schema = "HIS")
public class PillsYz {
    private String pillsId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp pillsDate;
    private Department fylyId;
    private Integer fylyFl;
    private Employee employee;
    private LibraryInfoEntity library;

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

    @ManyToOne
    @JoinColumn(name = "FYLY_ID", referencedColumnName = "DEPA_ID")
    public Department getFylyId() {
        return fylyId;
    }

    public void setFylyId(Department fylyId) {
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

    @ManyToOne
    @JoinColumn(name = "FYR", referencedColumnName = "EMP_ID")
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PillsYz that = (PillsYz) o;
        return pillsId == that.pillsId &&
                Objects.equals(pillsDate, that.pillsDate) &&
                Objects.equals(fylyId, that.fylyId) &&
                Objects.equals(fylyFl, that.fylyFl) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(library, that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pillsId, pillsDate, fylyId, fylyFl, employee, library);
    }
}
