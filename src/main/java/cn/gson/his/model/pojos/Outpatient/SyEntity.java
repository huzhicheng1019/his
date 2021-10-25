package cn.gson.his.model.pojos.Outpatient;

import oracle.sql.DATE;

import java.util.Date;

public class SyEntity {
    private String recordId;
    private String name;
    private int count;
    private int price;
    private  int state;
    private Date dateXM;
    private String doctor;
    private  int id;
    private int no;
    private  int Xstate;

    public int getXstate() {
        return Xstate;
    }

    public void setXstate(int xstate) {
        Xstate = xstate;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateXM() {
        return dateXM;
    }

    public void setDateXM(Date dateXM) {
        this.dateXM = dateXM;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

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
