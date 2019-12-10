package com.sdau.example.springboot1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
	@RequestMapping("/hello")
	public String sayHello(Model model){
		List<String> books = new ArrayList<String>();
		books.add("西游记4");
		books.add("红楼梦4");
		books.add("三国演义4");
		model.addAttribute("books", books);
		return "book/list";

	}
}