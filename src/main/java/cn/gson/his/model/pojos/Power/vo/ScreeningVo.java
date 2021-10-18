package cn.gson.his.model.pojos.Power.vo;

public class ScreeningVo {
    private Integer value;
    private String label;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ScreeningVo() {
    }

    public ScreeningVo(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

}
