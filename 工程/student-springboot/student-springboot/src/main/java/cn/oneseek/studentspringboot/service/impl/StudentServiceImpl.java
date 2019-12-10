package cn.oneseek.studentspringboot.service.impl;

import cn.oneseek.studentspringboot.dao.BjDao;
import cn.oneseek.studentspringboot.dao.StudentDao;
import org.springframework.stereotype.Service;
import cn.oneseek.studentspringboot.service.StudentService;
import cn.oneseek.studentspringboot.vo.Student;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "studentService")
@Transactional
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
