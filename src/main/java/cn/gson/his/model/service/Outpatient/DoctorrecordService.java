package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.DoctorrecordMapper;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import cn.gson.his.model.pojos.Outpatient.DoctorrecordEntity;
import cn.gson.his.model.pojos.Outpatient.HangmarkEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoctorrecordService {

    @Autowired
    private DoctorrecordMapper dm;
    //病历事务处理层
    @Autowired
    private CaseHistoryService ahs;
    //病历详情处理层
    @Autowired
    private CaseHistoryPartiService chps;

    //挂号修改状态的方法
    @Autowired
    private HangMarkService hms;

    //查询就诊记录
    public List<DoctorrecordEntity>allDoctorrecord(String cxtj){
        return  dm.allDoctorrecord(cxtj);
    }
    //新增
    @Transactional
    public int addDoctorrecord(DoctorrecordEntity doctorre,CaseHistoryEntity caseHis, CaseHistoryPartiEntity CaseHistory,int state,int hangNo){
        //新增病历
        int i = ahs.addCaseHistory(caseHis);
        //给病历详情里面的病历主键赋值
        CaseHistoryEntity caseh = new CaseHistoryEntity();
        caseh.setCaseHissstory(i);
        CaseHistory.setCaseNo(caseh);
        //新增病历详情
        int i1 = chps.addCaseHistory(CaseHistory);
        //new一个就诊记录的详情对象里面放主键新增就诊记录
        CaseHistoryPartiEntity  caseh1 = new CaseHistoryPartiEntity();
        caseh1.setPartiNo(i1);
        doctorre.setCaseNo(caseh1);
        //修改挂号状态
        HangmarkEntity hangmarkEntity = new HangmarkEntity();
        hangmarkEntity.setHangState(state);
        hangmarkEntity.setHangNo(hangNo);
        System.out.println("修改挂号信息");
        hms.upState(hangmarkEntity);
        //返回回去
        return  dm.addDoctorrecord(doctorre);
    }

    //根据就诊科室就诊
    @Transactional
    public List<DoctorrecordEntity>alldoctor(DoctorrecordEntity doctorre){
        return  dm.alldoctor(doctorre);
    }

    //修改就诊状态
    public void upDoctorrecord(DoctorrecordEntity doctorre){
        dm.upDoctorrecord(doctorre);
    }

    //根据就诊号查询就诊记录里面的患者信息
    public List<DoctorrecordEntity> allPatien(String recordNo){
        return dm.allPatien(recordNo);
    }
}
