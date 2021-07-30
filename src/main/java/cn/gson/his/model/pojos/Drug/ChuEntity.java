package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CHU", schema = "HIS")
public class ChuEntity {
    private int chuId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp chuDate;
    private LibraryInfoEntity library;
    private Employee employee;
    private Integer why;
    private String lyId;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "CHU_ID")
    public int getChuId() {
        return chuId;
    }

    public void setChuId(int chuId) {
        this.chuId = chuId;
    }

    @Basic
    @Column(name = "CHU_DATE")
    public Timestamp getChuDate() {
        return chuDate;
    }

    public void setChuDate(Timestamp chuDate) {
        this.chuDate = chuDate;
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
    @Column(name = "WHY")
    public Integer getWhy() {
        return why;
    }

    public void setWhy(Integer why) {
        this.why = why;
    }

    @Basic
    @Column(name = "LY_ID")
    public String getLyId() {
        return lyId;
    }

    public void setLyId(String lyId) {
        this.lyId = lyId;
    }

    @ManyToOne
    @JoinColumn(name = "SHR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChuEntity chuEntity = (ChuEntity) o;
        return chuId == chuEntity.chuId &&
                Objects.equals(chuDate, chuEntity.chuDate) &&
                Objects.equals(library, chuEntity.library) &&
                Objects.equals(why, chuEntity.why) &&
                Objects.equals(employee, chuEntity.employee) &&
                Objects.equals(lyId, chuEntity.lyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chuId, chuDate, library, why, lyId,employee);
    }
}
