package cn.oneseek.studentspringboot.dao;

import cn.oneseek.studentspringboot.vo.Student;


import java.util.List;


public interface StudentDao {
	
	public void add(Student student);

	public void update(Student student);

	public void delete(int id);

	public Student findById(int id);

	public List<Student> queryAll();

}
