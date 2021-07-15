package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CARD", schema = "HIS", catalog = "")
public class CardEntity {
    private int cardId;
    private String cardNo;
    private String cardPswd;
    private Long cardPrice;
    private Long cardPrepay;
    private String patientName;
    private Integer patientNo;

    @Override
    public String toString() {
        return "CardEntity{" +
                "cardId=" + cardId +
                ", cardNo='" + cardNo + '\'' +
                ", cardPswd='" + cardPswd + '\'' +
                ", cardPrice=" + cardPrice +
                ", cardPrepay=" + cardPrepay +
                ", patientName='" + patientName + '\'' +
                ", patientNo=" + patientNo +
                ", cardState=" + cardState +
                '}';
    }

    private Integer cardState;
    //一个就诊卡只有一个患者
    private PatientdataEntity pati;
    //一对一关系
    @OneToOne
    @JoinColumn(name = "PATIENT_NO", nullable = false)
    public PatientdataEntity getPati() {
        return pati;
    }

    public void setPati(PatientdataEntity pati) {
        this.pati = pati;
    }

    @Id
    @Column(name = "CARD_ID")
    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "CARD_NO")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "CARD_PSWD")
    public String getCardPswd() {
        return cardPswd;
    }

    public void setCardPswd(String cardPswd) {
        this.cardPswd = cardPswd;
    }

    @Basic
    @Column(name = "CARD_PRICE")
    public Long getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(Long cardPrice) {
        this.cardPrice = cardPrice;
    }

    @Basic
    @Column(name = "CARD_PREPAY")
    public Long getCardPrepay() {
        return cardPrepay;
    }

    public void setCardPrepay(Long cardPrepay) {
        this.cardPrepay = cardPrepay;
    }

    @Basic
    @Column(name = "PATIENT_NAME")
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Basic
    @Column(name = "PATIENT_NO")
    public Integer getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(Integer patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "CARD_STATE")
    public Integer getCardState() {
        return cardState;
    }

    public void setCardState(Integer cardState) {
        this.cardState = cardState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardEntity that = (CardEntity) o;
        return cardId == that.cardId &&
                Objects.equals(cardNo, that.cardNo) &&
                Objects.equals(cardPswd, that.cardPswd) &&
                Objects.equals(cardPrice, that.cardPrice) &&
                Objects.equals(cardPrepay, that.cardPrepay) &&
                Objects.equals(patientName, that.patientName) &&
                Objects.equals(patientNo, that.patientNo) &&
                Objects.equals(cardState, that.cardState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNo, cardPswd, cardPrice, cardPrepay, patientName, patientNo, cardState);
    }
}
