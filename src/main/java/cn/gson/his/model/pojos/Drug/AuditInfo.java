package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "AUDIT_INFO", schema = "HIS", catalog = "")
public class AuditInfo {
    private int approvalId;
    private Timestamp approvalDate;
    private Employee spr;
    private String approvalWhy;
    private String sourceId;
    private String jg;
    private String bz;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "APPROVAL_ID", nullable = false, precision = 0)
    public int getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    @Basic
    @Column(name = "APPROVAL_DATE", nullable = true)
    public Timestamp getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Timestamp approvalDate) {
        this.approvalDate = approvalDate;
    }

    @ManyToOne
    @JoinColumn(name = "SPR", referencedColumnName = "EMP_ID")
    public Employee getSpr() {
        return spr;
    }

    public void setSpr(Employee spr) {
        this.spr = spr;
    }

    @Basic
    @Column(name = "APPROVAL_WHY", nullable = true, length = 255)
    public String getApprovalWhy() {
        return approvalWhy;
    }

    public void setApprovalWhy(String approvalWhy) {
        this.approvalWhy = approvalWhy;
    }

    @Basic
    @Column(name = "SOURCE_ID", nullable = true, precision = 0)
    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    @Basic
    @Column(name = "JG", nullable = true, length = 255)
    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    @Basic
    @Column(name = "BZ", nullable = true, length = 255)
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditInfo auditInfo = (AuditInfo) o;
        return Objects.equals(approvalId, auditInfo.approvalId) && Objects.equals(approvalDate, auditInfo.approvalDate) && Objects.equals(spr, auditInfo.spr) && Objects.equals(approvalWhy, auditInfo.approvalWhy) && Objects.equals(sourceId, auditInfo.sourceId) && Objects.equals(jg, auditInfo.jg) && Objects.equals(bz, auditInfo.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalId, approvalDate, spr, approvalWhy, sourceId, jg, bz);
    }
}
