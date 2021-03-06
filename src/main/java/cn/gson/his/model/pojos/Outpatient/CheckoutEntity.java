package cn.gson.his.model.pojos.Outpatient;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CHECKOUT", schema = "HIS", catalog = "")
public class CheckoutEntity {
    private int checkoutNo;//化验编号
    private String checkoutId;//住院号，就诊号
    private String checkoutCribe;//描述
    private Long checkoutPrice;//总价
    private Integer checkoutState;//收费状态
    private Timestamp checkoutDate;//开申请时间
    private String checkoutDoctor;//医生姓名
    private int checkoutDoctorNo;//医生编号


    //化验详情
    private List<ChangepartEntity> changepartEntities;

    @OneToMany
    public List<ChangepartEntity> getChangepartEntities(){
        return changepartEntities;
    }

    public void setChangepartEntities(List<ChangepartEntity> changepartEntities) {
        this.changepartEntities = changepartEntities;
    }

    @Id
    @Column(name = "CHECKOUT_NO")
    public int getCheckoutNo() {
        return checkoutNo;
    }

    public void setCheckoutNo(int checkoutNo) {
        this.checkoutNo = checkoutNo;
    }

    @Basic
    @Column(name = "CHECKOUT_ID")
    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    @Basic
    @Column(name = "CHECKOUT_CRIBE")
    public String getCheckoutCribe() {
        return checkoutCribe;
    }

    public void setCheckoutCribe(String checkoutCribe) {
        this.checkoutCribe = checkoutCribe;
    }

    @Basic
    @Column(name = "CHECKOUT_PRICE")
    public Long getCheckoutPrice() {
        return checkoutPrice;
    }

    public void setCheckoutPrice(Long checkoutPrice) {
        this.checkoutPrice = checkoutPrice;
    }

    @Basic
    @Column(name = "CHECKOUT_STATE")
    public Integer getCheckoutState() {
        return checkoutState;
    }

    public void setCheckoutState(Integer checkoutState) {
        this.checkoutState = checkoutState;
    }
    public Timestamp getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Timestamp checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getCheckoutDoctor() {
        return checkoutDoctor;
    }

    public void setCheckoutDoctor(String checkoutDoctor) {
        this.checkoutDoctor = checkoutDoctor;
    }

    public int getCheckoutDoctorNo() {
        return checkoutDoctorNo;
    }

    public void setCheckoutDoctorNo(int checkoutDoctorNo) {
        this.checkoutDoctorNo = checkoutDoctorNo;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckoutEntity that = (CheckoutEntity) o;
        return checkoutNo == that.checkoutNo &&
                Objects.equals(checkoutId, that.checkoutId) &&
                Objects.equals(checkoutCribe, that.checkoutCribe) &&
                Objects.equals(checkoutPrice, that.checkoutPrice) &&
                Objects.equals(checkoutState, that.checkoutState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkoutNo, checkoutId, checkoutCribe, checkoutPrice, checkoutState);
    }
}
