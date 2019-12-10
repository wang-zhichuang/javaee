package service;

//使用jdk动态代理  
public class AServiceImpl implements AService  {  
  
    public void barA() {  
    	   System.out.println("执行barA方法");
    }  
  
    public String fooA(String _msg) {  
        System.out.println("执行fooA方法");
        return "fooA结果字符串";
    }  
}  
