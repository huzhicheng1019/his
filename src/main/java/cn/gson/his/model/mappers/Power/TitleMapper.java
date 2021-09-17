package cn.gson.his.model.mappers.Power;

import cn.gson.his.model.pojos.Power.Title;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TitleMapper {

    List<Title> allTitByEmp(Integer deparId);
}
