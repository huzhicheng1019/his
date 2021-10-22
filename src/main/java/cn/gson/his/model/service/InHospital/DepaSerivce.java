package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.*;
import cn.gson.his.model.mappers.Outpatient.CaseHistoryMapper;
import cn.gson.his.model.mappers.Outpatient.CaseHistoryPartiMapper;
import cn.gson.his.model.pojos.InHospital.*;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import cn.gson.his.model.pojos.Outpatient.PatientdataEntity;
import cn.gson.his.model.pojos.Power.Department;
import cn.gson.his.model.pojos.Power.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Component
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

    //病房
    @Autowired
    RoomMapper room;

    //押金详情表
    @Autowired
    PrepayDetailsMapper prepayDetails;

    //押金表
    @Autowired
    PrepayMapper prepay;

    //查询当天值班的医生
    public List<Department> selDuty(Integer deparId){
        return  mapper.selDuty(deparId);
    }

    //根据身份证查病人的病历
    public List<CaseHistoryEntity> IdentityCaseHistory(String patientIdentity){
        return caseHistory.IdentityCaseHistory(patientIdentity);
    }
    //根据身份证查当前使用的病历
    public CaseHistoryEntity IdentityCaseHistoryState(String patientIdentity){
        return caseHistory.IdentityCaseHistoryState(patientIdentity);
    }
    //新增病历
    public void insertCaseHistory(CaseHistoryEntity caseHistoryEntity,CaseHistoryPartiEntity caseHistoryPartiEntity){
        //先判断是否有当前病历
        CaseHistoryEntity state = caseHistory.IdentityCaseHistoryState(caseHistoryEntity.getPatientIdentity());
        if(state == null){
            //为空就新增主表
            PatientdataEntity patientdataEntity = new PatientdataEntity();
            caseHistoryEntity.setPatientNo(patientdataEntity);

             caseHistory.addCaseHistory(caseHistoryEntity);
             //然后再添加详表
            caseHistoryPartiEntity.setCaseNo(caseHistoryEntity);
            caseHistoryParti.addCaseHistory(caseHistoryPartiEntity);
        }else{
            //不为空就增详表
            caseHistoryPartiEntity.setCaseNo(state);
            caseHistoryParti.addCaseHistory(caseHistoryPartiEntity);
        }

    }



    //新增转科记录    修改住院登记表
    public int insertTr(TransferEntity transfer){

        //修改住院登记表的科室 主治医生id和名字
        HospitalRegisterEntity look = hospitalRegister.look(transfer.getRegMark());



        //根据病人资料id查病人信息
        PatientdataEntity patientdataEntity = patientData.selPat(look.getPatientNo() + "");
        //转科后新增病历 判断是否有病历 有就增加详表 没有就主表详表一起新增
        CaseHistoryEntity caseHistoryEntity = caseHistory.IdentityCaseHistoryState(patientdataEntity.getPatientIdentity());
        if(caseHistoryEntity == null){
            //新增病历主表
            CaseHistoryEntity caseHis = new  CaseHistoryEntity();
            caseHis.setPatientName(patientdataEntity.getPatientName());
            caseHis.setPatientIdentity(patientdataEntity.getPatientIdentity());
            caseHis.setPatientNo(patientdataEntity);
            caseHis.setCaseState(0);
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

            //修改当前病历为过往病历
            caseHistory.updateCase(caseHistoryEntity.getCaseHissstory()+"");

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




    //每天自动扣除床位费
    @Scheduled(cron = "0 0,0 0,8 ? * ? ")
    public void checkOff(){
        try{

            //先查有多少病人入住
            List<BedsEntity> all = beds.all();
            for (BedsEntity b: all) {
                //根据住院号查押金表
                PrepayEntity prepayEntity = prepay.selectPre(b.getRegMark());
                //根据病床查病房
                BedEntity bedEntity = bed.selIdBed(b.getBedId() + "");
                //根据病房id查床位费
                RoomEntity all1 = room.all(bedEntity.getRoomId() + "");

                //创建一个押金详情对象
                PrepayDetailsEntity prepays = new PrepayDetailsEntity();
                prepays.setPresPrice(all1.getRoomCost());
                prepays.setItemId(0);
                prepays.setPresType(1);
                prepays.setPreId(prepayEntity.getPreId());
                prepays.setPreText("床位扣费");
                //新增扣费记录
                prepayDetails.insertPreDet(prepays);
                //修改住院余额
                //创建一个押金主表对象
                PrepayEntity prepayEntity1 = new PrepayEntity();
                prepayEntity1.setPreBalance(all1.getRoomCost());
                prepayEntity1.setPreId(prepayEntity.getPreId());
                prepay.updatePre1(prepayEntity1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
