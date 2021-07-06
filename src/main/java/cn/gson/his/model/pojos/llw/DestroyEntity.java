package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "DESTROY", schema = "HIS", catalog = "")
public class DestroyEntity {
    private int destroyId;
    private String zxr;
    private Timestamp destroyDate;
    private Timestamp sqdate;
    private Integer libraryZt;
    private String bz;
    private String shr;

    @Id
    @Column(name = "DESTROY_ID")
    public int getDestroyId() {
        return destroyId;
    }

    public void setDestroyId(int destroyId) {
        this.destroyId = destroyId;
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
    @Column(name = "DESTROY_DATE")
    public Timestamp getDestroyDate() {
        return destroyDate;
    }

    public void setDestroyDate(Timestamp destroyDate) {
        this.destroyDate = destroyDate;
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
    public Integer getLibraryZt() {
        return libraryZt;
    }

    public void setLibraryZt(Integer libraryZt) {
        this.libraryZt = libraryZt;
    }

    @Basic
    @Column(name = "BZ")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Basic
    @Column(name = "SHR")
    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DestroyEntity that = (DestroyEntity) o;
        return destroyId == that.destroyId &&
                Objects.equals(zxr, that.zxr) &&
                Objects.equals(destroyDate, that.destroyDate) &&
                Objects.equals(sqdate, that.sqdate) &&
                Objects.equals(libraryZt, that.libraryZt) &&
                Objects.equals(bz, that.bz) &&
                Objects.equals(shr, that.shr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destroyId, zxr, destroyDate, sqdate, libraryZt, bz, shr);
    }
}
