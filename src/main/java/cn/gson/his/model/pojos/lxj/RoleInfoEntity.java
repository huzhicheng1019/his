/**
 * 角色
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROLE_INFO", schema = "HIS")
public class RoleInfoEntity {
    private Integer roleId;//id
    private String roleName;//角色名
    private Timestamp roleCreate;//创建时间
    private RoleInfoEntity roleinfoByRoleParent;//父级角色
    private List<DeptEntity> depts;//部门
    private List<PermEntity> perms;//权限
    private List<UserInfoEntity> useres;//用户

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "ROLE_ID")
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
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

    @ManyToMany
    @JoinTable(name = "ROLE_DEPT",
            joinColumns = {
                    @JoinColumn(name = "ROLE_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "DEPT_ID"),
            }
    )
    public List<DeptEntity> getDepts() {
        return depts;
    }

    public void setDepts(List<DeptEntity> depts) {
        this.depts = depts;
    }

    @ManyToMany
    @JoinTable(name = "ROLE_PERM",
            joinColumns = {
                    @JoinColumn(name = "ROLE_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "PERM_ID"),
            }
    )
    public List<PermEntity> getPerms() {
        return perms;
    }

    public void setPerms(List<PermEntity> perms) {
        this.perms = perms;
    }

    @ManyToMany
    @JoinTable(name = "EMP_ROLE",
            joinColumns = {
                    @JoinColumn(name = "ROLE_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "USER_ID"),
            }
    )
    public List<UserInfoEntity> getUseres() {
        return useres;
    }

    public void setUseres(List<UserInfoEntity> useres) {
        this.useres = useres;
    }

    public RoleInfoEntity(String roleName, Timestamp roleCreate, RoleInfoEntity roleinfoByRoleParent, List<DeptEntity> depts, List<PermEntity> perms, List<UserInfoEntity> useres) {
        this.roleName = roleName;
        this.roleCreate = roleCreate;
        this.roleinfoByRoleParent = roleinfoByRoleParent;
        this.depts = depts;
        this.perms = perms;
        this.useres = useres;
    }

    public RoleInfoEntity() {
    }

    @Override
    public String toString() {
        return "Roleinfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleCreate=" + roleCreate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleInfoEntity roleinfo = (RoleInfoEntity) o;
        return Objects.equals(roleId, roleinfo.roleId) && Objects.equals(roleName, roleinfo.roleName) && Objects.equals(roleCreate, roleinfo.roleCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleCreate);
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_PARENT", referencedColumnName = "ROLE_ID")
    public RoleInfoEntity getRoleinfoByRoleParent() {
        return roleinfoByRoleParent;
    }

    public void setRoleinfoByRoleParent(RoleInfoEntity roleinfoByRoleParent) {
        this.roleinfoByRoleParent = roleinfoByRoleParent;
    }
}
