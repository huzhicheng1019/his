package cn.gson.his.model.service.Outpatient;

import cn.gson.his.model.mappers.Outpatient.ExamineMapper;
import cn.gson.his.model.pojos.Outpatient.ExamineEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamineService {

    @Autowired
    ExamineMapper examineMapper;

    //新增检查单
    @Transactional
    public void addExamine(ExamineEntity examineEntity){
             examineMapper.addExamine(examineEntity);
    }

    //查询检查单
    public List<ExamineEntity> allExamine(Integer allExamine){
            return  examineMapper.allExamine(allExamine);
    }
    //查询交完费的检查单
    public List<ExamineEntity> allExamineJF(String record_id,int state){
        return  examineMapper.allExamineJF(record_id,state);
    }

    //修改检查状态
    public int upExamine(String examineState,String examineNo){
            return examineMapper.upExamine(examineState,examineNo);
    }
    //根据编号修改检查状态
    public int upExamineID(String examineState,Integer examineNo){
        return examineMapper.upExamineID(examineState,examineNo);
    }
}
