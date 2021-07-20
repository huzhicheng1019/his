package cn.gson.his.controller.InHospital;

import cn.gson.his.model.pojos.InHospital.RoomEntity;
import cn.gson.his.model.service.InHospital.RoomService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/hzc")
@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    //查询所有病房
    @RequestMapping("selRoom")
    public List<RoomEntity> demo(String text,String depasId){
        System.out.println("========="+text);
        System.out.println("========="+depasId);
        return roomService.selRoom(text,depasId);
    }

    //新增病房
    @RequestMapping("insertRoom")
    public int demo1(String room){
        RoomEntity roomEntity = JSONObject.parseObject(room, RoomEntity.class);
        int i = roomService.insertRoom(roomEntity);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //修改病房
    @RequestMapping("updateRoom")
    public int demo2(String room){
        RoomEntity roomEntity = JSONObject.parseObject(room, RoomEntity.class);
        int i = roomService.updateRoom(roomEntity);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //根据科室id查病房
    @RequestMapping("selIdRoom")
    public List<RoomEntity> demo3(String depaId){
        return roomService.selIdRoom(depaId);
    }
}
