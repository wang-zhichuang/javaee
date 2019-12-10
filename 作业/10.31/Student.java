package cn.oneseek.student.entity;

public class Student {
    private Integer id;

    private String sno;

    private String sname;

    private String sex;

//    private Integer bjid;
    private Bj bj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

//    public Integer getBjid() {
//        return bjid;
//    }
//
//    public void setBjid(Integer bjid) {
//        this.bjid = bjid;
//    }

    public Bj getBj() {
        return bj;
    }
    public void setBj(Bj bj) {
        this.bj = bj;
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", sno=" + sno + ", sname=" + sname + ", sex=" + sex + ", bj=" + bj + "]";
    }
}