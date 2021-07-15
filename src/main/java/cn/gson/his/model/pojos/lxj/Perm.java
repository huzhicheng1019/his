/**
 * 权限
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Perm {
    private Integer permId;//id
    private String permName;//权限名
    private String permComp;//组件名
    private String permUrl;//组件路径
    private String permImg;//组件图标
    private Integer permState;//是否可用:0:是1:否
    private Integer permLevel;//权限等级
    private String permMata;//注释
    private List<Perm> permByPermParent;//上级权限
    private List<RoleInfo> roleinfos;//角色

    @Basic
    @Column(name = "PERM_MATA")
    public String getPermMata() {
        return permMata;
    }

    public void setPermMata(String permMata) {
        this.permMata = permMata;
    }

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "PERM_ID")
    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    @Basic
    @Column(name = "PERM_NAME")
    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    @Basic
    @Column(name = "PERM_COMP")
    public String getPermComp() {
        return permComp;
    }

    public void setPermComp(String permComp) {
        this.permComp = permComp;
    }

    @Basic
    @Column(name = "PERM_URL")
    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl;
    }

    @Basic
    @Column(name = "PERM_IMG")
    public String getPermImg() {
        return permImg;
    }

    public void setPermImg(String permImg) {
        this.permImg = permImg;
    }

    @Basic
    @Column(name = "PERM_STATE")
    public Integer getPermState() {
        return permState;
    }

    public void setPermState(Integer permState) {
        this.permState = permState;
    }

    @Basic
    @Column(name = "PERM_LEVEL")
    public Integer getPermLevel() {
        return permLevel;
    }

    public void setPermLevel(Integer permLevel) {
        this.permLevel = permLevel;
    }

    @ManyToMany
    @JoinTable(name = "ROLE_PERM",
            joinColumns = {
                    @JoinColumn(name = "PERM_ID"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID"),
            }
    )
    public List<RoleInfo> getRoleinfos() {
        return roleinfos;
    }

    public void setRoleinfos(List<RoleInfo> roleinfos) {
        this.roleinfos = roleinfos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perm perm = (Perm) o;
        return Objects.equals(permId, perm.permId) && Objects.equals(permName, perm.permName) && Objects.equals(permComp, perm.permComp) && Objects.equals(permUrl, perm.permUrl) && Objects.equals(permImg, perm.permImg) && Objects.equals(permState, perm.permState) && Objects.equals(permLevel, perm.permLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permId, permName, permComp, permUrl, permImg, permState, permLevel);
    }

    @OneToMany
    public List<Perm> getPermByPermParent() {
        return permByPermParent;
    }

    public void setPermByPermParent(List<Perm> permByPermParent) {
        this.permByPermParent = permByPermParent;
    }
}
