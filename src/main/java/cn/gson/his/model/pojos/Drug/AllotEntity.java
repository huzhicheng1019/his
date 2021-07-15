package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ALLOT", schema = "HIS", catalog = "")
public class AllotEntity {
    private int allotId;
    private Timestamp allotDate;
    private Timestamp sqdate;
    private String libraryZt;
    private String zxr;
    private String shr;
    private Integer librarytoId;

    @Id
    @Column(name = "ALLOT_ID")
    public int getAllotId() {
        return allotId;
    }

    public void setAllotId(int allotId) {
        this.allotId = allotId;
    }

    @Basic
    @Column(name = "ALLOT_DATE")
    public Timestamp getAllotDate() {
        return allotDate;
    }

    public void setAllotDate(Timestamp allotDate) {
        this.allotDate = allotDate;
    }

    @Basic
    @Column(name = "SQDATE")
    public Timestamp getSqdate() {
        return sqdate;
    }

    public void setSqdate(Timestamp sqdate) {
        this.sqdate = sqdate;
    }

    @Basic
    @Column(name = "LIBRARY_ZT")
    public String getLibraryZt() {
        return libraryZt;
    }

    public void setLibraryZt(String libraryZt) {
        this.libraryZt = libraryZt;
    }

    @Basic
    @Column(name = "ZXR")
    public String getZxr() {
        return zxr;
    }

    public void setZxr(String zxr) {
        this.zxr = zxr;
    }

    @Basic
    @Column(name = "SHR")
    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    @Basic
    @Column(name = "LIBRARYTO_ID")
    public Integer getLibrarytoId() {
        return librarytoId;
    }

    public void setLibrarytoId(Integer librarytoId) {
        this.librarytoId = librarytoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllotEntity that = (AllotEntity) o;
        return allotId == that.allotId &&
                Objects.equals(allotDate, that.allotDate) &&
                Objects.equals(sqdate, that.sqdate) &&
                Objects.equals(libraryZt, that.libraryZt) &&
                Objects.equals(zxr, that.zxr) &&
                Objects.equals(shr, that.shr) &&
                Objects.equals(librarytoId, that.librarytoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allotId, allotDate, sqdate, libraryZt, zxr, shr, librarytoId);
    }
}
