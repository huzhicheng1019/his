package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * 押金缴费表
 */

@Data
@Table(name = "PREPAY", schema = "HIS", catalog = "")
public class PrepayEntity {
    private int preId;
    private String regMark;
    private Double preBalance;
    private Long preArrearage;

    //押金详表
    private List<PrepayDetailsEntity> prepayDetails;

    //病人信息
    private PatientdataEntity patientdata;

    //科室信息
    private Department department;



    //住院登记表
    private HospitalRegisterEntity hospitalRegisterEntity;


}
