package cn.gson.his.model.service.InHospital;

import cn.gson.his.model.mappers.InHospital.RoomMapper;
import cn.gson.his.model.pojos.InHospital.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoomService {
    @Autowired
    RoomMapper roomMapper;

    //查询所有病房
    public List<RoomEntity> selRoom(String text,String depasId){
        return roomMapper.selRoom(text,depasId);
    }
    //新增病房
    public int insertRoom(RoomEntity room){
        return roomMapper.insertRoom(room);
    };

    //修改病房
    public int updateRoom(RoomEntity room){
        return roomMapper.updateRoom(room);
    };
}
