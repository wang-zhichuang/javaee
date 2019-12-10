package main;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IUserService;
import service.UserService;

public class Main {
	static ApplicationContext ctx= new ClassPathXmlApplicationContext("beans.xml");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserService userService=(IUserService) ctx.getBean("iUserService");
		userService.login("abc","123");
	}

}
