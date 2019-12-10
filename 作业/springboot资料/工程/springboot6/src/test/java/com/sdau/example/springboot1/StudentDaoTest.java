package com.sdau.example.springboot1;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdau.example.springboot1.dao.StudentDao;
import com.sdau.example.springboot1.vo.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {
	@Resource
	StudentDao studentDao;
	@Test
	public void testQueryAll() {
		
		List<Student> studentList=studentDao.queryAll();
		for(Student student:studentList) {
			System.out.println(student);
		}
	}
	@Test
	public void testqueryAllWithBj() {
		
		List<Student> studentList=studentDao.queryAllWithBj();
		for(Student student:studentList) {
			System.out.println(student);
		}
	}

}
