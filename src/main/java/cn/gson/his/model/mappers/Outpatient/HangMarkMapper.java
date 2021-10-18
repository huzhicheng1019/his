package cn.gson.his.model.mappers.Outpatient;


import cn.gson.his.model.pojos.Outpatient.HangmarkEntity;
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
    //专门修改状态的方法
    public int upState(HangmarkEntity hang);

    //挂号记录查询
    public List<HangmarkEntity> seleHang(String hangDate,String hangDate1,String hang);
}
