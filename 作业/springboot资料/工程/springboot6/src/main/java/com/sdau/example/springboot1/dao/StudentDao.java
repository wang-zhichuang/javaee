package com.sdau.example.springboot1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sdau.example.springboot1.vo.Student;
@Mapper
public interface StudentDao {
	
	void add(Student student);

	public void update(Student student);

	public void delete(int id);

	public Student findById(int id);

	public List<Student> queryAll();
	public List<Student> queryAllWithBj();

}
