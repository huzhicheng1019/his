package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.*;
import cn.gson.his.model.mappers.Outpatient.CaseHistoryMapper;
import cn.gson.his.model.mappers.Outpatient.CaseHistoryPartiMapper;
import cn.gson.his.model.pojos.InHospital.BedsEntity;
import cn.gson.his.model.pojos.InHospital.DoctorEnjoinEntity;
import cn.gson.his.model.pojos.InHospital.HospitalRegisterEntity;
import cn.gson.his.model.pojos.InHospital.TransferEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepaSerivce {

    @Autowired
    DepaMapper mapper;

    //转科记录
    @Autowired
    TransferMapper transferMapper;

    //住院登记表
    @Autowired
    HospitalRegisterMapper hospitalRegister;

    //病人资料表
    @Autowired
    PatientDataMapper patientData;

    //病历表
    @Autowired
    CaseHistoryMapper caseHistory;

    //病历详表
    @Autowired
    CaseHistoryPartiMapper caseHistoryParti;

    //床位记录表
    @Autowired
    BedsMapper beds;

    //床位表
    @Autowired
    BedMapper bed;

    //医嘱表
    @Autowired
    DoctorEnjoinMapper doctorEnjoin;

    //查询当天值班的医生
    public List<Department> selDuty(Integer deparId){
        return  mapper.selDuty(deparId);
    }


    //新增转科记录    修改住院登记表
    public int insertTr(TransferEntity transfer){

        //修改住院登记表的科室 主治医生id和名字
        HospitalRegisterEntity look = hospitalRegister.look(transfer.getRegMark());



        //根据病人资料id查病人信息
        PatientdataEntity patientdataEntity = patientData.selPat(look.getPatientNo() + "");
        //转科后新增病历 判断是否有病历 有就增加详表 没有就主表详表一起新增
        CaseHistoryEntity caseHistoryEntity = caseHistory.IdentityCaseHistory(patientdataEntity.getPatientIdentity());
        if(caseHistoryEntity == null){
            //新增病历主表
            CaseHistoryEntity caseHis = new  CaseHistoryEntity();
            caseHis.setPatientName(patientdataEntity.getPatientName());
            caseHis.setPatientIdentity(patientdataEntity.getPatientIdentity());
            caseHis.setPatientNo(patientdataEntity);
            caseHistory.addCaseHistory(caseHis);
            //新增详表
            CaseHistoryPartiEntity caseHistoryPart1 = new CaseHistoryPartiEntity();

            Employee emp = new Employee();
            emp.setEmpId(look.getDoctorId());

            caseHistoryPart1.setChief(transfer.getTrCause());
            caseHistoryPart1.setSuggestion(transfer.getTrCause());
            caseHistoryPart1.setDoctorId(emp);
            caseHistoryPart1.setDoctorName(look.getDoctorName());
            caseHistoryPart1.setCaseNo(caseHis);

            caseHistoryPart1.setPresents("无");
            caseHistoryPart1.setPreviouss("无");
            caseHistoryPart1.setCheckup("无");


            caseHistoryParti.addCaseHistory(caseHistoryPart1);

        }else {
            //新增详表
            CaseHistoryPartiEntity caseHistoryPart2 = new CaseHistoryPartiEntity();

            Employee emp = new Employee();
            emp.setEmpId(look.getDoctorId());

            caseHistoryPart2.setChief(transfer.getTrCause());
            caseHistoryPart2.setSuggestion(transfer.getTrCause());
            caseHistoryPart2.setDoctorId(emp);
            caseHistoryPart2.setDoctorName(look.getDoctorName());
            caseHistoryPart2.setCaseNo(caseHistoryEntity);
            caseHistoryPart2.setPresents("无");
            caseHistoryPart2.setPreviouss("无");
            caseHistoryPart2.setCheckup("无");

            caseHistoryParti.addCaseHistory(caseHistoryPart2);
        }


        //判断医嘱是否跟随  来取消医嘱
        if(transfer.getTrIs() == 0){
            List<DoctorEnjoinEntity>  yz = doctorEnjoin.queryEn(transfer.getRegMark());

            if(!yz.isEmpty()){
                for (DoctorEnjoinEntity d: yz) {
                    doctorEnjoin.updateEn(d.getEnId()+"");
                    doctorEnjoin.updateEns(d.getEnId()+"");
                }
            }
        }

        //修改床位记录
        BedsEntity bedsEntity = beds.selBeds(transfer.getRegMark());

        beds.alterBeds(transfer.getRegMark());
        bed.updateStatus("0",bedsEntity.getBedId()+"");


        //修改住院登记表
        look.setDepaId(transfer.getNewDepa());
        look.setDoctorId(transfer.getNewDoctorId());
        look.setDoctorName(transfer.getNewDoctorName());
        //修改
        hospitalRegister.updateReg(look);


        //新增转科记录
        int i = transferMapper.insertTr(transfer);
        if (i>0){
            return 1;
        }
        return 0;
    }
}
