package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GYS", schema = "HIS", catalog = "")
public class GysEntity {
    private int gysId;
    private String gysName;
    private String gysPhone;
    private String gysLxr;
    private String gysDz;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "GYS_ID")
    public int getGysId() {
        return gysId;
    }

    public void setGysId(int gysId) {
        this.gysId = gysId;
    }

    @Basic
    @Column(name = "GYS_NAME")
    public String getGysName() {
        return gysName;
    }

    public void setGysName(String gysName) {
        this.gysName = gysName;
    }

    @Basic
    @Column(name = "GYS_PHONE")
    public String getGysPhone() {
        return gysPhone;
    }

    public void setGysPhone(String gysPhone) {
        this.gysPhone = gysPhone;
    }

    @Basic
    @Column(name = "GYS_LXR")
    public String getGysLxr() {
        return gysLxr;
    }

    public void setGysLxr(String gysLxr) {
        this.gysLxr = gysLxr;
    }

    @Basic
    @Column(name = "GYS_DZ")
    public String getGysDz() {
        return gysDz;
    }

    public void setGysDz(String gysDz) {
        this.gysDz = gysDz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GysEntity gysEntity = (GysEntity) o;
        return gysId == gysEntity.gysId &&
                Objects.equals(gysName, gysEntity.gysName) &&
                Objects.equals(gysPhone, gysEntity.gysPhone) &&
                Objects.equals(gysLxr, gysEntity.gysLxr) &&
                Objects.equals(gysDz, gysEntity.gysDz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gysId, gysName, gysPhone, gysLxr, gysDz);
    }
}
