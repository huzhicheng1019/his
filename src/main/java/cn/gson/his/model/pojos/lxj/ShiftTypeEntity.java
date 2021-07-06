/**
 * 班次类别
 */
package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SHIFT_TYPE", schema = "HIS")
public class ShiftTypeEntity {
    private Integer typeId;//id
    private String typeName;//类别名
    private String typeLength;//时长
    private List<ShiftEntity> shifts;//班次

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "TYPE_ID")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "TYPE_NAME")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "TYPE_LENGTH")
    public String getTypeLength() {
        return typeLength;
    }

    public void setTypeLength(String typeLength) {
        this.typeLength = typeLength;
    }

    @OneToMany(mappedBy = "shiftType")
    public List<ShiftEntity> getShifts() {
        return shifts;
    }

    public void setShifts(List<ShiftEntity> shifts) {
        this.shifts = shifts;
    }

    public ShiftTypeEntity(String typeName, String typeLength, List<ShiftEntity> shifts) {
        this.typeName = typeName;
        this.typeLength = typeLength;
        this.shifts = shifts;
    }

    public ShiftTypeEntity() {
    }

    @Override
    public String toString() {
        return "ShiftType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", typeLength='" + typeLength + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftTypeEntity shiftType = (ShiftTypeEntity) o;
        return Objects.equals(typeId, shiftType.typeId) && Objects.equals(typeName, shiftType.typeName) && Objects.equals(typeLength, shiftType.typeLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName, typeLength);
    }
}
