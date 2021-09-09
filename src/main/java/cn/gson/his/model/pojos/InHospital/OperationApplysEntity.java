package cn.gson.his.model.pojos.InHospital;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Table(name = "OPERATION_APPLYS", schema = "HIS", catalog = "")
public class OperationApplysEntity {
    private int appsId;
    private Integer appId;
    private Integer opsId;
    private String opsName;
    private Long opsPrice;

    private String opsType;
    private String opsDress;
    private String opsIndication;
    private String opsTaboo;


    private Integer opsIs;



}
