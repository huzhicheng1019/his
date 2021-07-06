package cn.gson.his.model.pojos.lrn;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PHYSICAL_GENRE", schema = "HIS", catalog = "")
public class PhysicalGenreEntity {
    private int genreId;
    private String genreName;

    @Id
    @Column(name = "GENRE_ID")
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "GENRE_NAME")
    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhysicalGenreEntity that = (PhysicalGenreEntity) o;
        return genreId == that.genreId &&
                Objects.equals(genreName, that.genreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, genreName);
    }
}
