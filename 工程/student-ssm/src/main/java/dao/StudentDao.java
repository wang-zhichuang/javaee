package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vo.Student;

public interface StudentDao {
	
	void add(Student student);

	public void update(Student student);

	public void delete(int id);

	public Student findById(int id);

	public List<Student> queryAll();

}
