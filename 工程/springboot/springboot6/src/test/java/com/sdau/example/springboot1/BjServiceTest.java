package com.sdau.example.springboot1;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdau.example.springboot1.dao.BjDao;
import com.sdau.example.springboot1.service.BjService;
import com.sdau.example.springboot1.vo.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BjServiceTest {
@Resource
BjService bjService;
@Test
public void bjServiceDelete() {
	
bjService.delete(3);
}

}
