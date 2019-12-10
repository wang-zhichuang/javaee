package dao;

import java.util.List;

import vo.Student;

public interface StudentDao {
	
	public void add(Student student);

	public void update(Student student);

	public void delete(int id);

	public Student findById(int id);

	public List<Student> queryAll();

}
