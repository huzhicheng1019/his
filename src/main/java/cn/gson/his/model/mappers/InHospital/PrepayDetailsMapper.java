package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrepayDetailsMapper {

     //根据缴费表编号查缴费详情表
    public List<PrepayDetailsEntity> selPreDet(String preId);

    //新增缴费详情表
    public int insertPreDet(PrepayDetailsEntity prepayDetailsEntity);
}
