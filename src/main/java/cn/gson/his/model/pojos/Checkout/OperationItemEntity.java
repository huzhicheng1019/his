package cn.gson.his.model.pojos.Checkout;

import cn.gson.his.model.pojos.Power.Department;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Table(name = "OPERATION_ITEM", schema = "HIS", catalog = "")
public class OperationItemEntity {
    private long operationId;
    private String operationName;
    private Long operationPrice;
    private String operationType;
    private String operationDress;
    private String operationIndication;
    private String operationTaboo;
    private Long roomId;
    private Long operationZt;

    private Department depa;

}
