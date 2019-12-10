package controller;



import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import service.IService1;
@Controller
@RequestMapping("/p1")
public class Controller1 {
@Resource(name="service1")
IService1 service1;
public Controller1() {
	System.out.println("Controller1对象创建");
}

@RequestMapping("/controller1")
public String execute() {
	return "output";
}
}
