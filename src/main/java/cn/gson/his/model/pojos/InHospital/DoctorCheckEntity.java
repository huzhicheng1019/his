package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DOCTOR_CHECK", schema = "HIS", catalog = "")
public class DoctorCheckEntity {
    private int cheId;
    private Timestamp cheDate;
    private String regMark;
    private String cheName;
    private Integer cheDay;
    private Integer bedId;
    private Integer depaId;

    @Id
    @Column(name = "CHE_ID")
    public int getCheId() {
        return cheId;
    }

    public void setCheId(int cheId) {
        this.cheId = cheId;
    }

    @Basic
    @Column(name = "CHE_DATE")
    public Timestamp getCheDate() {
        return cheDate;
    }

    public void setCheDate(Timestamp cheDate) {
        this.cheDate = cheDate;
    }

    @Basic
    @Column(name = "REG_MARK")
    public String getRegMark() {
        return regMark;
    }

    public void setRegMark(String regMark) {
        this.regMark = regMark;
    }

    @Basic
    @Column(name = "CHE_NAME")
    public String getCheName() {
        return cheName;
    }

    public void setCheName(String cheName) {
        this.cheName = cheName;
    }

    @Basic
    @Column(name = "CHE_DAY")
    public Integer getCheDay() {
        return cheDay;
    }

    public void setCheDay(Integer cheDay) {
        this.cheDay = cheDay;
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
    @Column(name = "DEPA_ID")
    public Integer getDepaId() {
        return depaId;
    }

    public void setDepaId(Integer depaId) {
        this.depaId = depaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorCheckEntity that = (DoctorCheckEntity) o;
        return cheId == that.cheId &&
                Objects.equals(cheDate, that.cheDate) &&
                Objects.equals(regMark, that.regMark) &&
                Objects.equals(cheName, that.cheName) &&
                Objects.equals(cheDay, that.cheDay) &&
                Objects.equals(bedId, that.bedId) &&
                Objects.equals(depaId, that.depaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cheId, cheDate, regMark, cheName, cheDay, bedId, depaId);
    }

    @Override
    public String toString() {
        return "DoctorCheckEntity{" +
                "cheId=" + cheId +
                ", cheDate=" + cheDate +
                ", regMark='" + regMark + '\'' +
                ", cheName='" + cheName + '\'' +
                ", cheDay=" + cheDay +
                ", bedId=" + bedId +
                ", depaId=" + depaId +
                '}';
    }
}
