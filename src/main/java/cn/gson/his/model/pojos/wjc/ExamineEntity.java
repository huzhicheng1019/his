package cn.gson.his.model.pojos.wjc;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EXAMINE", schema = "HIS", catalog = "")
public class ExamineEntity {
    private int examineNo;
    private Integer examineId;
    private Integer checklistNo;
    private String examineDiagnose;
    private String examineMethod;
    private String examineLook;
    private String examineState;

    @Id
    @Column(name = "EXAMINE_NO")
    public int getExamineNo() {
        return examineNo;
    }

    public void setExamineNo(int examineNo) {
        this.examineNo = examineNo;
    }

    @Basic
    @Column(name = "EXAMINE_ID")
    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    @Basic
    @Column(name = "CHECKLIST_NO")
    public Integer getChecklistNo() {
        return checklistNo;
    }

    public void setChecklistNo(Integer checklistNo) {
        this.checklistNo = checklistNo;
    }

    @Basic
    @Column(name = "EXAMINE_DIAGNOSE")
    public String getExamineDiagnose() {
        return examineDiagnose;
    }

    public void setExamineDiagnose(String examineDiagnose) {
        this.examineDiagnose = examineDiagnose;
    }

    @Basic
    @Column(name = "EXAMINE_METHOD")
    public String getExamineMethod() {
        return examineMethod;
    }

    public void setExamineMethod(String examineMethod) {
        this.examineMethod = examineMethod;
    }

    @Basic
    @Column(name = "EXAMINE_LOOK")
    public String getExamineLook() {
        return examineLook;
    }

    public void setExamineLook(String examineLook) {
        this.examineLook = examineLook;
    }

    @Basic
    @Column(name = "EXAMINE_STATE")
    public String getExamineState() {
        return examineState;
    }

    public void setExamineState(String examineState) {
        this.examineState = examineState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamineEntity that = (ExamineEntity) o;
        return examineNo == that.examineNo &&
                Objects.equals(examineId, that.examineId) &&
                Objects.equals(checklistNo, that.checklistNo) &&
                Objects.equals(examineDiagnose, that.examineDiagnose) &&
                Objects.equals(examineMethod, that.examineMethod) &&
                Objects.equals(examineLook, that.examineLook) &&
                Objects.equals(examineState, that.examineState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examineNo, examineId, checklistNo, examineDiagnose, examineMethod, examineLook, examineState);
    }
}
