package service;

import vo.Bj;
import vo.Student;

import java.util.List;

public interface StudentService {

    public List<Student> queryAll();
    public void add(Student student);
    public Student findById(int id);
    public void update(Student student);
    public void delete(int id);
}
