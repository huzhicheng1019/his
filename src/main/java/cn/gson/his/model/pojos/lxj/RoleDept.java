package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROLE_DEPT", schema = "HIS", catalog = "")
public class RoleDept {
    private Long id;
    private Integer roleId;
    private Integer deptId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ROLE_ID")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "DEPT_ID")
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDept roleDept = (RoleDept) o;
        return Objects.equals(roleId, roleDept.roleId) && Objects.equals(deptId, roleDept.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, deptId);
    }
}
