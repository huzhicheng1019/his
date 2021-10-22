package cn.gson.his.model.pojos.Checkout;

import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Table(name = "OPERATION_ROOM", schema = "HIS", catalog = "")
public class OperationRoomEntity {
    private Integer roomId;
    private String roomName;
    private String roomDress;
    private Integer roomScale;
    private String roomPhone;
    private Integer roomState;

    //科室
    private Department depa;


}
