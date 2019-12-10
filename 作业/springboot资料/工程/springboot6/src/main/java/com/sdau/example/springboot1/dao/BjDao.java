package com.sdau.example.springboot1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sdau.example.springboot1.vo.Bj;
@Mapper
public interface BjDao {
	 
	void add(Bj bj);

	public void update(Bj bj);

	public void delete(int id);

	public Bj findById(int id);

	public List<Bj> queryAll();
	
	public Bj findByIdWithStudents(int id);

}
