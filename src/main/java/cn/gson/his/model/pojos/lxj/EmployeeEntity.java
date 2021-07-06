/**
 * 员工
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "HIS")
public class EmployeeEntity {
    private Integer empId;//id
    private String empName;//员工名
    private String empPhone;//电话
    private String empCard;//身份证
    private Timestamp empInduction;//入职日期
    private Timestamp empDeparture;//离职日期
    private Integer empState;//状态
    private DeptEntity deptByEmpDept;//部门
    private DepartmentEntity departmentByEmpDepar;//科室
    private TitleEntity titles;//职称
    private List<UserInfoEntity> useres;//用户
    private List<ScheduEntity> schedus;//排班

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "EMP_ID")
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "EMP_NAME")
    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Basic
    @Column(name = "EMP_PHONE")
    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    @Basic
    @Column(name = "EMP_CARD")
    public String getEmpCard() {
        return empCard;
    }

    public void setEmpCard(String empCard) {
        this.empCard = empCard;
    }

    @Basic
    @Column(name = "EMP_INDUCTION")
    public Timestamp getEmpInduction() {
        return empInduction;
    }

    public void setEmpInduction(Timestamp empInduction) {
        this.empInduction = empInduction;
    }

    @Basic
    @Column(name = "EMP_DEPARTURE")
    public Timestamp getEmpDeparture() {
        return empDeparture;
    }

    public void setEmpDeparture(Timestamp empDeparture) {
        this.empDeparture = empDeparture;
    }

    @Basic
    @Column(name = "EMP_STATE")
    public Integer getEmpState() {
        return empState;
    }

    public void setEmpState(Integer empState) {
        this.empState = empState;
    }

    @OneToMany(mappedBy = "employeeByUserEmp")
    public List<UserInfoEntity> getUseres() {
        return useres;
    }

    public void setUseres(List<UserInfoEntity> useres) {
        this.useres = useres;
    }

    @OneToMany(mappedBy = "employeeByEmpId")
    public List<ScheduEntity> getSchedus() {
        return schedus;
    }

    public void setSchedus(List<ScheduEntity> schedus) {
        this.schedus = schedus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity employee = (EmployeeEntity) o;
        return Objects.equals(empId, employee.empId) && Objects.equals(empName, employee.empName) && Objects.equals(empPhone, employee.empPhone) && Objects.equals(empCard, employee.empCard) && Objects.equals(empInduction, employee.empInduction) && Objects.equals(empDeparture, employee.empDeparture) && Objects.equals(empState, employee.empState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, empPhone, empCard, empInduction, empDeparture, empState);
    }

    @ManyToOne
    @JoinColumn(name = "EMP_DEPT", referencedColumnName = "DEPT_ID")
    public DeptEntity getDeptByEmpDept() {
        return deptByEmpDept;
    }

    public void setDeptByEmpDept(DeptEntity deptByEmpDept) {
        this.deptByEmpDept = deptByEmpDept;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_DEPAR", referencedColumnName = "DEPA_ID")
    public DepartmentEntity getDepartmentByEmpDepar() {
        return departmentByEmpDepar;
    }

    public void setDepartmentByEmpDepar(DepartmentEntity departmentByEmpDepar) {
        this.departmentByEmpDepar = departmentByEmpDepar;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_TIT", referencedColumnName = "TIT_ID")
    public TitleEntity getTitles() {
        return titles;
    }

    public void setTitles(TitleEntity titles) {
        this.titles = titles;
    }

    public EmployeeEntity(String empName, String empPhone, String empCard, Timestamp empInduction, Timestamp empDeparture, Integer empState, DeptEntity deptByEmpDept, DepartmentEntity departmentByEmpDepar, TitleEntity titles, List<UserInfoEntity> useres, List<ScheduEntity> schedus) {
        this.empName = empName;
        this.empPhone = empPhone;
        this.empCard = empCard;
        this.empInduction = empInduction;
        this.empDeparture = empDeparture;
        this.empState = empState;
        this.deptByEmpDept = deptByEmpDept;
        this.departmentByEmpDepar = departmentByEmpDepar;
        this.titles = titles;
        this.useres = useres;
        this.schedus = schedus;
    }

    public EmployeeEntity() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empCard='" + empCard + '\'' +
                ", empInduction=" + empInduction +
                ", empDeparture=" + empDeparture +
                ", empState=" + empState +
                '}';
    }
}
