package service;

import org.springframework.stereotype.Service;

@Service(value="service1")
public class Service1 implements IService1 {


	public Service1() {
		super();
		System.out.println("service1对象创建");
	}

	public void service() {
		System.out.println("执行service方法");
   
	}

}
