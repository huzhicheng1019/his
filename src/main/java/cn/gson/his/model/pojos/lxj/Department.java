/**
 * 科室
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Department {
    private Integer depaId;//id
    private String depaName;//科室名
    private Timestamp depaCreate;//创建时间
    private Dept dept;//部门

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "DEPA_ID")
    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    @Basic
    @Column(name = "DEPA_NAME")
    public String getDepaName() {
        return depaName;
    }

    public void setDepaName(String depaName) {
        this.depaName = depaName;
    }

    @Basic
    @Column(name = "DEPA_CREATE")
    public Timestamp getDepaCreate() {
        return depaCreate;
    }

    public void setDepaCreate(Timestamp depaCreate) {
        this.depaCreate = depaCreate;
    }

    @ManyToOne
    @JoinColumn(name = "DEPA_DEPT", referencedColumnName = "DEPT_ID")
    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Department(String depaName, Timestamp depaCreate, Dept dept) {
        this.depaName = depaName;
        this.depaCreate = depaCreate;
        this.dept = dept;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "depaId=" + depaId +
                ", depaName='" + depaName + '\'' +
                ", depaCreate=" + depaCreate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(depaId, that.depaId) && Objects.equals(depaName, that.depaName) && Objects.equals(depaCreate, that.depaCreate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depaId, depaName, depaCreate);
    }
}
