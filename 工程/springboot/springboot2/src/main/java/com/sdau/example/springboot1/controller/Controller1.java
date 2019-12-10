package com.sdau.example.springboot1.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdau.example.springboot1.property.MysqlProperties;

@RestController
public class Controller1 {
	@Value("${hello}")
	String s;
	@Resource
	private MysqlProperties mysqlProperties;
	@RequestMapping("hello")
	public String sayHello(){
		return s; 
	}
	@RequestMapping("/showJdbc")
	public String showJdbc(){
		return "mysql.jdbcName:"+mysqlProperties.getJdbcName()+"<br/>"
			  +"mysql.dbUrl:"+mysqlProperties.getDbUrl()+"<br/>"
			  +"mysql.userName:"+mysqlProperties.getUserName()+"<br/>"
			  +"mysql.password:"+mysqlProperties.getPassword()+"<br/>";
	}
}
