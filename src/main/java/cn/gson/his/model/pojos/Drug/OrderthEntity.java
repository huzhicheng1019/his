package cn.gson.his.model.pojos.Drug;

import cn.gson.his.model.pojos.Power.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ORDERTH", schema = "HIS")
public class OrderthEntity {
    private int orderthId;
    private Employee employee;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")
    private Timestamp orderDate;
    private Long zje;
    private String bz;

    @Id
    @Column(name = "ORDERTH_ID")
    public int getOrderthId() {
        return orderthId;
    }

    public void setOrderthId(int orderthId) {
        this.orderthId = orderthId;
    }

    @ManyToOne
    @JoinColumn(name = "CGR", referencedColumnName = "EMP_ID")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        OrderthEntity that = (OrderthEntity) o;
        return orderthId == that.orderthId &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(zje, that.zje) &&
                Objects.equals(bz, that.bz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderthId, employee, orderDate, zje, bz);
    }
}
