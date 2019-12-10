package service.impl;

import dao.BjDao;
import dao.StudentDao;
import org.springframework.stereotype.Service;
import service.StudentService;
import vo.Student;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao studentDao;
    @Resource
    BjDao bjDao;

    @Override
    public List<Student> queryAll() {
        return studentDao.queryAll();
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public Student findById(int id) {
        return studentDao.findById(id);
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    @Override
    public void delete(int id) {
        studentDao.delete(id);
    }
}
