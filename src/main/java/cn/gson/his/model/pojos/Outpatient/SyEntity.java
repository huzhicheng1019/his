package cn.gson.his.model.pojos.Outpatient;

public class SyEntity {
    private String recordId;
    private String name;
    private int count;
    private int price;
    private  int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public SyEntity() {

    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SyEntity(String recordId, String name, int count, int price) {
        this.recordId = recordId;
        this.name = name;
        this.count = count;
        this.price = price;
    }
}
