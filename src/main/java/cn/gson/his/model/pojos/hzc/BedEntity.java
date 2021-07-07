package cn.gson.his.model.pojos.hzc;

import cn.gson.his.model.pojos.lxj.DepartmentEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * 床位表
 */
@Data
public class BedEntity {
    private int bedId; //床位编号
    private Integer depaId; //所属科室编号
    private Integer bedIs; //床位状态
    private Long bedCost; //床位费用

    //科室对象
    private DepartmentEntity departmentEntity;


}
