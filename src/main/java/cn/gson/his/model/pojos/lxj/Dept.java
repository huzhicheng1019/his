package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Dept {
    private Integer deptId;
    private String deptName;
    private Timestamp deptCreate;


    @Id
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
