package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Employee;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Table(name = "OPERATION_APPLY", schema = "HIS", catalog = "")
public class OperationApplyEntity {
    private int appId;
    private Integer doctorId;
    private String regMark;
    private Timestamp appDate;
    private String appText;

    private List<OperationApplysEntity> apps;

    private Employee emp;

    private HospitalRegisterEntity hospitalRegisterEntity;

    //科室
    private Department depa;



    private Integer depaId;
    private Date beginTime;
    private Date endTime;
    private String content;






}
