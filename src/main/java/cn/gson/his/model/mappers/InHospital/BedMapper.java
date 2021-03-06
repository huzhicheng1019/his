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

        //新增床位
        public int insertBed(BedEntity bed);

        //修改床位
        public int updateBed(BedEntity bed);

        //根据病房id查询所有床位
        public List<BedEntity> selectBed(String roomId);

        //根据床位id查所属病房
        public BedEntity selIdBed(String bedId);

        //修改床位状态
        public int updateStatus(@Param("bedIs")String bedIs,@Param("bedId") String bedId);

}
