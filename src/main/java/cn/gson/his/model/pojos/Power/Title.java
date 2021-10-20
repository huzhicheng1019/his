/**
 * 职称
 */
package cn.gson.his.model.pojos.Power;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Title {
    private Integer titId;//id
    private String titName;//职称
    private Integer titleById;

    @Basic
    @Column(name = "TIT_PARENT")
    public Integer getTitleById() {
        return titleById;
    }

    public void setTitleById(Integer titleById) {
        this.titleById = titleById;
    }

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title = (Title) o;
        return Objects.equals(titId, title.titId) && Objects.equals(titName, title.titName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titId, titName);
    }

}
