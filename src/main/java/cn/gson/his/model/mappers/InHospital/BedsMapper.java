package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.BedsEntity;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.ManyToOne;

@Mapper
public interface BedsMapper {

    //新增床位使用记录
    public int insertBeds(BedsEntity beds);

    //新增床位使用记录
    public int insertBedsOne(BedsEntity beds);


    //修改床位使用记录
    public int updateBeds(BedsEntity beds);
}