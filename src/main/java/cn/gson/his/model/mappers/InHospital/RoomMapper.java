package cn.gson.his.model.mappers.InHospital;


import cn.gson.his.model.pojos.InHospital.RoomEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.persistence.ManyToOne;
import java.util.List;

@Mapper
public interface RoomMapper {

        //查询所有病房-
        public List<RoomEntity> selRoom(@Param("text")String text,@Param("depasId") String depasId);

        //新增病房
        public int insertRoom(RoomEntity room);

        //修改病房
        public int updateRoom(RoomEntity room);

        //根据科室id查病房
        public List<RoomEntity> selIdRoom(String depaId);
}
