package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Perm {
    private Integer permId;
    private String permName;
    private String permComp;
    private String permUrl;
    private String permImg;
    private Integer permParent;
    private Integer permState;
    private Integer permLevel;


    @Id
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
    @Column(name = "PERM_PARENT")
    public Integer getPermParent() {
        return permParent;
    }

    public void setPermParent(Integer permParent) {
        this.permParent = permParent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perm perm = (Perm) o;
        return Objects.equals(permId, perm.permId) && Objects.equals(permName, perm.permName) && Objects.equals(permComp, perm.permComp) && Objects.equals(permUrl, perm.permUrl) && Objects.equals(permImg, perm.permImg) && Objects.equals(permParent, perm.permParent) && Objects.equals(permState, perm.permState) && Objects.equals(permLevel, perm.permLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permId, permName, permComp, permUrl, permImg, permParent, permState, permLevel);
    }
}
