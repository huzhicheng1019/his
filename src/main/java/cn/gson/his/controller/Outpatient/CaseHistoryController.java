package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CaseHistoryEntity;
import cn.gson.his.model.service.Outpatient.CaseHistoryService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("wjc")
public class CaseHistoryController {

    @Autowired
    private CaseHistoryService chs;

    //查询病历
    @RequestMapping("sllCaseHistory")
    public List<CaseHistoryEntity>sllCaseHistory(String casehis){

        CaseHistoryEntity caseHis= JSONObject.parseObject(casehis,CaseHistoryEntity.class);

        return  chs.allCaseHistory(caseHis);
    }
}
