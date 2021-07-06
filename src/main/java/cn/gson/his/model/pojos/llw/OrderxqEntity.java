package cn.gson.his.model.pojos.llw;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ORDERXQ", schema = "HIS", catalog = "")
public class OrderxqEntity {
    private int orderxqId;
    private Integer productId;
    private String productName;
    private String productFl;
    private Integer orderId;
    private Integer 数量;
    private String ph;
    private Timestamp mfg;
    private Long price;

    @Id
    @Column(name = "ORDERXQ_ID")
    public int getOrderxqId() {
        return orderxqId;
    }

    public void setOrderxqId(int orderxqId) {
        this.orderxqId = orderxqId;
    }

    @Basic
    @Column(name = "PRODUCT_ID")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "PRODUCT_NAME")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "PRODUCT_FL")
    public String getProductFl() {
        return productFl;
    }

    public void setProductFl(String productFl) {
        this.productFl = productFl;
    }

    @Basic
    @Column(name = "ORDER_ID")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "数量")
    public Integer get数量() {
        return 数量;
    }

    public void set数量(Integer 数量) {
        this.数量 = 数量;
    }

    @Basic
    @Column(name = "PH")
    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    @Basic
    @Column(name = "MFG")
    public Timestamp getMfg() {
        return mfg;
    }

    public void setMfg(Timestamp mfg) {
        this.mfg = mfg;
    }

    @Basic
    @Column(name = "PRICE")
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderxqEntity that = (OrderxqEntity) o;
        return orderxqId == that.orderxqId &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(productFl, that.productFl) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(数量, that.数量) &&
                Objects.equals(ph, that.ph) &&
                Objects.equals(mfg, that.mfg) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderxqId, productId, productName, productFl, orderId, 数量, ph, mfg, price);
    }
}
