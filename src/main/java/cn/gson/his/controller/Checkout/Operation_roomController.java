package cn.gson.his.controller.Checkout;

import cn.gson.his.model.pojos.Checkout.OperationRoomEntity;
import cn.gson.his.model.service.Checkout.Operation_roomService;
import cn.gson.his.model.service.Checkout.PageNo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/lrn")
@RestController
public class Operation_roomController {
    @Autowired
    Operation_roomService operation_roomService;

    //查询所有手术室 带分页
    @RequestMapping("/selroom")
    public List<OperationRoomEntity> demo(String name,String depaId){
          return operation_roomService.selectroom(name,depaId);
    }

    //新增手术室
    @PostMapping("/insertroom")
    public int demo(@RequestBody OperationRoomEntity form){
//        OperationRoomEntity operationRoomEntity = JSONObject.parseObject(rooms, OperationRoomEntity.class);
        System.out.println(form.toString());
        int i = operation_roomService.insertroom(form);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //根据id禁用手术室
    @PostMapping("/del")
    public Integer delrooms(@RequestParam(value = "id") Integer id){

        return operation_roomService.delroom(id);
    }

    //根据id启用手术室
    @PostMapping("/updatezt")
    public Integer updatezt(@RequestParam(value = "id") Integer id){
        return operation_roomService.updatezt(id);
    }

    //根据Id编辑手术室
    @PostMapping("/updateroom")
    public int updateroom(@RequestBody OperationRoomEntity roomEntity){
        int i = operation_roomService.updateroom(roomEntity);
        if(i>0){
           return 1;
        }
        return 0;
    }

    //查询所有手术室
    @RequestMapping("/queryRoom")
    public List<OperationRoomEntity> queryRoom(){
        return operation_roomService.queryRoom();
    }

}
