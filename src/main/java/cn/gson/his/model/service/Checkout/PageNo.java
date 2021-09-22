package cn.gson.his.model.service.Checkout;

public class PageNo {
    private  Integer no;
    private  Integer size;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public PageNo(Integer no, Integer size) {
        this.no = no;
        this.size = size;
    }

    public PageNo() {
    }
}
