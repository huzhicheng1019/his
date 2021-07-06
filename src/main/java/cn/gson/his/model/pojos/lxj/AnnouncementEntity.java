package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ANNOUNCEMENT", schema = "HIS", catalog = "")
public class AnnouncementEntity {
    private int annId;
    private String annText;
    private Timestamp annDate;

    @Id
    @Column(name = "ANN_ID")
    public int getAnnId() {
        return annId;
    }

    public void setAnnId(int annId) {
        this.annId = annId;
    }

    @Basic
    @Column(name = "ANN_TEXT")
    public String getAnnText() {
        return annText;
    }

    public void setAnnText(String annText) {
        this.annText = annText;
    }

    @Basic
    @Column(name = "ANN_DATE")
    public Timestamp getAnnDate() {
        return annDate;
    }

    public void setAnnDate(Timestamp annDate) {
        this.annDate = annDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnouncementEntity that = (AnnouncementEntity) o;
        return annId == that.annId &&
                Objects.equals(annText, that.annText) &&
                Objects.equals(annDate, that.annDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annId, annText, annDate);
    }
}
