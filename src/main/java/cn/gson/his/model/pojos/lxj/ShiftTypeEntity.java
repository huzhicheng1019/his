package cn.gson.his.model.pojos.lxj;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SHIFT_TYPE", schema = "HIS", catalog = "")
public class ShiftTypeEntity {
    private int typeId;
    private String typeName;
    private String typeLength;

    @Id
    @Column(name = "TYPE_ID")
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShiftTypeEntity that = (ShiftTypeEntity) o;
        return typeId == that.typeId &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(typeLength, that.typeLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName, typeLength);
    }
}
