package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USER_INFO", schema = "HIS", catalog = "")
public class UserInfoEntity {
    private int userId;
    private String userAccount;
    private String userPass;
    private Integer userEmp;

    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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
        UserInfoEntity that = (UserInfoEntity) o;
        return userId == that.userId &&
                Objects.equals(userAccount, that.userAccount) &&
                Objects.equals(userPass, that.userPass) &&
                Objects.equals(userEmp, that.userEmp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userAccount, userPass, userEmp);
    }
}
