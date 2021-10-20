package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.ChuEntity;
import cn.gson.his.model.pojos.Drug.ChujlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CkMapper {
    public List<ChuEntity> chucx(@Param("why") String why, @Param("nr") String nr);

    public List<ChuEntity> chuglcx(@Param("why") String why, @Param("nr") String nr, @Param("qssj") Date qssj, @Param("jssj") Date jssj);

    public List<ChujlEntity> chujlcx(@Param("id") Integer id, @Param("nr") String nr);

    public List<ChujlEntity> chujllyid(String id);
}
