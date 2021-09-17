package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "MEALTYPE", schema = "HIS", catalog = "")
public class MealtypeEntity {
    private long mealtypeId;
    private String mealtypeName;
    private List<SetMealEntity> setmeal;

    @Id
    @Column(name = "MEALTYPE_ID")
    public long getMealtypeId() {
        return mealtypeId;
    }

    public void setMealtypeId(long mealtypeId) {
        this.mealtypeId = mealtypeId;
    }

    @Basic
    @Column(name = "MEALTYPE_NAME")
    public String getMealtypeName() {
        return mealtypeName;
    }

    public void setMealtypeName(String mealtypeName) {
        this.mealtypeName = mealtypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealtypeEntity that = (MealtypeEntity) o;
        return mealtypeId == that.mealtypeId && Objects.equals(mealtypeName, that.mealtypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealtypeId, mealtypeName);
    }

    @OneToMany(mappedBy = "mealtype")
    public List<SetMealEntity> getSetmeal() {
        return setmeal;
    }

    public void setSetmeal(List<SetMealEntity> setmeal) {
        this.setmeal = setmeal;
    }
}
