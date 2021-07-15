package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PAY", schema = "HIS", catalog = "")
public class PayEntity {
    private int payNo;
    private Integer recordNo;
    private Timestamp payDate;
    private String payName;
    private Integer payProtect;
    private String payType;
    private Long payPrice;
    private Long payTotal;

    @Id
    @Column(name = "PAY_NO")
    public int getPayNo() {
        return payNo;
    }

    public void setPayNo(int payNo) {
        this.payNo = payNo;
    }

    @Basic
    @Column(name = "RECORD_NO")
    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    @Basic
    @Column(name = "PAY_DATE")
    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    @Basic
    @Column(name = "PAY_NAME")
    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    @Basic
    @Column(name = "PAY_PROTECT")
    public Integer getPayProtect() {
        return payProtect;
    }

    public void setPayProtect(Integer payProtect) {
        this.payProtect = payProtect;
    }

    @Basic
    @Column(name = "PAY_TYPE")
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "PAY_PRICE")
    public Long getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Long payPrice) {
        this.payPrice = payPrice;
    }

    @Basic
    @Column(name = "PAY_TOTAL")
    public Long getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(Long payTotal) {
        this.payTotal = payTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayEntity payEntity = (PayEntity) o;
        return payNo == payEntity.payNo &&
                Objects.equals(recordNo, payEntity.recordNo) &&
                Objects.equals(payDate, payEntity.payDate) &&
                Objects.equals(payName, payEntity.payName) &&
                Objects.equals(payProtect, payEntity.payProtect) &&
                Objects.equals(payType, payEntity.payType) &&
                Objects.equals(payPrice, payEntity.payPrice) &&
                Objects.equals(payTotal, payEntity.payTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payNo, recordNo, payDate, payName, payProtect, payType, payPrice, payTotal);
    }
}
