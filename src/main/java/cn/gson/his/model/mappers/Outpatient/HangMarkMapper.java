package cn.gson.his.model.mappers.wjc;

import cn.gson.his.model.pojos.wjc.HangmarkEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HangMarkMapper{

    //查询挂号记录
    public List<HangmarkEntity> seleHangMark(HangmarkEntity hang);
    //新增挂号信息
    public int addHang(HangmarkEntity hang);
    //修改挂号信息
    public int upHang(HangmarkEntity hang);
}
