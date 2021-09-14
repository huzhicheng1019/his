package cn.gson.his.model.mappers.Outpatient;

import cn.gson.his.model.pojos.Outpatient.PaypartEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayPartMappers {

    public void addPayPart(PaypartEntity paypar);

}
