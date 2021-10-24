package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TEST_TYPE", schema = "HIS", catalog = "")
public class TestTypeEntity {
    private long typeId;
    private String typeName;

    private List<TestsEntity> tests;

    @Id
    @Column(name = "TYPE_ID")
    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestTypeEntity that = (TestTypeEntity) o;
        return typeId == that.typeId && Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName);
    }

    @OneToMany(mappedBy = "type")
    public List<TestsEntity> getTests() {
        return tests;
    }

    public void setTests(List<TestsEntity> tests) {
        this.tests = tests;
    }
}
