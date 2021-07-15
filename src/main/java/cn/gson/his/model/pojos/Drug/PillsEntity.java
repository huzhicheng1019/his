package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PILLS", schema = "HIS", catalog = "")
public class PillsEntity {
    private int pillsId;
    private Timestamp pillsDate;
    private String fylyId;
    private Integer fylyFl;
    private Integer fyr;
    private Long zje;
    private String libraryId;

    @Id
    @Column(name = "PILLS_ID")
    public int getPillsId() {
        return pillsId;
    }

    public void setPillsId(int pillsId) {
        this.pillsId = pillsId;
    }

    @Basic
    @Column(name = "PILLS_DATE")
    public Timestamp getPillsDate() {
        return pillsDate;
    }

    public void setPillsDate(Timestamp pillsDate) {
        this.pillsDate = pillsDate;
    }

    @Basic
    @Column(name = "FYLY_ID")
    public String getFylyId() {
        return fylyId;
    }

    public void setFylyId(String fylyId) {
        this.fylyId = fylyId;
    }

    @Basic
    @Column(name = "FYLY_FL")
    public Integer getFylyFl() {
        return fylyFl;
    }

    public void setFylyFl(Integer fylyFl) {
        this.fylyFl = fylyFl;
    }

    @Basic
    @Column(name = "FYR")
    public Integer getFyr() {
        return fyr;
    }

    public void setFyr(Integer fyr) {
        this.fyr = fyr;
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
    public String getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(String libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PillsEntity that = (PillsEntity) o;
        return pillsId == that.pillsId &&
                Objects.equals(pillsDate, that.pillsDate) &&
                Objects.equals(fylyId, that.fylyId) &&
                Objects.equals(fylyFl, that.fylyFl) &&
                Objects.equals(fyr, that.fyr) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(libraryId, that.libraryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pillsId, pillsDate, fylyId, fylyFl, fyr, zje, libraryId);
    }
}
