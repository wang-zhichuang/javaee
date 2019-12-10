package action;



import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.IService1;
@Controller
@Scope("prototype")
@Namespace("/p1")
public class StrutsAction1 extends ActionSupport{
@Resource(name="service1")
IService1 service1;
public StrutsAction1() {
	System.out.println("strutsAction对象创建");
}
@Action(value="action1",results= {
@Result(name="success",location="/output.jsp")
})
public String execute() {
	service1.service();
	return "success";
}
}
