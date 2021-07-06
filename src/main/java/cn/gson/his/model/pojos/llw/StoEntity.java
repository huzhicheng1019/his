package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "STO", schema = "HIS", catalog = "")
public class StoEntity {
    private int stoId;
    private Timestamp stoDate;
    private Integer libraryId;
    private Integer why;
    private Integer shr;
    private Integer lyId;

    @Id
    @Column(name = "STO_ID")
    public int getStoId() {
        return stoId;
    }

    public void setStoId(int stoId) {
        this.stoId = stoId;
    }

    @Basic
    @Column(name = "STO_DATE")
    public Timestamp getStoDate() {
        return stoDate;
    }

    public void setStoDate(Timestamp stoDate) {
        this.stoDate = stoDate;
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
    public Integer getWhy() {
        return why;
    }

    public void setWhy(Integer why) {
        this.why = why;
    }

    @Basic
    @Column(name = "SHR")
    public Integer getShr() {
        return shr;
    }

    public void setShr(Integer shr) {
        this.shr = shr;
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
        StoEntity stoEntity = (StoEntity) o;
        return stoId == stoEntity.stoId &&
                Objects.equals(stoDate, stoEntity.stoDate) &&
                Objects.equals(libraryId, stoEntity.libraryId) &&
                Objects.equals(why, stoEntity.why) &&
                Objects.equals(shr, stoEntity.shr) &&
                Objects.equals(lyId, stoEntity.lyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stoId, stoDate, libraryId, why, shr, lyId);
    }
}
