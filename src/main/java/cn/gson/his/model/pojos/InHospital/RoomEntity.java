package cn.gson.his.model.pojos.InHospital;

import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * 病房表
 */

@Data
@Table(name = "ROOM", schema = "HIS", catalog = "")
public class RoomEntity {
    private int roomId;
    private String roomName;
    private String roomSite;
    private Integer depaId;
    private Integer roomIs;

    //科室对象
    private Department department;




}
