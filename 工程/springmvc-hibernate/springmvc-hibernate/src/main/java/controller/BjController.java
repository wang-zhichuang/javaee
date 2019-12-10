package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import po.Bj;
import po.Student;
import util.HibernateUtil;


@Controller
@RequestMapping("/bj")
public class BjController  {
	
   
  
    @RequestMapping("/list")
	public String list(Model model) {		
		
			try {
				List<Bj> bjList=HibernateUtil.query("Bj", "", "");
				model.addAttribute("bjList", bjList);
				return "bj/list";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
			
		
	}
    @RequestMapping("/preadd")
   	public String preadd(){
   	
   			return "bj/add";
   		
   	}
    
    @RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(Bj bj,Model model){
	
		try {
			HibernateUtil.add(bj);
			model.addAttribute("info", "添加成功");
			return "bj/add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    @RequestMapping("/edit")
	public String edit(int id,Model model){
		
		try {
			Bj bj=(Bj)HibernateUtil.get(Bj.class, id);
			model.addAttribute("bj", bj);
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
    @RequestMapping("/update")
	public String update(Bj bj,Model model){		
		try {			
			
			HibernateUtil.update(bj);
			model.addAttribute("info", "更新成功");
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    @RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
		try {
			HibernateUtil.delete(Bj.class,id);
			return "redirect:/bj/list.do";		
					
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	

}
