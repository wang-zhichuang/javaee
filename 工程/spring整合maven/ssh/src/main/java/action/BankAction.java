package action;



import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.BankService;
@Controller
@Scope("prototype")
@Namespace("/bank")
public class BankAction extends ActionSupport{
@Resource(name="bankService")
BankService bankService;
int account1,account2,count;
String msg;
public int getAccount1() {
	return account1;
}

public void setAccount1(int account1) {
	this.account1 = account1;
}

public int getAccount2() {
	return account2;
}

public void setAccount2(int account2) {
	this.account2 = account2;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

@Action(value="transfer",results= {
@Result(name="success",location="/index.jsp")
})
public String execute() {
	try{
		bankService.transferAccounts(count, account1, account2);
		msg="转账成功";
	
	
	}catch(Exception e) {
		e.printStackTrace();
		msg="转账失败";
	}
	return "success";
}
}
