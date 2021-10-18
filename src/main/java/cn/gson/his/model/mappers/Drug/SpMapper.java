package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.AuditInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Mapper
public interface SpMapper {
    public List<AuditInfo> spselect(@Param("why") String why, @Param("nr") String nr, @Param("qssj") Date qssj, @Param("jssj") Date jssj);
}
