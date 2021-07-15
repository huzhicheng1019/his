package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "HANGTYPE", schema = "HIS", catalog = "")
public class HangtypeEntity {
    private int hangtypeNo;
    private String hangtypeName;
    private Long newPrice;
    private Long oldPrice;

    @Id
    @Column(name = "HANGTYPE_NO")
    public int getHangtypeNo() {
        return hangtypeNo;
    }

    public void setHangtypeNo(int hangtypeNo) {
        this.hangtypeNo = hangtypeNo;
    }

    @Basic
    @Column(name = "HANGTYPE_NAME")
    public String getHangtypeName() {
        return hangtypeName;
    }

    public void setHangtypeName(String hangtypeName) {
        this.hangtypeName = hangtypeName;
    }

    @Basic
    @Column(name = "NEW_PRICE")
    public Long getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Long newPrice) {
        this.newPrice = newPrice;
    }

    @Basic
    @Column(name = "OLD_PRICE")
    public Long getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Long oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HangtypeEntity that = (HangtypeEntity) o;
        return hangtypeNo == that.hangtypeNo &&
                Objects.equals(hangtypeName, that.hangtypeName) &&
                Objects.equals(newPrice, that.newPrice) &&
                Objects.equals(oldPrice, that.oldPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hangtypeNo, hangtypeName, newPrice, oldPrice);
    }
}
