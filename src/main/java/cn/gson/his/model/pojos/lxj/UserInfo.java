package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_INFO", schema = "HIS", catalog = "")
public class UserInfo {
    private Integer userId;
    private String userAccount;
    private String userPass;
    private Integer userEmp;

    @Id
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

    @Basic
    @Column(name = "USER_EMP")
    public Integer getUserEmp() {
        return userEmp;
    }

    public void setUserEmp(Integer userEmp) {
        this.userEmp = userEmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(userId, userInfo.userId) && Objects.equals(userAccount, userInfo.userAccount) && Objects.equals(userPass, userInfo.userPass) && Objects.equals(userEmp, userInfo.userEmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userAccount, userPass, userEmp);
    }
}
