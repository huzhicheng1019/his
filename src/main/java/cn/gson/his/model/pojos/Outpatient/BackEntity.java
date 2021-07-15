package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "BACK", schema = "HIS", catalog = "")
public class BackEntity {
    private int backno;
    private Integer hangId;
    private Timestamp backDate;
    private String backWhy;
    private Long backPrice;

    @Id
    @Column(name = "BACKNO")
    public int getBackno() {
        return backno;
    }

    public void setBackno(int backno) {
        this.backno = backno;
    }

    @Basic
    @Column(name = "HANG_ID")
    public Integer getHangId() {
        return hangId;
    }

    public void setHangId(Integer hangId) {
        this.hangId = hangId;
    }

    @Basic
    @Column(name = "BACK_DATE")
    public Timestamp getBackDate() {
        return backDate;
    }

    public void setBackDate(Timestamp backDate) {
        this.backDate = backDate;
    }

    @Basic
    @Column(name = "BACK_WHY")
    public String getBackWhy() {
        return backWhy;
    }

    public void setBackWhy(String backWhy) {
        this.backWhy = backWhy;
    }

    @Basic
    @Column(name = "BACK_PRICE")
    public Long getBackPrice() {
        return backPrice;
    }

    public void setBackPrice(Long backPrice) {
        this.backPrice = backPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BackEntity that = (BackEntity) o;
        return backno == that.backno &&
                Objects.equals(hangId, that.hangId) &&
                Objects.equals(backDate, that.backDate) &&
                Objects.equals(backWhy, that.backWhy) &&
                Objects.equals(backPrice, that.backPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(backno, hangId, backDate, backWhy, backPrice);
    }
}
