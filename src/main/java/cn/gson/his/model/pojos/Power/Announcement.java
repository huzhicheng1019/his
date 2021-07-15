package cn.gson.his.model.pojos.Power;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Announcement {
    private Integer annId;
    private String annText;
    private Timestamp annDate;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "ANN_ID")
    public Integer getAnnId() {
        return annId;
    }

    public void setAnnId(Integer annId) {
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
        Announcement that = (Announcement) o;
        return Objects.equals(annId, that.annId) && Objects.equals(annText, that.annText) && Objects.equals(annDate, that.annDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annId, annText, annDate);
    }
}
