package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CARDRECORD", schema = "HIS", catalog = "")
public class CardrecordEntity {
    private int recordNo;
    private Integer cardId;
    private Integer recordPrice;
    private Timestamp recordDate;
    private String recordName;
    private String recordWay;
    private Integer collectPrice;

    private CardEntity card;

    //就诊卡  一个就诊卡有多个就诊卡记录
    @ManyToOne
    @JoinColumn(name = "CARD_ID", nullable = false)
    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }

    @Id
    @Column(name = "RECORD_NO")
    public int getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(int recordNo) {
        this.recordNo = recordNo;
    }

    @Basic
    @Column(name = "CARD_ID")
    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "RECORD_PRICE")
    public Integer getRecordPrice() {
        return recordPrice;
    }

    public void setRecordPrice(Integer recordPrice) {
        this.recordPrice = recordPrice;
    }

    @Basic
    @Column(name = "RECORD_DATE")
    public Timestamp getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Timestamp recordDate) {
        this.recordDate = recordDate;
    }

    @Basic
    @Column(name = "RECORD_NAME")
    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    @Basic
    @Column(name = "RECORD_WAY")
    public String getRecordWay() {
        return recordWay;
    }

    public void setRecordWay(String recordWay) {
        this.recordWay = recordWay;
    }

    @Basic
    @Column(name = "COLLECT_PRICE")
    public Integer getCollectPrice() {
        return collectPrice;
    }

    public void setCollectPrice(Integer collectPrice) {
        this.collectPrice = collectPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardrecordEntity that = (CardrecordEntity) o;
        return recordNo == that.recordNo &&
                Objects.equals(cardId, that.cardId) &&
                Objects.equals(recordPrice, that.recordPrice) &&
                Objects.equals(recordDate, that.recordDate) &&
                Objects.equals(recordName, that.recordName) &&
                Objects.equals(recordWay, that.recordWay) &&
                Objects.equals(collectPrice, that.collectPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordNo, cardId, recordPrice, recordDate, recordName, recordWay, collectPrice);
    }
}
