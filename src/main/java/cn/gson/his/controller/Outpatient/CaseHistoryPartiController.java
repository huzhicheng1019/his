package cn.gson.his.controller.Outpatient;

import cn.gson.his.model.pojos.Outpatient.CaseHistoryPartiEntity;
import cn.gson.his.model.service.Outpatient.CaseHistoryPartiService;
import com.alibaba.fastjson.JSONObject;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wjc")
public class CaseHistoryPartiController {

        @Autowired
        CaseHistoryPartiService chps;

        //病历详情
        @RequestMapping("allCaseHis")
        public List<CaseHistoryPartiEntity>allCaseHis(String casehis){
            CaseHistoryPartiEntity caseHistoryPartiEntity = JSONObject.parseObject(casehis, CaseHistoryPartiEntity.class);
            return chps.allCaseHistoryX(caseHistoryPartiEntity);
        }

}

