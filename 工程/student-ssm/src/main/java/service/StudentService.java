package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.StudentDao;
import vo.Student;
@Service
public class StudentService implements IStudentService {
@Resource
StudentDao studentDao;
	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
studentDao.add(student);
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
studentDao.update(student);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
studentDao.delete(id);
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	@Override
	public List<Student> queryAll() {
		// TODO Auto-generated method stub
		return studentDao.queryAll();
	}

}
