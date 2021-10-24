package cn.gson.his.model.mappers.Drug;

import cn.gson.his.model.pojos.Drug.Allot;
import cn.gson.his.model.pojos.Drug.Allotxq;
import cn.gson.his.model.pojos.Drug.Destroy;
import cn.gson.his.model.pojos.Drug.Destroyxq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface XhMapper {
    public List<Destroy> xhcx(@Param("nr") String nr, @Param("qssj") Date qssj, @Param("jssj") Date jssj, @Param("xhqssj") Date xhqssj, @Param("xhjssj") Date xhjssj);

    public List<Destroyxq> xhxqcx(@Param("id") String id, @Param("nr") String nr);

    public List<Destroy> xhcxid(String id);
}
