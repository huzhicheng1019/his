package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROLE_PERM", schema = "HIS", catalog = "")
public class RolePerm {
    private Long id;
    private Integer roleId;
    private Integer permId;

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
        RolePerm rolePerm = (RolePerm) o;
        return Objects.equals(roleId, rolePerm.roleId) && Objects.equals(permId, rolePerm.permId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, permId);
    }
}
