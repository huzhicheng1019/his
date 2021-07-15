package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AUDIT_RECORD", schema = "HIS", catalog = "")
public class AuditRecordEntity {
    private int recId;
    private Integer recAud;
    private Integer recState;
    private Integer recUser;

    @Id
    @Column(name = "REC_ID")
    public int getRecId() {
        return recId;
    }

    public void setRecId(int recId) {
        this.recId = recId;
    }

    @Basic
    @Column(name = "REC_AUD")
    public Integer getRecAud() {
        return recAud;
    }

    public void setRecAud(Integer recAud) {
        this.recAud = recAud;
    }

    @Basic
    @Column(name = "REC_STATE")
    public Integer getRecState() {
        return recState;
    }

    public void setRecState(Integer recState) {
        this.recState = recState;
    }

    @Basic
    @Column(name = "REC_USER")
    public Integer getRecUser() {
        return recUser;
    }

    public void setRecUser(Integer recUser) {
        this.recUser = recUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditRecordEntity that = (AuditRecordEntity) o;
        return recId == that.recId &&
                Objects.equals(recAud, that.recAud) &&
                Objects.equals(recState, that.recState) &&
                Objects.equals(recUser, that.recUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recId, recAud, recState, recUser);
    }
}
