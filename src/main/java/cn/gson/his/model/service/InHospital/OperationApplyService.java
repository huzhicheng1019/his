package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.OperationApplyMapper;
import cn.gson.his.model.pojos.InHospital.CancelOperationEntity;
import cn.gson.his.model.pojos.InHospital.OperationApplyEntity;
import cn.gson.his.model.pojos.InHospital.OperationApplysEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional(readOnly =true)
public class OperationApplyService {

    @Autowired
    OperationApplyMapper applyMapper;

    //新增手术申请表 和 详表
    public int insertApp(OperationApplyEntity app){
        //新增主表
         applyMapper.insertApp(app);

         //给从表赋主键的值
        List<OperationApplysEntity> apps = app.getApps();
        for (OperationApplysEntity a: apps) {

            a.setAppId(app.getAppId());
        }

        return applyMapper.insertApps(apps);
    }

    //查询手术申请表
    public List<OperationApplyEntity> selApp(String regMark){
        return applyMapper.selApp(regMark);
    }



    //新增取消手术申请记录表 和 修改 手术申请详表状态
    public int update(CancelOperationEntity can,String appsId){
        applyMapper.insertCan(can);
        return applyMapper.updateCan(appsId);

    };


    //查询所有手术申请表
    public List<OperationApplyEntity> allApp(OperationApplyEntity operationApplyEntity){
        String beginTime = null;
        String endTime = null;
        String depaId = "";
        if (operationApplyEntity.getBeginTime() != null && operationApplyEntity.getEndTime() != null ) {
            SimpleDateFormat sf = new SimpleDateFormat("yyy-MM-dd");
            beginTime = sf.format(operationApplyEntity.getBeginTime());
            endTime = sf.format(operationApplyEntity.getEndTime());
        }

        if(operationApplyEntity.getDepaId() != null){
            depaId = operationApplyEntity.getDepaId()+"";
        }
        return  applyMapper.allApp(depaId,beginTime,endTime,operationApplyEntity.getContent());
    }


}
