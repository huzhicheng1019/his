package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "REFUND", schema = "HIS", catalog = "")
public class RefundEntity {
    private int refundId;
    private Timestamp refundDate;
    private Integer pillsId;
    private Integer tyr;
    private Long zje;
    private Integer libraryId;

    @Id
    @Column(name = "REFUND_ID")
    public int getRefundId() {
        return refundId;
    }

    public void setRefundId(int refundId) {
        this.refundId = refundId;
    }

    @Basic
    @Column(name = "REFUND_DATE")
    public Timestamp getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Timestamp refundDate) {
        this.refundDate = refundDate;
    }

    @Basic
    @Column(name = "PILLS_ID")
    public Integer getPillsId() {
        return pillsId;
    }

    public void setPillsId(Integer pillsId) {
        this.pillsId = pillsId;
    }

    @Basic
    @Column(name = "TYR")
    public Integer getTyr() {
        return tyr;
    }

    public void setTyr(Integer tyr) {
        this.tyr = tyr;
    }

    @Basic
    @Column(name = "ZJE")
    public Long getZje() {
        return zje;
    }

    public void setZje(Long zje) {
        this.zje = zje;
    }

    @Basic
    @Column(name = "LIBRARY_ID")
    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefundEntity that = (RefundEntity) o;
        return refundId == that.refundId &&
                Objects.equals(refundDate, that.refundDate) &&
                Objects.equals(pillsId, that.pillsId) &&
                Objects.equals(tyr, that.tyr) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(libraryId, that.libraryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refundId, refundDate, pillsId, tyr, zje, libraryId);
    }
}
