package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "HANGLOSE", schema = "HIS", catalog = "")
public class HangloseEntity {
    private int hangloseNo;
    private Timestamp hangloseDate;
    private String hangloseCause;
    private Integer cardId;

    @Id
    @Column(name = "HANGLOSE_NO")
    public int getHangloseNo() {
        return hangloseNo;
    }

    public void setHangloseNo(int hangloseNo) {
        this.hangloseNo = hangloseNo;
    }

    @Basic
    @Column(name = "HANGLOSE_DATE")
    public Timestamp getHangloseDate() {
        return hangloseDate;
    }

    public void setHangloseDate(Timestamp hangloseDate) {
        this.hangloseDate = hangloseDate;
    }

    @Basic
    @Column(name = "HANGLOSE_CAUSE")
    public String getHangloseCause() {
        return hangloseCause;
    }

    public void setHangloseCause(String hangloseCause) {
        this.hangloseCause = hangloseCause;
    }

    @Basic
    @Column(name = "CARD_ID")
    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HangloseEntity that = (HangloseEntity) o;
        return hangloseNo == that.hangloseNo &&
                Objects.equals(hangloseDate, that.hangloseDate) &&
                Objects.equals(hangloseCause, that.hangloseCause) &&
                Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hangloseNo, hangloseDate, hangloseCause, cardId);
    }
}
