package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "REFUND", schema = "HIS")
public class RefundEntity {
    private String refundId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp refundDate;
    private String pillsId;
    private Employee employee;
    private Long zje;
    private LibraryInfoEntity library;
    private String tywhy;

    @Id
    @Column(name = "REFUND_ID")
    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
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
    public String getPillsId() {
        return pillsId;
    }

    public void setPillsId(String pillsId) {
        this.pillsId = pillsId;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "TYR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Basic
    @Column(name = "ZJE")
    public Long getZje() {
        return zje;
    }

    public void setZje(Long zje) {
        this.zje = zje;
    }

    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID", referencedColumnName = "LIBRARY_ID")
    public LibraryInfoEntity getLibrary() {
        return library;
    }

    public void setLibrary(LibraryInfoEntity library) {
        this.library = library;
    }

    @Basic
    @Column(name = "TYWHY")
    public String getTywhy() {
        return tywhy;
    }

    public void setTywhy(String tywhy) {
        this.tywhy = tywhy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RefundEntity that = (RefundEntity) o;
        return refundId == that.refundId &&
                Objects.equals(refundDate, that.refundDate) &&
                Objects.equals(pillsId, that.pillsId) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(tywhy, that.tywhy) &&
                Objects.equals(library, that.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refundId, refundDate, pillsId, employee, zje, library,tywhy);
    }
}
