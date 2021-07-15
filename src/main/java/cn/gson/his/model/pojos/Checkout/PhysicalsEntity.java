package cn.gson.his.model.pojos.Checkout;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PHYSICALS", schema = "HIS", catalog = "")
public class PhysicalsEntity {
    private int physicalId;
    private Integer genreId;
    private String physicalName;
    private Long physicalPrice;
    private String physicalPart;
    private String physicalDescribe;

    @Id
    @Column(name = "PHYSICAL_ID")
    public int getPhysicalId() {
        return physicalId;
    }

    public void setPhysicalId(int physicalId) {
        this.physicalId = physicalId;
    }

    @Basic
    @Column(name = "GENRE_ID")
    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "PHYSICAL_NAME")
    public String getPhysicalName() {
        return physicalName;
    }

    public void setPhysicalName(String physicalName) {
        this.physicalName = physicalName;
    }

    @Basic
    @Column(name = "PHYSICAL_PRICE")
    public Long getPhysicalPrice() {
        return physicalPrice;
    }

    public void setPhysicalPrice(Long physicalPrice) {
        this.physicalPrice = physicalPrice;
    }

    @Basic
    @Column(name = "PHYSICAL_PART")
    public String getPhysicalPart() {
        return physicalPart;
    }

    public void setPhysicalPart(String physicalPart) {
        this.physicalPart = physicalPart;
    }

    @Basic
    @Column(name = "PHYSICAL_DESCRIBE")
    public String getPhysicalDescribe() {
        return physicalDescribe;
    }

    public void setPhysicalDescribe(String physicalDescribe) {
        this.physicalDescribe = physicalDescribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalsEntity that = (PhysicalsEntity) o;
        return physicalId == that.physicalId &&
                Objects.equals(genreId, that.genreId) &&
                Objects.equals(physicalName, that.physicalName) &&
                Objects.equals(physicalPrice, that.physicalPrice) &&
                Objects.equals(physicalPart, that.physicalPart) &&
                Objects.equals(physicalDescribe, that.physicalDescribe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(physicalId, genreId, physicalName, physicalPrice, physicalPart, physicalDescribe);
    }
}
