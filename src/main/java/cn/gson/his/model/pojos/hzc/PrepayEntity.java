package cn.gson.his.model.pojos.hzc;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PREPAY", schema = "HIS", catalog = "")
public class PrepayEntity {
    private int preId;
    private String regMark;
    private Long preBalance;
    private Long preArrearage;

    @Id
    @Column(name = "PRE_ID")
    public int getPreId() {
        return preId;
    }

    public void setPreId(int preId) {
        this.preId = preId;
    }

    @Basic
    @Column(name = "REG_MARK")
    public String getRegMark() {
        return regMark;
    }

    public void setRegMark(String regMark) {
        this.regMark = regMark;
    }

    @Basic
    @Column(name = "PRE_BALANCE")
    public Long getPreBalance() {
        return preBalance;
    }

    public void setPreBalance(Long preBalance) {
        this.preBalance = preBalance;
    }

    @Basic
    @Column(name = "PRE_ARREARAGE")
    public Long getPreArrearage() {
        return preArrearage;
    }

    public void setPreArrearage(Long preArrearage) {
        this.preArrearage = preArrearage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrepayEntity that = (PrepayEntity) o;
        return preId == that.preId &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(preBalance, that.preBalance) &&
                Objects.equals(preArrearage, that.preArrearage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preId, regMark, preBalance, preArrearage);
    }
}
