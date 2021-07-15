package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "CHECKS", schema = "HIS", catalog = "")
public class ChecksEntity {
    private int checkId;
    private Timestamp checkDate;
    private Integer libraryId;
    private Integer fzr;
    private Integer shr;

    @Id
    @Column(name = "CHECK_ID")
    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }

    @Basic
    @Column(name = "CHECK_DATE")
    public Timestamp getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Timestamp checkDate) {
        this.checkDate = checkDate;
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
    @Column(name = "FZR")
    public Integer getFzr() {
        return fzr;
    }

    public void setFzr(Integer fzr) {
        this.fzr = fzr;
    }

    @Basic
    @Column(name = "SHR")
    public Integer getShr() {
        return shr;
    }

    public void setShr(Integer shr) {
        this.shr = shr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChecksEntity that = (ChecksEntity) o;
        return checkId == that.checkId &&
                Objects.equals(checkDate, that.checkDate) &&
                Objects.equals(libraryId, that.libraryId) &&
                Objects.equals(fzr, that.fzr) &&
                Objects.equals(shr, that.shr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkId, checkDate, libraryId, fzr, shr);
    }
}
