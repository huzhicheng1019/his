package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.PrepayDetailsEntity;
import cn.gson.his.model.pojos.InHospital.PrepayEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PrepayMapper {

    //新增押金缴费表
    public int insertPre(PrepayEntity prepay);

    //新增押金缴费详情表
    public int insertPres(PrepayDetailsEntity prepayDetails);

    //查询所有押金表
    public List<PrepayEntity> selPre(@Param("content")String content, @Param("depaId") String depaId);

    //修改押金表余额
    public int updatePre(PrepayEntity prepay);
    //修改押金表余额
    public int updatePre1(PrepayEntity prepay);
    //修改押金表余额
    public int updatePre2(PrepayEntity prepay);

    //根据住院号修改余额
    public int updateMoney(PrepayEntity prepay);

    //根据住院号查押金表
    public PrepayEntity selectPre(String regMark);
}
