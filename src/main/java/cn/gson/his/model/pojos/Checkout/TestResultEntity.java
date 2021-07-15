package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_RESULT", schema = "HIS", catalog = "")
public class TestResultEntity {
    private int resultId;
    private Integer changepartNo;
    private String result;
    private String resultShow;

    @Id
    @Column(name = "RESULT_ID")
    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    @Basic
    @Column(name = "CHANGEPART_NO")
    public Integer getChangepartNo() {
        return changepartNo;
    }

    public void setChangepartNo(Integer changepartNo) {
        this.changepartNo = changepartNo;
    }

    @Basic
    @Column(name = "RESULT")
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Basic
    @Column(name = "RESULT_SHOW")
    public String getResultShow() {
        return resultShow;
    }

    public void setResultShow(String resultShow) {
        this.resultShow = resultShow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResultEntity that = (TestResultEntity) o;
        return resultId == that.resultId &&
                Objects.equals(changepartNo, that.changepartNo) &&
                Objects.equals(result, that.result) &&
                Objects.equals(resultShow, that.resultShow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultId, changepartNo, result, resultShow);
    }
}
