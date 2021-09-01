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

    private List<YpEntity> ssyp;//手术药品

    private List<HcEntity> haocai;//手术耗材

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

    public List<YpEntity> getSsyp() {
        return ssyp;
    }

    public void setSsyp(List<YpEntity> ssyp) {
        this.ssyp = ssyp;
    }

    public List<HcEntity> getHaocai() {
        return haocai;
    }

    public void setHaocai(List<HcEntity> haocai) {
        this.haocai = haocai;
    }
}
