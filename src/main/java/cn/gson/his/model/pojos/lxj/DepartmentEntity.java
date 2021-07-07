/**
 * 科室
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENT", schema = "HIS")
public class DepartmentEntity {
    private Integer depaId;//id
    private String depaName;//科室名
    private Timestamp depaCreate;//创建时间
    private DeptEntity dept;//部门
    private List<EmployeeEntity> emp;//员工


    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "DEPA_ID")
    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    @Basic
    @Column(name = "DEPA_NAME")
    public String getDepaName() {
        return depaName;
    }

    public void setDepaName(String depaName) {
        this.depaName = depaName;
    }

    @Basic
    @Column(name = "DEPA_CREATE")
    public Timestamp getDepaCreate() {
        return depaCreate;
    }

    public void setDepaCreate(Timestamp depaCreate) {
        this.depaCreate = depaCreate;
    }

    @ManyToOne
    @JoinColumn(name = "DEPA_DEPT", referencedColumnName = "DEPT_ID")
    public DeptEntity getDept() {
        return dept;
    }

    public void setDept(DeptEntity dept) {
        this.dept = dept;
    }

    @OneToMany(mappedBy = "departmentByEmpDepar")
    public List<EmployeeEntity> getEmp() {
        return emp;
    }

    public void setEmp(List<EmployeeEntity> emp) {
        this.emp = emp;
    }

    public DepartmentEntity(String depaName, Timestamp depaCreate, DeptEntity dept, List<EmployeeEntity> emp) {
        this.depaName = depaName;
        this.depaCreate = depaCreate;
        this.dept = dept;
        this.emp = emp;
    }

    public DepartmentEntity() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "depaId=" + depaId +
                ", depaName='" + depaName + '\'' +
                ", depaCreate=" + depaCreate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(depaId, that.depaId) && Objects.equals(depaName, that.depaName) && Objects.equals(depaCreate, that.depaCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depaId, depaName, depaCreate);
    }
}
