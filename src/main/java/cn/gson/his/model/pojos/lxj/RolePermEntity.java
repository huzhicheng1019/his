package cn.gson.his.model.pojos.lxj;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ROLE_PERM", schema = "HIS", catalog = "")
public class RolePermEntity {
    private Integer roleId;
    private Integer permId;

    @Basic
    @Column(name = "ROLE_ID")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "PERM_ID")
    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePermEntity that = (RolePermEntity) o;
        return Objects.equals(roleId, that.roleId) &&
                Objects.equals(permId, that.permId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, permId);
    }
}
