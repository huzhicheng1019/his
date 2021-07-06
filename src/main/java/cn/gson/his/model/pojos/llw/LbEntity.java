package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LB", schema = "HIS", catalog = "")
public class LbEntity {
    private int lbId;
    private String lbName;
    private String lbFl;

    @Id
    @Column(name = "LB_ID")
    public int getLbId() {
        return lbId;
    }

    public void setLbId(int lbId) {
        this.lbId = lbId;
    }

    @Basic
    @Column(name = "LB_NAME")
    public String getLbName() {
        return lbName;
    }

    public void setLbName(String lbName) {
        this.lbName = lbName;
    }

    @Basic
    @Column(name = "LB_FL")
    public String getLbFl() {
        return lbFl;
    }

    public void setLbFl(String lbFl) {
        this.lbFl = lbFl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LbEntity lbEntity = (LbEntity) o;
        return lbId == lbEntity.lbId &&
                Objects.equals(lbName, lbEntity.lbName) &&
                Objects.equals(lbFl, lbEntity.lbFl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lbId, lbName, lbFl);
    }
}
