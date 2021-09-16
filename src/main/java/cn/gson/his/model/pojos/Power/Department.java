/**
 * 科室
 */
package cn.gson.his.model.pojos.Power;

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
    private String depaAddress;//科室地址

    private List<Employee> emps; //员工集合
    private List<ScheEmp> scheEmps; // 排班人员
    private Schedu schedu;//排班日期
    private Title titles;//职称

    @ManyToOne
    public Title getTitles() {
        return titles;
    }

    public void setTitles(Title titles) {
        this.titles = titles;
    }

    @OneToMany
    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }
    @OneToMany
    public List<ScheEmp> getScheEmps() {
        return scheEmps;
    }

    public void setScheEmps(List<ScheEmp> scheEmps) {
        this.scheEmps = scheEmps;
    }
    @ManyToOne
    public Schedu getSchedu() {
        return schedu;
    }

    public void setSchedu(Schedu schedu) {
        this.schedu = schedu;
    }

    @Basic
    @Column(name = "DEPA_ADDRESS")
    public String getDepaAddress() {
        return depaAddress;
    }

    public void setDepaAddress(String depaAddress) {
        this.depaAddress = depaAddress;
    }

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

    public Department(String depaName, Timestamp depaCreate, Dept dept,String depaAddress) {
        this.depaName = depaName;
        this.depaCreate = depaCreate;
        this.dept = dept;
        this.depaAddress=depaAddress;
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
