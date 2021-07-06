package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DEPT", schema = "HIS", catalog = "")
public class DeptEntity {
    private int deptId;
    private String deptName;
    private Timestamp deptCreate;

    @Id
    @Column(name = "DEPT_ID")
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
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
        DeptEntity that = (DeptEntity) o;
        return deptId == that.deptId &&
                Objects.equals(deptName, that.deptName) &&
                Objects.equals(deptCreate, that.deptCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptId, deptName, deptCreate);
    }
}
