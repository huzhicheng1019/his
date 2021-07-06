package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DEPARTMENT", schema = "HIS", catalog = "")
public class DepartmentEntity {
    private int depaId;
    private String depaName;
    private Timestamp depaCreate;
    private Integer depaDept;

    @Id
    @Column(name = "DEPA_ID")
    public int getDepaId() {
        return depaId;
    }

    public void setDepaId(int depaId) {
        this.depaId = depaId;
    }

    @Basic
    @Column(name = "DEPA_NAME")
    public String getDepaName() {
        return depaName;
    }

    public void setDepaName(String depaName) {
        this.depaName = depaName;
    }

    @Basic
    @Column(name = "DEPA_CREATE")
    public Timestamp getDepaCreate() {
        return depaCreate;
    }

    public void setDepaCreate(Timestamp depaCreate) {
        this.depaCreate = depaCreate;
    }

    @Basic
    @Column(name = "DEPA_DEPT")
    public Integer getDepaDept() {
        return depaDept;
    }

    public void setDepaDept(Integer depaDept) {
        this.depaDept = depaDept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentEntity that = (DepartmentEntity) o;
        return depaId == that.depaId &&
                Objects.equals(depaName, that.depaName) &&
                Objects.equals(depaCreate, that.depaCreate) &&
                Objects.equals(depaDept, that.depaDept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depaId, depaName, depaCreate, depaDept);
    }
}
