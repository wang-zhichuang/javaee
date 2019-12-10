package entity;

import javax.persistence.*;

@Entity
@Table(name = "sc", schema = "student", catalog = "")
public class ScEntity {
    private int id;
    private int sid;
    private int cid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sid", nullable = false)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "cid", nullable = false)
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScEntity scEntity = (ScEntity) o;

        if (id != scEntity.id) return false;
        if (sid != scEntity.sid) return false;
        if (cid != scEntity.cid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sid;
        result = 31 * result + cid;
        return result;
    }
}
