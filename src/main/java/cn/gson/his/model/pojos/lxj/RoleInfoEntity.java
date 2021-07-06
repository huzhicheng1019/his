package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ROLE_INFO", schema = "HIS", catalog = "")
public class RoleInfoEntity {
    private int roleId;
    private String roleName;
    private Timestamp roleCreate;
    private Integer roleParent;

    @Id
    @Column(name = "ROLE_ID")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "ROLE_CREATE")
    public Timestamp getRoleCreate() {
        return roleCreate;
    }

    public void setRoleCreate(Timestamp roleCreate) {
        this.roleCreate = roleCreate;
    }

    @Basic
    @Column(name = "ROLE_PARENT")
    public Integer getRoleParent() {
        return roleParent;
    }

    public void setRoleParent(Integer roleParent) {
        this.roleParent = roleParent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleInfoEntity that = (RoleInfoEntity) o;
        return roleId == that.roleId &&
                Objects.equals(roleName, that.roleName) &&
                Objects.equals(roleCreate, that.roleCreate) &&
                Objects.equals(roleParent, that.roleParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleCreate, roleParent);
    }
}
