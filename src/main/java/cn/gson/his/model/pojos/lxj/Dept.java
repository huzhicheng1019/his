/**
 * 部门
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Dept {
    private Integer deptId;//id
    private String deptName;//部门名
    private Timestamp deptCreate;//创建时间
    private List<Department> depar;//科室
    private List<RoleInfo> roleDepts;//角色
    private List<Employee> emp;//员工
    private List<Title> titles;//职称

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "DEPT_ID")
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "DEPT_NAME")
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "DEPT_CREATE")
    public Timestamp getDeptCreate() {
        return deptCreate;
    }

    public void setDeptCreate(Timestamp deptCreate) {
        this.deptCreate = deptCreate;
    }

    @Transient
    @OneToMany(mappedBy = "dept")
    public List<Department> getDepar() {
        return depar;
    }

    public void setDepar(List<Department> depar) {
        this.depar = depar;
    }

    @Transient
    @ManyToMany
    @JoinTable(name = "ROLE_DEPT",
            joinColumns = {
                    @JoinColumn(name = "DEPT_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID"),
            }
    )
    public List<RoleInfo> getRoleDepts() {
        return roleDepts;
    }

    public void setRoleDepts(List<RoleInfo> roleDepts) {
        this.roleDepts = roleDepts;
    }

    @Transient
    @OneToMany(mappedBy = "deptByEmpDept")
    public List<Employee> getEmp() {
        return emp;
    }

    public void setEmp(List<Employee> emp) {
        this.emp = emp;
    }
    @Transient
    @OneToMany(mappedBy = "deptByTitDept")
    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public Dept(String deptName, Timestamp deptCreate, List<Department> depar, List<RoleInfo> roleDepts, List<Employee> emp, List<Title> titles) {
        this.deptName = deptName;
        this.deptCreate = deptCreate;
        this.depar = depar;
        this.roleDepts = roleDepts;
        this.emp = emp;
        this.titles = titles;
    }

    public Dept() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dept dept = (Dept) o;
        return Objects.equals(deptId, dept.deptId) && Objects.equals(deptName, dept.deptName) && Objects.equals(deptCreate, dept.deptCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, deptCreate);
    }

}