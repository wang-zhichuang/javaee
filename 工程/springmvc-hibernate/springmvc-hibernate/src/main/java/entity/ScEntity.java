package entity;

import javax.persistence.*;

@Entity
@Table(name = "sc", schema = "student", catalog = "")
public class ScEntity {
    private int id;
    private StudentEntity studentBySid;
    private CourseEntity courseByCid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScEntity scEntity = (ScEntity) o;

        if (id != scEntity.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "id", nullable = false)
    public StudentEntity getStudentBySid() {
        return studentBySid;
    }

    public void setStudentBySid(StudentEntity studentBySid) {
        this.studentBySid = studentBySid;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id", nullable = false)
    public CourseEntity getCourseByCid() {
        return courseByCid;
    }

    public void setCourseByCid(CourseEntity courseByCid) {
        this.courseByCid = courseByCid;
    }
}
