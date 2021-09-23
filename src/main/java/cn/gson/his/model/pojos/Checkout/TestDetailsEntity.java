package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TEST_DETAILS", schema = "HIS", catalog = "")
public class TestDetailsEntity {
    private long detailsId;
    private String detailsSymbol;

    @Override
    public String toString() {
        return "TestDetailsEntity{" +
                "detailsId=" + detailsId +
                ", detailsSymbol='" + detailsSymbol + '\'' +
                ", detailsName='" + detailsName + '\'' +
                ", detailsCompany='" + detailsCompany + '\'' +
                ", detailsValues='" + detailsValues + '\'' +
                ", detailsPrice=" + detailsPrice +
                ", detailsShuoming='" + detailsShuoming + '\'' +
                '}';
    }

    private String detailsName;
    private String detailsCompany;
    private String detailsValues;
    private Long detailsPrice;
    private String detailsShuoming;
    private TestsEntity ttests;

    @Id
    @Column(name = "DETAILS_ID")
    public long getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(long detailsId) {
        this.detailsId = detailsId;
    }

    @Basic
    @Column(name = "DETAILS_SYMBOL")
    public String getDetailsSymbol() {
        return detailsSymbol;
    }

    public void setDetailsSymbol(String detailsSymbol) {
        this.detailsSymbol = detailsSymbol;
    }

    @Basic
    @Column(name = "DETAILS_NAME")
    public String getDetailsName() {
        return detailsName;
    }

    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName;
    }

    @Basic
    @Column(name = "DETAILS_COMPANY")
    public String getDetailsCompany() {
        return detailsCompany;
    }

    public void setDetailsCompany(String detailsCompany) {
        this.detailsCompany = detailsCompany;
    }

    @Basic
    @Column(name = "DETAILS_VALUES")
    public String getDetailsValues() {
        return detailsValues;
    }

    public void setDetailsValues(String detailsValues) {
        this.detailsValues = detailsValues;
    }

    @Basic
    @Column(name = "DETAILS_PRICE")
    public Long getDetailsPrice() {
        return detailsPrice;
    }

    public void setDetailsPrice(Long detailsPrice) {
        this.detailsPrice = detailsPrice;
    }

    @Basic
    @Column(name = "DETAILS_SHUOMING")
    public String getDetailsShuoming() {
        return detailsShuoming;
    }

    public void setDetailsShuoming(String detailsShuoming) {
        this.detailsShuoming = detailsShuoming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestDetailsEntity that = (TestDetailsEntity) o;
        return detailsId == that.detailsId && Objects.equals(detailsSymbol, that.detailsSymbol) && Objects.equals(detailsName, that.detailsName) && Objects.equals(detailsCompany, that.detailsCompany) && Objects.equals(detailsValues, that.detailsValues) && Objects.equals(detailsPrice, that.detailsPrice) && Objects.equals(detailsShuoming, that.detailsShuoming);
    }

    @Override
    public int hashCode() {
        return Objects.hash(detailsId, detailsSymbol, detailsName, detailsCompany, detailsValues, detailsPrice, detailsShuoming);
    }

    @ManyToOne
    @JoinColumn(name = "TEST_ID", referencedColumnName = "TEST_ID")
    public TestsEntity getTtests() {
        return ttests;
    }

    public void setTtests(TestsEntity ttests) {
        this.ttests = ttests;
    }
}
