package cn.gson.his.model.pojos.Checkout;

import java.util.List;

public class ItemVo {
    private long operationId;
    private String operationName;
    private Long operationPrice;
    private String operationType;
    private String operationDress;
    private String operationIndication;
    private String operationTaboo;
    private Integer room;

    private List<Integer> dNum;
    private List<Integer> dPrice;
    private List<Integer> a;
    private Integer b;
    private List<Integer> consumablesNum;
    private List<Integer> consumablesPrice;
    private List<Integer> a1;
    private Integer b1;

    @Override
    public String toString() {
        return "ItemVo{" +
                "operationId=" + operationId +
                ", operationName='" + operationName + '\'' +
                ", operationPrice=" + operationPrice +
                ", operationType='" + operationType + '\'' +
                ", operationDress='" + operationDress + '\'' +
                ", operationIndication='" + operationIndication + '\'' +
                ", operationTaboo='" + operationTaboo + '\'' +
                ", room=" + room +
                ", dNum=" + dNum +
                ", dPrice=" + dPrice +
                ", a=" + a +
                ", b=" + b +
                ", consumablesNum=" + consumablesNum +
                ", consumablesPrice=" + consumablesPrice +
                ", a1=" + a1 +
                ", b1=" + b1 +
                '}';
    }

    public long getOperationId() {
        return operationId;
    }

    public void setOperationId(long operationId) {
        this.operationId = operationId;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Long getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(Long operationPrice) {
        this.operationPrice = operationPrice;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationDress() {
        return operationDress;
    }

    public void setOperationDress(String operationDress) {
        this.operationDress = operationDress;
    }

    public String getOperationIndication() {
        return operationIndication;
    }

    public void setOperationIndication(String operationIndication) {
        this.operationIndication = operationIndication;
    }

    public String getOperationTaboo() {
        return operationTaboo;
    }

    public void setOperationTaboo(String operationTaboo) {
        this.operationTaboo = operationTaboo;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public List<Integer> getdNum() {
        return dNum;
    }

    public void setdNum(List<Integer> dNum) {
        this.dNum = dNum;
    }

    public List<Integer> getdPrice() {
        return dPrice;
    }

    public void setdPrice(List<Integer> dPrice) {
        this.dPrice = dPrice;
    }

    public List<Integer> getA() {
        return a;
    }

    public void setA(List<Integer> a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public List<Integer> getConsumablesNum() {
        return consumablesNum;
    }

    public void setConsumablesNum(List<Integer> consumablesNum) {
        this.consumablesNum = consumablesNum;
    }

    public List<Integer> getConsumablesPrice() {
        return consumablesPrice;
    }

    public void setConsumablesPrice(List<Integer> consumablesPrice) {
        this.consumablesPrice = consumablesPrice;
    }

    public List<Integer> getA1() {
        return a1;
    }

    public void setA1(List<Integer> a1) {
        this.a1 = a1;
    }

    public Integer getB1() {
        return b1;
    }

    public void setB1(Integer b1) {
        this.b1 = b1;
    }
}
