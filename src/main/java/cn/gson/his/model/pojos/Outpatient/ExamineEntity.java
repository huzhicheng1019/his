package cn.gson.his.model.pojos.Outpatient;

import cn.gson.his.model.pojos.Checkout.TestsEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EXAMINE", schema = "HIS", catalog = "")
public class ExamineEntity {
    private int examineNo;//检查编号
    private String record_id;//住院号患者就诊号
    private Integer checklistNo;//检查项目编号
    private String examineDiagnose;//临床诊断
    private String examineMethod;//检查方法
    private String examineLook;//检查费用
    private String examineState;//收费状态
    private Timestamp examineDate;//开申请时间
    private String examineDoctor;//医生姓名
    private int examineDoctorNo;//医生编号

    //检验项目
    private TestsEntity testsEntity;

    @OneToOne
    public TestsEntity getTestsEntity() {
        return testsEntity;
    }

    public void setTestsEntity(TestsEntity testsEntity) {
        this.testsEntity = testsEntity;
    }

    @Id
    @Column(name = "EXAMINE_NO")
    public int getExamineNo() {
        return examineNo;
    }

    public void setExamineNo(int examineNo) {
        this.examineNo = examineNo;
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
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

    public Timestamp getExamineDate() {
        return examineDate;
    }

    public void setExamineDate(Timestamp examineDate) {
        this.examineDate = examineDate;
    }

    public String getExamineDoctor() {
        return examineDoctor;
    }

    public void setExamineDoctor(String examineDoctor) {
        this.examineDoctor = examineDoctor;
    }

    public int getExamineDoctorNo() {
        return examineDoctorNo;
    }

    public void setExamineDoctorNo(int examineDoctorNo) {
        this.examineDoctorNo = examineDoctorNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExamineEntity that = (ExamineEntity) o;
        return examineNo == that.examineNo &&
                Objects.equals(record_id, that.record_id) &&
                Objects.equals(checklistNo, that.checklistNo) &&
                Objects.equals(examineDiagnose, that.examineDiagnose) &&
                Objects.equals(examineMethod, that.examineMethod) &&
                Objects.equals(examineLook, that.examineLook) &&
                Objects.equals(examineState, that.examineState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(examineNo, record_id, checklistNo, examineDiagnose, examineMethod, examineLook, examineState);
    }
}
