package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

/**
 * 床位表
 */
@Data
public class BedEntity {
    private int bedId; //床位编号
    private String bedName;//床位名称
    private Integer roomId; //所属科室编号
    private Integer bedIs; //床位状态




    //病房对象
    private RoomEntity room;


}
