package cn.gson.his.controller.Checkout;

import cn.gson.his.model.pojos.Checkout.ItemVo;
import cn.gson.his.model.pojos.Checkout.OperationRoomEntity;
import cn.gson.his.model.service.Checkout.Operation_itemsService;
import cn.gson.his.model.service.Checkout.Operation_roomService;
import cn.gson.his.model.service.Checkout.PageNo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("items")
@RestController
public class Operation_itemsController {
    @Autowired
    Operation_itemsService operation_itemsService;

    /**
     * 查询所有手术项目
     * @param pageNo
     * @return
     */
    @PostMapping("all")
    public PageInfo all(@RequestBody PageNo pageNo){
        return operation_itemsService.selectitems(pageNo.getNo(), pageNo.getSize());
    }

    //删除手术项目
    @PostMapping("deloperationItems")
    public Integer delitems(@RequestParam(value = "tions")List<Integer> tions){
        for (Integer integer : tions) {
             operation_itemsService.delitems1(integer);
            operation_itemsService.delitems2(integer);
            operation_itemsService.delitems3(integer);
        }
        return 1;
    }

    //查询所有药品
    @PostMapping("/seldrug")
    public PageInfo seldrug(@RequestBody PageNo pageNo){
        return operation_itemsService.seldrug(pageNo.getNo(), pageNo.getSize());
    }

    //查询所有耗材
    @PostMapping("/selcon")
    public PageInfo selcon(@RequestBody PageNo pageNo){
        return operation_itemsService.selcon(pageNo.getNo(), pageNo.getSize());
    }

    //新增手术项目、药品中间表、耗材中间表
    @PostMapping("insertoperation")
    public int insertoperation(@RequestBody ItemVo form){
        System.out.println("接受到了");
        int i = operation_itemsService.insertoperation(form);

        for (Integer o : form.getA()) {
            operation_itemsService.insertdrug(1,1,o,form.getB());
        }

        for (Integer integer : form.getA1()) {
            operation_itemsService.insertcon(1, 1,integer, form.getB1());
        }


        if(i>0){
            return 1;
        }
        return 0;
    }

}