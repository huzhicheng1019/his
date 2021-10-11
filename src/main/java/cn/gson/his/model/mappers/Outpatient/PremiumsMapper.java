package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Drug.Premium;
import cn.gson.his.model.pojos.Drug.Premiums;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface PremiumsMapper {
    //查询退费申请
    public List<Premium> selectPremium(Premium Premium);
    //查询退费申请详情
    public List<Premiums> selectPremiums(Integer id);
    // 修改状态
    public int upPremiums(Integer PremiumsState);
}
