package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "HIS", catalog = "")
public class EmployeeEntity {
    private int empId;
    private String empName;
    private String empPhone;
    private String empCard;
    private Timestamp empInduction;
    private Timestamp empDeparture;
    private Integer empState;
    private Integer empDept;
    private Integer empDepar;
    private Integer empTit;

    @Id
    @Column(name = "EMP_ID")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "EMP_NAME")
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Basic
    @Column(name = "EMP_PHONE")
    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Basic
    @Column(name = "EMP_CARD")
    public String getEmpCard() {
        return empCard;
    }

    public void setEmpCard(String empCard) {
        this.empCard = empCard;
    }

    @Basic
    @Column(name = "EMP_INDUCTION")
    public Timestamp getEmpInduction() {
        return empInduction;
    }

    public void setEmpInduction(Timestamp empInduction) {
        this.empInduction = empInduction;
    }

    @Basic
    @Column(name = "EMP_DEPARTURE")
    public Timestamp getEmpDeparture() {
        return empDeparture;
    }

    public void setEmpDeparture(Timestamp empDeparture) {
        this.empDeparture = empDeparture;
    }

    @Basic
    @Column(name = "EMP_STATE")
    public Integer getEmpState() {
        return empState;
    }

    public void setEmpState(Integer empState) {
        this.empState = empState;
    }

    @Basic
    @Column(name = "EMP_DEPT")
    public Integer getEmpDept() {
        return empDept;
    }

    public void setEmpDept(Integer empDept) {
        this.empDept = empDept;
    }

    @Basic
    @Column(name = "EMP_DEPAR")
    public Integer getEmpDepar() {
        return empDepar;
    }

    public void setEmpDepar(Integer empDepar) {
        this.empDepar = empDepar;
    }

    @Basic
    @Column(name = "EMP_TIT")
    public Integer getEmpTit() {
        return empTit;
    }

    public void setEmpTit(Integer empTit) {
        this.empTit = empTit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return empId == that.empId &&
                Objects.equals(empName, that.empName) &&
                Objects.equals(empPhone, that.empPhone) &&
                Objects.equals(empCard, that.empCard) &&
                Objects.equals(empInduction, that.empInduction) &&
                Objects.equals(empDeparture, that.empDeparture) &&
                Objects.equals(empState, that.empState) &&
                Objects.equals(empDept, that.empDept) &&
                Objects.equals(empDepar, that.empDepar) &&
                Objects.equals(empTit, that.empTit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empPhone, empCard, empInduction, empDeparture, empState, empDept, empDepar, empTit);
    }
}
