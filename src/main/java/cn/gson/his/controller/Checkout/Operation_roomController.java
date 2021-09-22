package cn.gson.his.controller.Checkout;

import cn.gson.his.model.pojos.Checkout.OperationRoomEntity;
import cn.gson.his.model.service.Checkout.Operation_roomService;
import cn.gson.his.model.service.Checkout.PageNo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/lrn")
@RestController
public class Operation_roomController {
    @Autowired
    Operation_roomService operation_roomService;

    //查询所有手术室 带分页
    @PostMapping("/selroom")
    public PageInfo demo(@RequestBody PageNo pageNo){
          System.out.println(pageNo.getNo());
          System.out.println(pageNo.getSize());
          return operation_roomService.selectroom(pageNo.getNo(), pageNo.getSize(), pageNo.getName());
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
    public Integer updateroom(@RequestBody OperationRoomEntity roomEntity){
        return operation_roomService.updateroom(roomEntity);
    }
}
