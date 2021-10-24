package cn.gson.his.model.service.Checkout;

import cn.gson.his.model.mappers.Checkout.OperationRecordMapper;
import cn.gson.his.model.mappers.Checkout.Operation_roomMapper;
import cn.gson.his.model.mappers.InHospital.*;
import cn.gson.his.model.pojos.Checkout.OperationRecordEntity;
import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import cn.gson.his.model.pojos.InHospital.PrepayEntity;
import cn.gson.his.model.pojos.Power.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional(readOnly = true)
public class OperationRecordService {
    @Autowired
    OperationRecordMapper recordMapper;
    //手术申请
    @Autowired
    OperationApplyMapper applyMapper;
    //手术室
    @Autowired
    Operation_roomMapper roomMapper;

    @Autowired
    EmpMapper empMapper;

    //押金
    @Autowired
    PrepayMapper prepayMapper;

    //押金详情
    @Autowired
    PrepayDetailsMapper prepayDetailsMapper;


    //新增手术记录（结果）表
    public int insertRecord(OperationRecordEntity recordEntity){
        Employee emp = empMapper.findEmp(recordEntity.getDoctorId() + "");
        Employee emp1 = empMapper.findEmp(recordEntity.getNurseId() + "");

        recordEntity.setDoctorMame(emp.getEmpName());
        recordEntity.setNurseName(emp1.getEmpName());

        //修改申请表状态
        applyMapper.updateCan1(1+"",recordEntity.getOperationId()+"");
        //修改手术室状态
        roomMapper.updatezt1(recordEntity.getRoomId());
        //新增手术安排
        int i = recordMapper.insertRecord(recordEntity);


        if(i>0){
            return 1;
        }
        return 0;
    }

    //修改手术记录（结果）表
    public int updateRecord(OperationRecordEntity recordEntity){
        //根据编号查记录表
        OperationRecordEntity operationRecordEntity = recordMapper.selectRecord(recordEntity.getOperationId() + "");

        //修改申请表状态
        applyMapper.updateCan1(3+"",recordEntity.getOperationId()+"");
        //修改手术室状态
        roomMapper.updatezt(operationRecordEntity.getRoomId());


        //根据住院号修改病人余额
        PrepayEntity prepayEntity = prepayMapper.selectPre(operationRecordEntity.getRegMark());

        prepayEntity.setPreBalance(operationRecordEntity.getRecordMoney().doubleValue());

        prepayMapper.updatePre1(prepayEntity);
        //新增详情记录
        PrepayDetailsEntity prepayDetailsEntity = new PrepayDetailsEntity();
        prepayDetailsEntity.setPresPrice(operationRecordEntity.getRecordMoney().doubleValue());
        prepayDetailsEntity.setItemId(0);
        prepayDetailsEntity.setPresType(1);
        prepayDetailsEntity.setPreId(prepayEntity.getPreId());
        prepayDetailsEntity.setPreText("手术扣费");
        prepayDetailsMapper.insertPreDet(prepayDetailsEntity);


        int i = recordMapper.updateRecord(recordEntity);

        if(i>0){
            return 1;
        }
        return 0;
    }

    //根据申请详情编号查记录
    public OperationRecordEntity selectRecord(String operationId){
        return recordMapper.selectRecord(operationId);
    }
}
