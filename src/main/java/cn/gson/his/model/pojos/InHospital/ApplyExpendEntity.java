package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "APPLY_EXPEND", schema = "HIS", catalog = "")
public class ApplyExpendEntity {
    private int expId;
    private Timestamp expDate;
    private Integer expOffice;
    private String expName;
    private Integer appId;
    private Integer expIs;

    @Id
    @Column(name = "EXP_ID")
    public int getExpId() {
        return expId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    @Basic
    @Column(name = "EXP_DATE")
    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    @Basic
    @Column(name = "EXP_OFFICE")
    public Integer getExpOffice() {
        return expOffice;
    }

    public void setExpOffice(Integer expOffice) {
        this.expOffice = expOffice;
    }

    @Basic
    @Column(name = "EXP_NAME")
    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    @Basic
    @Column(name = "APP_ID")
    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "EXP_IS")
    public Integer getExpIs() {
        return expIs;
    }

    public void setExpIs(Integer expIs) {
        this.expIs = expIs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApplyExpendEntity that = (ApplyExpendEntity) o;
        return expId == that.expId &&
                Objects.equals(expDate, that.expDate) &&
                Objects.equals(expOffice, that.expOffice) &&
                Objects.equals(expName, that.expName) &&
                Objects.equals(appId, that.appId) &&
                Objects.equals(expIs, that.expIs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expId, expDate, expOffice, expName, appId, expIs);
    }
}
