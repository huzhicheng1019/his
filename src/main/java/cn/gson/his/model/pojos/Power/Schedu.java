/**
 * 排班日期
 */
package cn.gson.his.model.pojos.Power;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Schedu {
    private Integer scheId;
    private String scheDate;
    private String scheWeek;
    private List<ScheEmp> scheEmps;

    @OneToMany(mappedBy = "scheduByScheId")
    public List<ScheEmp> getScheEmps() {
        return scheEmps;
    }

    public void setScheEmps(List<ScheEmp> scheEmps) {
        this.scheEmps = scheEmps;
    }

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "SCHE_ID")
    public Integer getScheId() {
        return scheId;
    }

    public void setScheId(Integer scheId) {
        this.scheId = scheId;
    }

    @Basic
    @Column(name = "SCHE_DATE")
    public String getScheDate() {
        return scheDate;
    }

    public void setScheDate(String scheDate) {
        this.scheDate = scheDate;
    }

    @Basic
    @Column(name = "SCHE_WEEK")
    public String getScheWeek() {
        return scheWeek;
    }

    public void setScheWeek(String scheWeek) {
        this.scheWeek = scheWeek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedu schedu = (Schedu) o;
        return Objects.equals(scheId, schedu.scheId) && Objects.equals(scheDate, schedu.scheDate) && Objects.equals(scheWeek, schedu.scheWeek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheId, scheDate, scheWeek);
    }


    public Schedu(Integer scheId, String scheDate, String scheWeek) {
        this.scheId = scheId;
        this.scheDate = scheDate;
        this.scheWeek = scheWeek;
    }

    public Schedu() {
    }
}
