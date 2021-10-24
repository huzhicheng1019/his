package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.ExamineEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExamineMapper {

        //新增检查单
        public void addExamine(ExamineEntity examineEntity);

        //查询检查单
        public List<ExamineEntity> allExamine(Integer allExamine);
        //查询交完费
        public List<ExamineEntity> allExamineJF(String record_id,int state);

        //修改检查状态
        public int upExamine(String examineState,String record_id);
        //根据编号修改检查状态
        public int upExamineID(String examineState,Integer examineNo);
}
