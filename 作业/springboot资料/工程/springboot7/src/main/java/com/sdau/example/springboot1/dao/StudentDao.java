package com.sdau.example.springboot1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdau.example.springboot1.vo.Student;
public interface StudentDao extends JpaRepository<Student,Integer>{
	 
}
