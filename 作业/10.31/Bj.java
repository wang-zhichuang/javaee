package cn.oneseek.student.entity;

import java.util.List;

public class Bj {
    private Integer id;

    public String bjname;

    List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBjname() {
        return bjname;
    }

    public void setBjname(String bjname) {
        this.bjname = bjname;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return "Bj [id=" + id + ", bjname=" + bjname + "]";
    }

}