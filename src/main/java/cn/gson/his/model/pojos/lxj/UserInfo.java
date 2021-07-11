package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USER_INFO", schema = "HIS", catalog = "")
public class UserInfo {
    private Integer userId;//id
    private String userAccount;//账号
    private String userPass;//密码
    private Employee employeeByUserEmp;//员工
    private List<RoleInfo> roleinfos;//角色

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "USER_ID")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "USER_ACCOUNT")
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @Basic
    @Column(name = "USER_PASS")
    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo usere = (UserInfo) o;
        return Objects.equals(userId, usere.userId) && Objects.equals(userAccount, usere.userAccount) && Objects.equals(userPass, usere.userPass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userAccount, userPass);
    }

    @ManyToOne
    @JoinColumn(name = "USER_EMP", referencedColumnName = "EMP_ID")
    public Employee getEmployeeByUserEmp() {
        return employeeByUserEmp;
    }

    public void setEmployeeByUserEmp(Employee employeeByUserEmp) {
        this.employeeByUserEmp = employeeByUserEmp;
    }

    @ManyToMany
    @JoinTable(name = "EMP_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID"),
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

    public UserInfo(String userAccount, String userPass, Employee employeeByUserEmp, List<RoleInfo> roleinfos) {
        this.userAccount = userAccount;
        this.userPass = userPass;
        this.employeeByUserEmp = employeeByUserEmp;
        this.roleinfos = roleinfos;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "Usere{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPass='" + userPass + '\'' +
                '}';
    }
}
