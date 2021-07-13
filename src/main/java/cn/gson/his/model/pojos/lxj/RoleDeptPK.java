package cn.gson.his.model.pojos.lxj;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoleDeptPK implements Serializable {
    private Integer roleId;
    private Integer deptId;

    public RoleDeptPK(Integer roleId, Integer deptId) {
        this.roleId = roleId;
        this.deptId = deptId;
    }

    public RoleDeptPK() {
    }

    @Column(name = "ROLE_ID")
    @Id
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Column(name = "DEPT_ID")
    @Id
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
        RoleDeptPK that = (RoleDeptPK) o;
        return Objects.equals(roleId, that.roleId) && Objects.equals(deptId, that.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, deptId);
    }
}
