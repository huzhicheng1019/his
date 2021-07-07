package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Title {
    private Integer titId;
    private String titName;
    private Integer titDept;

    @Id
    @Column(name = "TIT_ID")
    public Integer getTitId() {
        return titId;
    }

    public void setTitId(Integer titId) {
        this.titId = titId;
    }

    @Basic
    @Column(name = "TIT_NAME")
    public String getTitName() {
        return titName;
    }

    public void setTitName(String titName) {
        this.titName = titName;
    }

    @Basic
    @Column(name = "TIT_DEPT")
    public Integer getTitDept() {
        return titDept;
    }

    public void setTitDept(Integer titDept) {
        this.titDept = titDept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(titId, title.titId) && Objects.equals(titName, title.titName) && Objects.equals(titDept, title.titDept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titId, titName, titDept);
    }
}
