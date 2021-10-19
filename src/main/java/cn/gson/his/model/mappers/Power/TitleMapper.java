package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.Title;
import cn.gson.his.model.pojos.Power.vo.Titvo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TitleMapper {

    List<Titvo> allTitByEmp(@Param("deptId") Integer deptId,@Param("deparId") Integer deparId);

    List<Title> allTit();
}
