package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SET_MEAL", schema = "HIS", catalog = "")
public class SetMealEntity {
    private int mealId;
    private String mealName;
    private Long mealMoney;

    @Id
    @Column(name = "MEAL_ID")
    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    @Basic
    @Column(name = "MEAL_NAME")
    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Basic
    @Column(name = "MEAL_MONEY")
    public Long getMealMoney() {
        return mealMoney;
    }

    public void setMealMoney(Long mealMoney) {
        this.mealMoney = mealMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetMealEntity that = (SetMealEntity) o;
        return mealId == that.mealId &&
                Objects.equals(mealName, that.mealName) &&
                Objects.equals(mealMoney, that.mealMoney);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, mealName, mealMoney);
    }
}
