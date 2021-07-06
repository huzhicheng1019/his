package cn.gson.his.model.pojos.lxj;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ROLE_DEPT", schema = "HIS", catalog = "")
public class RoleDeptEntity {
    private Integer roleId;
    private Integer deptId;

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
        RoleDeptEntity that = (RoleDeptEntity) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(deptId, that.deptId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, deptId);
    }
}
