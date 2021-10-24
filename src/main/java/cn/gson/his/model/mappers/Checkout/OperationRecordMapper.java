package cn.gson.his.model.mappers.Checkout;

import cn.gson.his.model.pojos.Checkout.OperationRecordEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperationRecordMapper {

    //新增手术记录（结果）表
    public int insertRecord(OperationRecordEntity recordEntity);

    //修改手术记录（结果）表
    public int updateRecord(OperationRecordEntity recordEntity);

    //根据申请详情编号查记录
    public OperationRecordEntity selectRecord(String operationId);
}
