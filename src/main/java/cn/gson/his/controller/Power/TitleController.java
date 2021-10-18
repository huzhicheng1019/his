package cn.gson.his.controller.Power;

import cn.gson.his.model.pojos.Power.Title;
import cn.gson.his.model.pojos.Power.vo.Titvo;
import cn.gson.his.model.service.Power.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lxj")
public class TitleController {

    @Autowired
    TitleService service;

    /**
     * 根据部门id查询该部门的职称
     * @return
     */
    @RequestMapping("/allTit")
    public List<Title> allTit(){
        return service.allTit();
    }

    @RequestMapping("/allTitByEmp")
    public List<Titvo> allTitByEmp(@RequestParam("deptId") Integer deptId,@RequestParam("deparId") Integer deparId){
        return service.allTitByEmp(deptId,deparId);
    }
}
