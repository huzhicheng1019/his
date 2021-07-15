package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PREPAY_DETAILS", schema = "HIS", catalog = "")
public class PrepayDetailsEntity {
    private int presId;
    private Timestamp presDate;
    private Long presPrice;
    private Integer itemId;
    private Integer presType;
    private Integer preId;

    @Id
    @Column(name = "PRES_ID")
    public int getPresId() {
        return presId;
    }

    public void setPresId(int presId) {
        this.presId = presId;
    }

    @Basic
    @Column(name = "PRES_DATE")
    public Timestamp getPresDate() {
        return presDate;
    }

    public void setPresDate(Timestamp presDate) {
        this.presDate = presDate;
    }

    @Basic
    @Column(name = "PRES_PRICE")
    public Long getPresPrice() {
        return presPrice;
    }

    public void setPresPrice(Long presPrice) {
        this.presPrice = presPrice;
    }

    @Basic
    @Column(name = "ITEM_ID")
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "PRES_TYPE")
    public Integer getPresType() {
        return presType;
    }

    public void setPresType(Integer presType) {
        this.presType = presType;
    }

    @Basic
    @Column(name = "PRE_ID")
    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrepayDetailsEntity that = (PrepayDetailsEntity) o;
        return presId == that.presId &&
                Objects.equals(presDate, that.presDate) &&
                Objects.equals(presPrice, that.presPrice) &&
                Objects.equals(itemId, that.itemId) &&
                Objects.equals(presType, that.presType) &&
                Objects.equals(preId, that.preId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(presId, presDate, presPrice, itemId, presType, preId);
    }
}
