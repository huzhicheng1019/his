package cn.gson.his.model.mappers.InHospital;

import cn.gson.his.model.pojos.InHospital.BedEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BedMapper {
        //查询所有床位 带分页
        public List<Map<String,Object>> selectBed(@Param("content") String content, @Param("screen")String screen);

        //新增床位
        public int insertBed(BedEntity bed);

        //修改床位
        public int updateBed(BedEntity bed);
}
