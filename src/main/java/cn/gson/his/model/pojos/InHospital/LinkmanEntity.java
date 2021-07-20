package cn.gson.his.model.pojos.InHospital;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LINKMAN", schema = "HIS", catalog = "")
public class LinkmanEntity {
    private int linkId;
    private String linkName;
    private String linkPhone;
    private String linkRelation;
    private Integer regMark;

    @Id
    @Column(name = "LINK_ID")
    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    @Basic
    @Column(name = "LINK_NAME")
    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    @Basic
    @Column(name = "LINK_PHONE")
    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    @Basic
    @Column(name = "LINK_RELATION")
    public String getLinkRelation() {
        return linkRelation;
    }

    public void setLinkRelation(String linkRelation) {
        this.linkRelation = linkRelation;
    }

    @Basic
    @Column(name = "REG_MARK")
    public Integer getRegMark() {
        return regMark;
    }

    public void setRegMark(Integer regMark) {
        this.regMark = regMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkmanEntity that = (LinkmanEntity) o;
        return linkId == that.linkId &&
                Objects.equals(linkName, that.linkName) &&
                Objects.equals(linkPhone, that.linkPhone) &&
                Objects.equals(linkRelation, that.linkRelation) &&
                Objects.equals(regMark, that.regMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId, linkName, linkPhone, linkRelation, regMark);
    }
}
