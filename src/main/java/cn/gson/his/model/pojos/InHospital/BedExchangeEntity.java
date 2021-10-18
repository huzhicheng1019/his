package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Data
@Table(name = "BED_EXCHANGE", schema = "HIS", catalog = "")
public class BedExchangeEntity {
    private int excId;
    private Integer formerBer;
    private Integer nowBed;
    private String regMark;
    private Timestamp excDate;




    //搜索条件
    private Date beginTime;
    private Date endTime;
    private String content;
    private Integer depaId;

    //病床对象
    private BedEntity bed;
    //住院登记信息
    private HospitalRegisterEntity hospitalRegister;
    //科室
    private Department depa;

}
