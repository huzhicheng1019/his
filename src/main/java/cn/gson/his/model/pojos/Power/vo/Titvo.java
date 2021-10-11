package cn.gson.his.model.pojos.Power.vo;

import java.util.List;

public class Titvo {
    private Integer id;
    private String name;
    private List<Empvo> emp;

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

    public List<Empvo> getEmp() {
        return emp;
    }

    public void setEmp(List<Empvo> emp) {
        this.emp = emp;
    }

    public Titvo(Integer id, String name, List<Empvo> emp) {
        this.id = id;
        this.name = name;
        this.emp = emp;
    }

    public Titvo() {
    }
}
