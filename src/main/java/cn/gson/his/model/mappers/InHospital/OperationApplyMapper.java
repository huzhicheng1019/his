package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.CancelOperationEntity;
import cn.gson.his.model.pojos.InHospital.OperationApplyEntity;
import cn.gson.his.model.pojos.InHospital.OperationApplysEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OperationApplyMapper {

    //新增手术申请表
    public int insertApp(OperationApplyEntity app);
    //新增手术申请详表
    public int insertApps(List<OperationApplysEntity> Applys);

    //查询手术申请表
    public List<OperationApplyEntity> selApp(String regMark);


    //新增取消手术申请表
    public int insertCan(CancelOperationEntity can);
    //修改手术申请详表状态
    public int updateCan(String appsId);
    //修改手术申请详表状态
    public int updateCan1(@Param("opsIs") String opsIs,@Param("appsId") String appsId);

    //查询所有手术申请表
    public List<OperationApplyEntity> allApp(@Param("depaId")String depaId,@Param("beginTime")String beginTime,@Param("endTime")String endTime,@Param("content")String content);

    //根据住院号查询病人已完成手术的申请表
    public List<OperationApplyEntity> selAppResult(String regMark);

}
