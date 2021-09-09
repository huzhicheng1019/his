/**
 * 排班人员组
 */
package cn.gson.his.model.pojos.Power;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SCHE_EMP", schema = "HIS")
public class ScheEmp {
    private Integer sempId;
    private Employee emp;
    private Shift shift;
    private Schedu scheduByScheId;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "SEMP_ID")
    public Integer getSempId() {
        return sempId;
    }

    public void setSempId(Integer sempId) {
        this.sempId = sempId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheEmp scheEmp = (ScheEmp) o;
        return Objects.equals(sempId, scheEmp.sempId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sempId);
    }

    @ManyToOne
    @JoinColumn(name = "SCHE_ID", referencedColumnName = "SCHE_ID")
    public Schedu getScheduByScheId() {
        return scheduByScheId;
    }

    public void setScheduByScheId(Schedu scheduByScheId) {
        this.scheduByScheId = scheduByScheId;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_ID", referencedColumnName = "EMP_ID")
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    @ManyToOne
    @JoinColumn(name = "SHI_ID", referencedColumnName = "SHI_ID")
    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}
