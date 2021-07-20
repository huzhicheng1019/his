package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.BedRecordEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BedRecordMapper {
    //新增床位停用记录
    public int insertRec(BedRecordEntity bedRecord);
}
