package cn.gson.his.model.pojos.wjc;

import cn.gson.his.model.pojos.lxj.Department;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

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


}
