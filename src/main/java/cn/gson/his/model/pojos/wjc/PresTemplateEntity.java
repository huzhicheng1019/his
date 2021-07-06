package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PRES_TEMPLATE", schema = "HIS", catalog = "")
public class PresTemplateEntity {
    private int templateNo;
    private String templateName;
    private String templateType;
    private String shareType;
    private Integer templateState;

    @Id
    @Column(name = "TEMPLATE_NO")
    public int getTemplateNo() {
        return templateNo;
    }

    public void setTemplateNo(int templateNo) {
        this.templateNo = templateNo;
    }

    @Basic
    @Column(name = "TEMPLATE_NAME")
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @Basic
    @Column(name = "TEMPLATE_TYPE")
    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    @Basic
    @Column(name = "SHARE_TYPE")
    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    @Basic
    @Column(name = "TEMPLATE_STATE")
    public Integer getTemplateState() {
        return templateState;
    }

    public void setTemplateState(Integer templateState) {
        this.templateState = templateState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresTemplateEntity that = (PresTemplateEntity) o;
        return templateNo == that.templateNo &&
                Objects.equals(templateName, that.templateName) &&
                Objects.equals(templateType, that.templateType) &&
                Objects.equals(shareType, that.shareType) &&
                Objects.equals(templateState, that.templateState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateNo, templateName, templateType, shareType, templateState);
    }
}
