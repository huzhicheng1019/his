package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Power.Department;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@Table(name = "HOSPITAL_REGISTER", schema = "HIS", catalog = "")
public class HospitalRegisterEntity {
    private int regId;
    private String regMark;
    @JsonFormat(timezone = "GMT+8")
    private Timestamp regDate;
    private Integer patientNo;
    private String regName;
    private Integer depaId;
    private Integer doctorId;
    private String doctorName;
    private Integer regIs;
    private String diagnoseResult;

    //病人信息
    private PatientdataEntity patientData;
    //床位使用记录
    private BedsEntity beds;

    //床位表
    private BedEntity bed;


    //科室
    private Department depa;

    //押金表对象
    private PrepayEntity prepay;

    //医嘱
    private List<DoctorEnjoinEntity> doctorEnjoin;

    //医嘱执行记录
    private List<DoctorExecuteEntity> doctorExecute;

    //出院申请
    private DoctorLeaveEntity doctorLeave;

}
