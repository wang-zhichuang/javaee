package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.BankService;


public class T {

	private ApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		ac=new ClassPathXmlApplicationContext("bean.xml");
	}

	@Test
	public void transferAccounts() throws Exception {
		BankService bankService=(BankService)ac.getBean("bankService");
		bankService.transferAccounts(50, 1, 2);
	}
	
	

}
