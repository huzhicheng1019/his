package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.BackEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BackMapper {
//        新增退号
          public void addBack(BackEntity back);
//        查询退号
          public List<BackEntity> seleBack(BackEntity back);
//        删除退号
          public void deleBack(BackEntity back);
}
