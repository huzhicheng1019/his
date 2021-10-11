package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.AuditInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SpMapper {
    public List<AuditInfo> spselect(@Param("why") String why, @Param("nr") String nr);;
}
