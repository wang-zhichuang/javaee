package service;

import org.springframework.stereotype.Service;

@Service(value="service1")
public class Service1 implements IService1 {


	public void service() {
		System.out.println("Ö´ÐÐservice·½·¨");
   
	}

}
