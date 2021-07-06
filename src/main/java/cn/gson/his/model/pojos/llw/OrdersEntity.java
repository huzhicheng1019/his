package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ORDERS", schema = "HIS", catalog = "")
public class OrdersEntity {
    private int orderId;
    private Integer cgr;
    private Timestamp orderDate;
    private Integer planId;
    private Long zje;
    private String bz;

    @Id
    @Column(name = "ORDER_ID")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "CGR")
    public Integer getCgr() {
        return cgr;
    }

    public void setCgr(Integer cgr) {
        this.cgr = cgr;
    }

    @Basic
    @Column(name = "ORDER_DATE")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "PLAN_ID")
    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "ZJE")
    public Long getZje() {
        return zje;
    }

    public void setZje(Long zje) {
        this.zje = zje;
    }

    @Basic
    @Column(name = "BZ")
    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersEntity that = (OrdersEntity) o;
        return orderId == that.orderId &&
                Objects.equals(cgr, that.cgr) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(planId, that.planId) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, cgr, orderDate, planId, zje, bz);
    }
}
