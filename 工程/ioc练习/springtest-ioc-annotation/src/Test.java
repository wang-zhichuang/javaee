import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.PersonService;


public class Test {

	
	public static void main(String[] args) {
		//实例化Spring容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//根据id从容器获取Bean对象,默认id为类名首字母变小写
		PersonService personService = (PersonService)ctx.getBean("personServiceBean");
		//执行personService的save方法
		personService.save();
		
	}

}
