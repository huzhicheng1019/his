package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "STO", schema = "HIS")
public class StoEntity {
    private int stoId;
    private Timestamp stoDate;
    private LibraryInfoEntity library;
    private Integer why;
    private Employee employee;
    private String lyId;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "STO_ID")
    public int getStoId() {
        return stoId;
    }

    public void setStoId(int stoId) {
        this.stoId = stoId;
    }

    @Basic
    @Column(name = "STO_DATE")
    public Timestamp getStoDate() {
        return stoDate;
    }

    public void setStoDate(Timestamp stoDate) {
        this.stoDate = stoDate;
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

    @ManyToOne
    @JoinColumn(name = "SHR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "LY_ID")
    public String getLyId() {
        return lyId;
    }

    public void setLyId(String lyId) {
        this.lyId = lyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoEntity stoEntity = (StoEntity) o;
        return stoId == stoEntity.stoId &&
                Objects.equals(stoDate, stoEntity.stoDate) &&
                Objects.equals(library, stoEntity.library) &&
                Objects.equals(why, stoEntity.why) &&
                Objects.equals(employee, stoEntity.employee) &&
                Objects.equals(lyId, stoEntity.lyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stoId, stoDate, library, why, employee, lyId);
    }
}
