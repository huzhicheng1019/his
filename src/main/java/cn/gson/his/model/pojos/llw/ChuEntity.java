package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CHU", schema = "HIS", catalog = "")
public class ChuEntity {
    private int chuId;
    private Timestamp chuDate;
    private Integer libraryId;
    private String why;
    private Integer lyId;

    @Id
    @Column(name = "CHU_ID")
    public int getChuId() {
        return chuId;
    }

    public void setChuId(int chuId) {
        this.chuId = chuId;
    }

    @Basic
    @Column(name = "CHU_DATE")
    public Timestamp getChuDate() {
        return chuDate;
    }

    public void setChuDate(Timestamp chuDate) {
        this.chuDate = chuDate;
    }

    @Basic
    @Column(name = "LIBRARY_ID")
    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Basic
    @Column(name = "WHY")
    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    @Basic
    @Column(name = "LY_ID")
    public Integer getLyId() {
        return lyId;
    }

    public void setLyId(Integer lyId) {
        this.lyId = lyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChuEntity chuEntity = (ChuEntity) o;
        return chuId == chuEntity.chuId &&
                Objects.equals(chuDate, chuEntity.chuDate) &&
                Objects.equals(libraryId, chuEntity.libraryId) &&
                Objects.equals(why, chuEntity.why) &&
                Objects.equals(lyId, chuEntity.lyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chuId, chuDate, libraryId, why, lyId);
    }
}
