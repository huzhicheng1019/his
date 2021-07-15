package cn.gson.his.controller.lrn;

import cn.gson.his.model.pojos.lrn.OperationRoomEntity;
import cn.gson.his.model.service.lrn.Operation_roomService;
import cn.gson.his.model.service.lrn.PageNo;
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
          return operation_roomService.selectroom(pageNo.getNo(), pageNo.getSize());
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

    //根据id删除手术室
    @PostMapping("/del")
    public Integer delrooms(@RequestParam(value = "id") Integer id){

        return operation_roomService.delroom(id);
    }

//    //根据id删除手术室
//    @PostMapping("/delroom")
//    public String delroom(@RequestParam(value = "id") Integer id){
//        System.out.println(id);
//        try {
//            operation_roomService.del(id);
//            return "ok";
//        }catch (Exception e) {
//            e.printStackTrace();
//            return "fail";
//        }
//    }

}
