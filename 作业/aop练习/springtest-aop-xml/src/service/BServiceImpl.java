package service;

//使用cglib  
public class BServiceImpl {  
  
    public void barB(String _msg, int _type) {  
        System.out.println("执行barB方法");  
        if (_type == 1)  
            throw new IllegalArgumentException("测试异常");  
    }  
  
    public String fooB() {  
        System.out.println("执行fooB方法");  
        return "fooB结果字符串";
    }  
  
}  
