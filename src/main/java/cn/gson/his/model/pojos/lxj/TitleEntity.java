/**
 * 职称
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TITLE", schema = "HIS")
public class TitleEntity {
    private Integer titId;//id
    private String titName;//职称
    private DeptEntity deptByTitDept;//部门
    private List<EmployeeEntity> emp;//员工

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "TIT_ID")
    public Integer getTitId() {
        return titId;
    }

    public void setTitId(Integer titId) {
        this.titId = titId;
    }

    @Basic
    @Column(name = "TIT_NAME")
    public String getTitName() {
        return titName;
    }

    public void setTitName(String titName) {
        this.titName = titName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleEntity title = (TitleEntity) o;
        return Objects.equals(titId, title.titId) && Objects.equals(titName, title.titName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titId, titName);
    }

    @ManyToOne
    @JoinColumn(name = "TIT_DEPT", referencedColumnName = "DEPT_ID")
    public DeptEntity getDeptByTitDept() {
        return deptByTitDept;
    }

    public void setDeptByTitDept(DeptEntity deptByTitDept) {
        this.deptByTitDept = deptByTitDept;
    }
    @OneToMany(mappedBy = "titles")
    public List<EmployeeEntity> getEmp() {
        return emp;
    }

    public void setEmp(List<EmployeeEntity> emp) {
        this.emp = emp;
    }
}
