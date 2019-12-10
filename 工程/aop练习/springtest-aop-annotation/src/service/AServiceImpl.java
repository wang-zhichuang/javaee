package service;

import org.springframework.stereotype.Service;

//使用jdk动态代理  
@Service(value="aService")
public class AServiceImpl implements AService  {  
  
    public void barA() {  
    	   System.out.println("执行barA方法");
    	
    }  
  
    public String fooA(String _msg) {  
        System.out.println("执行fooA方法");
        return "fooA结果字符串";
    }  
}  
