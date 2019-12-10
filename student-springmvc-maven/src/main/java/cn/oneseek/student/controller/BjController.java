package cn.oneseek.student.controller;

import cn.oneseek.student.dao.BjMapper;
import cn.oneseek.student.entity.Bj;
import cn.oneseek.student.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Controller
@RequestMapping("/bj")
public class BjController  {
//    BjDao bjDao=new BjDao();
//    Reader reader;
//    {
//        try {
//            reader = Resources.getResourceAsReader("mybatis-config.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
//    SqlSession session = sessionFactory.openSession();




	@RequestMapping("/list")
	public String list(Model model) {
        SqlSession session=SqlSessionFactoryUtil.openSession();
        BjMapper bjDao = session.getMapper(BjMapper.class);

//        List<Bj> bjList=bjDao.queryAll();
//        List<Bj> bjList = session.selectList("cn.oneseek.student.dao.BjMapper.queryAll");
		List<Bj> bjList = bjDao.queryAll();
		session.close();
		try {
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
        SqlSession session=SqlSessionFactoryUtil.openSession();
        BjMapper bjDao = session.getMapper(BjMapper.class);


        try {
			bjDao.insert(bj);
            session.close();
//			session.insert("cn.oneseek.student.dao.BjMapper.insertSelective",bj);
			model.addAttribute("info", "添加成功");
			return "bj/add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/edit")
	public String edit(int id,Model model){
        SqlSession session=SqlSessionFactoryUtil.openSession();
        BjMapper bjDao = session.getMapper(BjMapper.class);

		try {
//			Bj bj = bjDao.findBjById(id);
			Bj bj = bjDao.findById(id);
            session.close();
//			Bj bj = session.selectOne("cn.oneseek.student.dao.BjMapper.selectByPrimaryKey",id);
			model.addAttribute("bj", bj);
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}
	@RequestMapping("/update")
	public String update(Bj bj,Model model){
        SqlSession session=SqlSessionFactoryUtil.openSession();
        BjMapper bjDao = session.getMapper(BjMapper.class);

        try {

//			bjDao.update(bj);
			bjDao.updateByPrimaryKeySelective(bj);
			session.update("cn.oneseek.student.dao.BjMapper.updateByPrimaryKeySelective",bj);
            session.close();
			model.addAttribute("info", "更新成功");
			return "bj/edit";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id){
        SqlSession session=SqlSessionFactoryUtil.openSession();
        BjMapper bjDao = session.getMapper(BjMapper.class);

        try {
//			bjDao.delete(id);
			bjDao.deleteByPrimaryKey(id);
//			session.delete("cn.oneseek.student.dao.BjMapper.deleteByPrimaryKey",id);
            session.close();
            return "redirect:/bj/list.do";

		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}



}
