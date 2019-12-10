package cn.oneseek.studentspringboot.service;

import cn.oneseek.studentspringboot.vo.Student;

import java.util.List;

public interface StudentService {

    public List<Student> queryAll();
    public void add(Student student);
    public Student findById(int id);
    public void update(Student student);
    public void delete(int id);
}
