package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROLE_INFO", schema = "HIS", catalog = "")
public class RoleInfo {
    private Integer roleId;//id
    private String roleName;//角色名
    private Timestamp roleCreate;//创建时间
    private RoleInfo roleinfoByRoleParent;//父级角色
    private List<Dept> depts;//部门
    private List<Perm> perms;//权限
    private List<UserInfo> useres;//用户

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
    public List<Dept> getDepts() {
        return depts;
    }

    public void setDepts(List<Dept> depts) {
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
    public List<Perm> getPerms() {
        return perms;
    }

    public void setPerms(List<Perm> perms) {
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
    public List<UserInfo> getUseres() {
        return useres;
    }

    public void setUseres(List<UserInfo> useres) {
        this.useres = useres;
    }

    public RoleInfo(String roleName, Timestamp roleCreate, RoleInfo roleinfoByRoleParent, List<Dept> depts, List<Perm> perms, List<UserInfo> useres) {
        this.roleName = roleName;
        this.roleCreate = roleCreate;
        this.roleinfoByRoleParent = roleinfoByRoleParent;
        this.depts = depts;
        this.perms = perms;
        this.useres = useres;
    }

    public RoleInfo() {
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
        RoleInfo roleinfo = (RoleInfo) o;
        return Objects.equals(roleId, roleinfo.roleId) && Objects.equals(roleName, roleinfo.roleName) && Objects.equals(roleCreate, roleinfo.roleCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleName, roleCreate);
    }

    @ManyToOne
    @JoinColumn(name = "ROLE_PARENT", referencedColumnName = "ROLE_ID")
    public RoleInfo getRoleinfoByRoleParent() {
        return roleinfoByRoleParent;
    }

    public void setRoleinfoByRoleParent(RoleInfo roleinfoByRoleParent) {
        this.roleinfoByRoleParent = roleinfoByRoleParent;
    }
}
