package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PHYSICAL_RESERVE", schema = "HIS", catalog = "")
public class PhysicalReserveEntity {
    private int reserveId;
    private String reserveName;
    private String reserveSex;
    private String reservePhone;
    private String reserveSfz;
    private Integer reserveType;
    private String reserveTeam;
    private Timestamp reserveTime;

    @Id
    @Column(name = "RESERVE_ID")
    public int getReserveId() {
        return reserveId;
    }

    public void setReserveId(int reserveId) {
        this.reserveId = reserveId;
    }

    @Basic
    @Column(name = "RESERVE_NAME")
    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }

    @Basic
    @Column(name = "RESERVE_SEX")
    public String getReserveSex() {
        return reserveSex;
    }

    public void setReserveSex(String reserveSex) {
        this.reserveSex = reserveSex;
    }

    @Basic
    @Column(name = "RESERVE_PHONE")
    public String getReservePhone() {
        return reservePhone;
    }

    public void setReservePhone(String reservePhone) {
        this.reservePhone = reservePhone;
    }

    @Basic
    @Column(name = "RESERVE_SFZ")
    public String getReserveSfz() {
        return reserveSfz;
    }

    public void setReserveSfz(String reserveSfz) {
        this.reserveSfz = reserveSfz;
    }

    @Basic
    @Column(name = "RESERVE_TYPE")
    public Integer getReserveType() {
        return reserveType;
    }

    public void setReserveType(Integer reserveType) {
        this.reserveType = reserveType;
    }

    @Basic
    @Column(name = "RESERVE_TEAM")
    public String getReserveTeam() {
        return reserveTeam;
    }

    public void setReserveTeam(String reserveTeam) {
        this.reserveTeam = reserveTeam;
    }

    @Basic
    @Column(name = "RESERVE_TIME")
    public Timestamp getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Timestamp reserveTime) {
        this.reserveTime = reserveTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalReserveEntity that = (PhysicalReserveEntity) o;
        return reserveId == that.reserveId &&
                Objects.equals(reserveName, that.reserveName) &&
                Objects.equals(reserveSex, that.reserveSex) &&
                Objects.equals(reservePhone, that.reservePhone) &&
                Objects.equals(reserveSfz, that.reserveSfz) &&
                Objects.equals(reserveType, that.reserveType) &&
                Objects.equals(reserveTeam, that.reserveTeam) &&
                Objects.equals(reserveTime, that.reserveTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reserveId, reserveName, reserveSex, reservePhone, reserveSfz, reserveType, reserveTeam, reserveTime);
    }
}
