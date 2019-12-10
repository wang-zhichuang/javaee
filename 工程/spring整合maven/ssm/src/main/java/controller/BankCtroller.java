package controller;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BankService;
@Controller
@RequestMapping("/bank")
public class BankCtroller{
@Resource(name="bankService")
BankService bankService;
@RequestMapping("/transfer")
public String transfer(int account1,int account2,int count,Model model) {
	try{
		bankService.transferAccounts(count, account1, account2);
		model.addAttribute("msg","转账成功");	
	
	}catch(Exception e) {
		e.printStackTrace();
		model.addAttribute("msg","转账失败");
	}
	return "index";
}
}
