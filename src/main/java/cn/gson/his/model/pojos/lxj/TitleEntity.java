package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TITLE", schema = "HIS", catalog = "")
public class TitleEntity {
    private int titId;
    private String titName;
    private Integer titDept;

    @Id
    @Column(name = "TIT_ID")
    public int getTitId() {
        return titId;
    }

    public void setTitId(int titId) {
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
        TitleEntity that = (TitleEntity) o;
        return titId == that.titId &&
                Objects.equals(titName, that.titName) &&
                Objects.equals(titDept, that.titDept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titId, titName, titDept);
    }
}
