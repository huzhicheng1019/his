package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Premiums {
    private Long premiumsId;
    private String drugId;
    private String drugName;
    private Long drugPrice;
    private String premiumId;
    private Long count;
    private String fl;

    private Premium premium;

    @OneToOne
    public Premium getPremium() {
        return premium;
    }

    public void setPremium(Premium premium){
        this.premium = premium;
    }

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "PREMIUMS_ID", nullable = false, precision = 0)
    public Long getPremiumsId() {
        return premiumsId;
    }

    public void setPremiumsId(Long premiumsId) {
        this.premiumsId = premiumsId;
    }

    @Basic
    @Column(name = "DRUG_ID", nullable = true, length = 255)
    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    @Basic
    @Column(name = "DRUG_NAME", nullable = true, length = 255)
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Basic
    @Column(name = "DRUG_PRICE", nullable = true, precision = 0)
    public Long getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(Long drugPrice) {
        this.drugPrice = drugPrice;
    }

    @Basic
    @Column(name = "PREMIUM_ID", nullable = true, precision = 0)
    public String getPremiumId() {
        return premiumId;
    }

    public void setPremiumId(String premiumId) {
        this.premiumId = premiumId;
    }

    @Basic
    @Column(name = "COUNT", nullable = true, precision = 0)
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Basic
    @Column(name = "FL", nullable = true, length = 255)
    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premiums premiums = (Premiums) o;
        return Objects.equals(premiumsId, premiums.premiumsId) && Objects.equals(drugId, premiums.drugId) && Objects.equals(drugName, premiums.drugName) && Objects.equals(drugPrice, premiums.drugPrice) && Objects.equals(premiumId, premiums.premiumId) && Objects.equals(count, premiums.count) && Objects.equals(fl, premiums.fl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(premiumsId, drugId, drugName, drugPrice, premiumId, count, fl);
    }
}
