package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.ExamineEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamineMapper {

        //新增检查单
        public void addExamine(ExamineEntity examineEntity);

        //查询检查单
        public void allExamine(Integer allExamine);

        //修改检查状态
}
