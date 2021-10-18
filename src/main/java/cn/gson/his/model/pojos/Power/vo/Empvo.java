package cn.gson.his.model.pojos.Power.vo;

public class Empvo {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Empvo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Empvo() {
    }
}
