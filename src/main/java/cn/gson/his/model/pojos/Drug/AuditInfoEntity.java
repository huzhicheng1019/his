package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "AUDIT_INFO", schema = "HIS", catalog = "")
public class AuditInfoEntity {
    private int approvalId;
    private Timestamp approvalDate;
    private String spr;
    private Integer approvalZt;
    private String approvalWhy;
    private String sourceId;

    @Id
    @Column(name = "APPROVAL_ID")
    public int getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    @Basic
    @Column(name = "APPROVAL_DATE")
    public Timestamp getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Timestamp approvalDate) {
        this.approvalDate = approvalDate;
    }

    @Basic
    @Column(name = "SPR")
    public String getSpr() {
        return spr;
    }

    public void setSpr(String spr) {
        this.spr = spr;
    }

    @Basic
    @Column(name = "APPROVAL_ZT")
    public Integer getApprovalZt() {
        return approvalZt;
    }

    public void setApprovalZt(Integer approvalZt) {
        this.approvalZt = approvalZt;
    }

    @Basic
    @Column(name = "APPROVAL_WHY")
    public String getApprovalWhy() {
        return approvalWhy;
    }

    public void setApprovalWhy(String approvalWhy) {
        this.approvalWhy = approvalWhy;
    }

    @Basic
    @Column(name = "SOURCE_ID")
    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditInfoEntity that = (AuditInfoEntity) o;
        return approvalId == that.approvalId &&
                Objects.equals(approvalDate, that.approvalDate) &&
                Objects.equals(spr, that.spr) &&
                Objects.equals(approvalZt, that.approvalZt) &&
                Objects.equals(approvalWhy, that.approvalWhy) &&
                Objects.equals(sourceId, that.sourceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalId, approvalDate, spr, approvalZt, approvalWhy, sourceId);
    }
}
