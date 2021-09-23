package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.TransferEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransferMapper {

    //新增转科记录
    public int insertTr(TransferEntity transfer);

}
