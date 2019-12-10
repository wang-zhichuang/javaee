package com.sdau.example.springboot1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdau.example.springboot1.vo.Student;

@RestController
public class Controller1 {
	@RequestMapping("hello")
	public String sayHello(){
		return "helloWorld";
	}
	@RequestMapping("student")
	public Student student(){
		Student student=new Student();
		student.setId(1);
		student.setSno("1234");
		student.setSname("zhangsan");
		student.setSex("男");
		return student; 
	}
	@RequestMapping("studentMap")
	public Map<String,Object> studentMap(){
		 Map<String,Object> studentMap=new HashMap<String,Object>();
		 studentMap.put("sno","1234");
		 studentMap.put("sname","zhangsan");
		 studentMap.put("sex","女");
		return studentMap; 
	}
	@RequestMapping("studentList")
	public List<Student> studentList(){
		List<Student> studentList=new ArrayList<Student>();
		Student student1=new Student(1,"1234","zhangsan","男");
		Student student2=new Student(2,"5678","lisi","女");
		studentList.add(student1);
		studentList.add(student2); 
		return studentList; 
	}
	@RequestMapping("mapList")
	public List<Map<String,Object>> mapList(){
		List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
		 Map<String,Object> studentMap1=new HashMap<String,Object>();
		 studentMap1.put("sno","1234");
		 studentMap1.put("sname","zhangsan");
		 studentMap1.put("sex","男");
		 Map<String,Object> studentMap2=new HashMap<String,Object>();
		 studentMap2.put("sno","5678");
		 studentMap2.put("sname","lisi");
		 studentMap2.put("sex","女");
		 mapList.add(studentMap1); mapList.add(studentMap2);
		return mapList; 
	}
}
