package cn.gson.his.model.pojos.Outpatient;

import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * 住院申请表
 */


@Data
public class TheHospitalEntity {
    private int hospitalNo;//申请编号
    private Integer patientNo;//病人编号
    private Timestamp hospitalDate;//申请时间
    private String hosptalHospital;//诊断结果
    private Integer depaId;//申请科室
    private Integer hospitalState;//申请状态

    //科室对象
    private Department department;

    //病人对象
    private PatientdataEntity patientdataEntity;


    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //搜索内容
    private String content;




}
