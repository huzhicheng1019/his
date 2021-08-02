package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.Drug.LbEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LbMapper {

    public List<LbEntity> selLb(String lbFl);
}
