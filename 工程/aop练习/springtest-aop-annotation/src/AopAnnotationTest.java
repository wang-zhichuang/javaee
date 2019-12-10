
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.AService;
import service.BServiceImpl;


public class AopAnnotationTest {
	ApplicationContext ctx;
@Before
	public void  before() {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		
	}
@Test
public void test1() {
	AService aService = (AService)ctx.getBean("aService");
	aService.barA();
}
@Test
public void test2() {
	AService aService = (AService)ctx.getBean("aService");
	aService.fooA("abc");
}
@Test
public void test3() {
	BServiceImpl bService = (BServiceImpl)ctx.getBean("bService");
	bService.barB("abc",2);
//	bService.barB("abc",1);
}
@Test
public void test4() {
	BServiceImpl bService = (BServiceImpl)ctx.getBean("bService");
	bService.fooB();
}

	

}
