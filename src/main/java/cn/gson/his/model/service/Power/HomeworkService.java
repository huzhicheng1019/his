package cn.gson.his.model.service.Power;

import cn.gson.his.model.mappers.Power.HomeworkMapper;
import cn.gson.his.model.pojos.Power.vo.echarts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class HomeworkService {
    @Autowired
    HomeworkMapper mapper;

    public Map<String,List<Integer>> allHospital(String year){
        List<Integer> hosplist=new ArrayList<>();
        List<Integer> outlist=new ArrayList<>();
        List<Integer> ishost = mapper.isHostYear(year);
        List<Integer> isout = mapper.isOutYear(year);
        if(ishost.isEmpty()){
            for(int i=0;i<12;i++){
                hosplist.add(0);
            }
        }else{
            Map<String, Object> hospmap = mapper.allHospital(year).get(0);
            Iterator it = hospmap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry hostentry =(Map.Entry) it.next();
                //Object key = entry.getKey();
                hosplist.add(Integer.parseInt(hostentry.getValue()+""));
            }
        }
        if(isout.isEmpty()){
            for(int i=0;i<12;i++){
                outlist.add(0);
            }
        }else{
            Map<String, Object> outmap = mapper.allOutpatient(year).get(0);
            Iterator iu = outmap.entrySet().iterator();
            while (iu.hasNext()) {
                Map.Entry outentry =(Map.Entry) iu.next();
                outlist.add(Integer.parseInt(outentry.getValue()+""));
            }
        }
        Map<String,List<Integer>> map=new HashMap<>();
        map.put("host",hosplist);
        map.put("out",outlist);
        return map;
    }
}
