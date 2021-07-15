package cn.gson.his.controller.llw;

import cn.gson.his.model.pojos.llw.ConEntity;
import cn.gson.his.model.pojos.llw.LibraryxqEntity;
import cn.gson.his.model.service.llw.ConService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("/llw")
@RestController
public class ConController {
    @Autowired
    ConService conService;

    @RequestMapping("congl")
    public Map<String,Object> getcon(Integer pageNo, Integer size, String form){
        System.out.println(form);
        ConEntity conEntity = JSONObject.parseObject(form, ConEntity.class);
        Map<String, Object> stringObjectMap = conService.conselect(pageNo,size,conEntity);
        System.out.println(stringObjectMap.get("total"));
        return stringObjectMap;
    }

    @RequestMapping("add-con")
    public String conxz(@RequestBody ConEntity form){
        try {
            conService.savecon(form);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("del-con")
    public String delyp(Integer id){
        System.out.println(id);
        try {
            List<LibraryxqEntity> selectck = conService.selectck(id);
            if(selectck.size()>0){
                return "该药品不可删除";
            }else {
                conService.del(id);
                return "ok";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
