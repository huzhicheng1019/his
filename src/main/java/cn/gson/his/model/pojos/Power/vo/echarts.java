package cn.gson.his.model.pojos.Power.vo;

public class echarts {
    private Integer value;
    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public echarts(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public echarts() {
    }
}
