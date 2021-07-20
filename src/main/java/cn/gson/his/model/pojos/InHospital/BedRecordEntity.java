package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "BED_RECORD", schema = "HIS", catalog = "")
public class BedRecordEntity {
    private int recordId;
    private Integer bedId;
    private String recordCause;
    private Timestamp recordTime;
    private Integer empId;

    @Id
    @Column(name = "RECORD_ID")
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "BED_ID")
    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    @Basic
    @Column(name = "RECORD_CAUSE")
    public String getRecordCause() {
        return recordCause;
    }

    public void setRecordCause(String recordCause) {
        this.recordCause = recordCause;
    }

    @Basic
    @Column(name = "RECORD_TIME")
    public Timestamp getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Timestamp recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "EMP_ID")
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BedRecordEntity that = (BedRecordEntity) o;
        return recordId == that.recordId &&
                Objects.equals(bedId, that.bedId) &&
                Objects.equals(recordCause, that.recordCause) &&
                Objects.equals(recordTime, that.recordTime) &&
                Objects.equals(empId, that.empId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, bedId, recordCause, recordTime, empId);
    }
}
