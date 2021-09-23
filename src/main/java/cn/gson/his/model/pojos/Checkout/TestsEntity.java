package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TESTS", schema = "HIS", catalog = "")
public class TestsEntity {
    private long testId;
    private String testName;
    private TestTypeEntity type;
    private KeshiEntity keshi;
    private List<TestDetailsEntity> details;

    @Override
    public String toString() {
        return "TestsEntity{" +
                "testId=" + testId +
                ", testName='" + testName + '\'' +
                ", type=" + type +
                ", keshi=" + keshi +
                '}';
    }

    @Id
    @Column(name = "TEST_ID")
    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }

    @Basic
    @Column(name = "TEST_NAME")
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestsEntity that = (TestsEntity) o;
        return testId == that.testId && Objects.equals(testName, that.testName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, testName);
    }

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID")
    public TestTypeEntity getType() {
        return type;
    }

    public void setType(TestTypeEntity type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPA_ID")
    public KeshiEntity getKeshi() {
        return keshi;
    }

    public void setKeshi(KeshiEntity keshi) {
        this.keshi = keshi;
    }

    @OneToMany(mappedBy = "ttests")
    public List<TestDetailsEntity> getDetails() {
        return details;
    }

    public void setDetails(List<TestDetailsEntity> details) {
        this.details = details;
    }
}
