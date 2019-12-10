package controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.BjDao;
import util.SqlSessionFactoryUtil;
import vo.Bj;


@Controller
@RequestMapping("/bj")
public class BjController  {
	

  
    @RequestMapping("/list")
	public String list(Model model) {		
    	SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		BjDao bjDao=sqlSession.getMapper(BjDao.class);	
			try {
				List<Bj> bjList=bjDao.queryAll();
				sqlSession.close();
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
    	SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		BjDao bjDao=sqlSession.getMapper(BjDao.class);	
		try {
			bjDao.add(bj);
			sqlSession.commit();
			sqlSession.close();
			model.addAttribute("info", "添加成功");
			return "bj/add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    @RequestMapping("/edit")
	public String edit(int id,Model model){
    	SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		BjDao bjDao=sqlSession.getMapper(BjDao.class);	
		try {
			Bj bj=bjDao.findById(id);
			sqlSession.close();
			model.addAttribute("bj", bj);
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
    @RequestMapping("/update")
	public String update(Bj bj,Model model){	
    	SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		BjDao bjDao=sqlSession.getMapper(BjDao.class);	
		try {			
			
			bjDao.update(bj);
			sqlSession.commit();
			sqlSession.close();
			model.addAttribute("info", "更新成功");
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    @RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
    	SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		BjDao bjDao=sqlSession.getMapper(BjDao.class);	
		try {
			bjDao.delete(id);
			sqlSession.commit();
			sqlSession.close();
			return "redirect:/bj/list.do";		
					
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	

}
