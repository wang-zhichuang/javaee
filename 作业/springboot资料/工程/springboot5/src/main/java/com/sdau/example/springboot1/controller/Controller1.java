package com.sdau.example.springboot1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdau.example.springboot1.vo.Student;

@Controller
public class Controller1 {
	@RequestMapping("/hello")
	public String sayHello(Model model){
		List<Student> studentList=new ArrayList<Student>();
		Student student1=new Student(1,"1234","zhangsan","男");
		Student student2=new Student(2,"5678","lisi","女");
		studentList.add(student1);
		studentList.add(student2); 
		model.addAttribute("students", studentList);
		return "student/list";

	}
}