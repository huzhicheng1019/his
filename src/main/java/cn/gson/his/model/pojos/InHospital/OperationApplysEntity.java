package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OPERATION_APPLYS", schema = "HIS", catalog = "")
public class OperationApplysEntity {
    private int appsId;
    private Integer appId;
    private Integer opsId;
    private String opsName;
    private Long opsPrice;

    @Id
    @Column(name = "APPS_ID")
    public int getAppsId() {
        return appsId;
    }

    public void setAppsId(int appsId) {
        this.appsId = appsId;
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
    @Column(name = "OPS_ID")
    public Integer getOpsId() {
        return opsId;
    }

    public void setOpsId(Integer opsId) {
        this.opsId = opsId;
    }

    @Basic
    @Column(name = "OPS_NAME")
    public String getOpsName() {
        return opsName;
    }

    public void setOpsName(String opsName) {
        this.opsName = opsName;
    }

    @Basic
    @Column(name = "OPS_PRICE")
    public Long getOpsPrice() {
        return opsPrice;
    }

    public void setOpsPrice(Long opsPrice) {
        this.opsPrice = opsPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationApplysEntity that = (OperationApplysEntity) o;
        return appsId == that.appsId &&
                Objects.equals(appId, that.appId) &&
                Objects.equals(opsId, that.opsId) &&
                Objects.equals(opsName, that.opsName) &&
                Objects.equals(opsPrice, that.opsPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appsId, appId, opsId, opsName, opsPrice);
    }
}
