package com.sdau.example.springboot1;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdau.example.springboot1.dao.BjDao;
import com.sdau.example.springboot1.vo.Bj;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BjDaoTest {
@Resource
BjDao bjDao;
@Test
public void testfindByIdWithStudents() {
	
	List<Bj> bjs=bjDao.findAll();
	for(Bj bj:bjs) {
		System.out.println(bj);
	}
}

}
