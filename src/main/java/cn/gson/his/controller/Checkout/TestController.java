package cn.gson.his.controller.Checkout;

import cn.gson.his.model.pojos.Checkout.*;
import cn.gson.his.model.service.Checkout.PageNo;
import cn.gson.his.model.service.Checkout.TestsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("test")
@CrossOrigin
public class TestController {
    @Autowired
    TestsService testsService;

    /**
     * 查询所有检验项目
     * @param pageNo
     * @return
     */
    @PostMapping("all")
    public PageInfo selecttests(@RequestBody PageNo pageNo){
        System.out.println("yundddd");
        return testsService.selecttests(pageNo.getNo(), pageNo.getSize());
    }

    //根据id查询项目详情
    @PostMapping("selectdetails")
    public  PageInfo selectdetails(@RequestParam(value = "no")Integer no,
                                   @RequestParam(value = "size")Integer size,
                                   @RequestParam(value = "id")Integer id){
        return testsService.selectdetails(id,no, size);
    }

    //根据id删除检验项目
    @PostMapping("deltests")
    public Integer deltests(@RequestParam(value = "id") Integer id){
        try {
            testsService.deldetails(id);
            testsService.deltests(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    //新增检验项目
    @PostMapping("inserttest")
    public Integer inserttest(@RequestBody TestVo form){

        TestsEntity entit=new TestsEntity();
        entit.setTestName(form.getTestName());

        TestTypeEntity type=new TestTypeEntity();
        type.setTypeId(form.getType());
        entit.setType(type);

        KeshiEntity keshiEntity=new KeshiEntity();
        keshiEntity.setDepaId(form.getKeshi());
        entit.setKeshi(keshiEntity);

        System.out.println("查询的结果"+entit.toString());
        int i = testsService.inserttest(entit);
        if(i>0){
            return 1;
        }
        return 0;
    }

    //新增检验项目详情
    @PostMapping("insertdetails")
    public Integer insertdetails(@RequestBody TestDetailsEntity form){
        System.out.println(form.toString());
        int i = testsService.insertdetails(form);
        if(i>0){
            return 1;
        }
        return 0;
    }

}
