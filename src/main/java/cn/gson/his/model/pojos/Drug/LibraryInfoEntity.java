package cn.gson.his.model.pojos.Drug;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LIBRARY_INFO", schema = "HIS", catalog = "")
public class LibraryInfoEntity {
    private int libraryId;
    private String libraryName;
    private String libraryFl;
    private Integer libraryJb;

    @Id
    @GeneratedValue(generator = "SEQ")
    @SequenceGenerator(name = "SEQ",sequenceName = "seq",initialValue = 1,allocationSize = 1)
    @Column(name = "LIBRARY_ID")
    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Basic
    @Column(name = "LIBRARY_NAME")
    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    @Basic
    @Column(name = "LIBRARY_FL")
    public String getLibraryFl() {
        return libraryFl;
    }

    public void setLibraryFl(String libraryFl) {
        this.libraryFl = libraryFl;
    }

    @Basic
    @Column(name = "LIBRARY_JB")
    public Integer getLibraryJb() {
        return libraryJb;
    }

    public void setLibraryJb(Integer libraryJb) {
        this.libraryJb = libraryJb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryInfoEntity that = (LibraryInfoEntity) o;
        return libraryId == that.libraryId &&
                Objects.equals(libraryName, that.libraryName) &&
                Objects.equals(libraryFl, that.libraryFl) &&
                Objects.equals(libraryJb, that.libraryJb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, libraryName, libraryFl, libraryJb);
    }
}
