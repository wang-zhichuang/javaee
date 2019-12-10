package controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BjDao;
import dao.StudentDao;
import util.SqlSessionFactoryUtil;
import vo.Bj;
import vo.Student;



@Controller
@RequestMapping("/student")
public class StudentController  {
	 

	@RequestMapping("/list")
	public String list(Model model) {
		SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		StudentDao studentDao=sqlSession.getMapper(StudentDao.class);	
		try {
			List<Student> studentList = studentDao.queryAll();
			sqlSession.close();
			model.addAttribute("studentList",studentList);
			return "student/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/preadd")
	public String preadd(Model model) {
		SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		BjDao bjDao=sqlSession.getMapper(BjDao.class);	
		try {

			List<Bj> bjList=bjDao.queryAll();		
			sqlSession.close();		
			model.addAttribute("bjList",bjList);
			return "student/add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/add")
	public String add(Student student,HttpServletResponse response) {
		SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		StudentDao studentDao=sqlSession.getMapper(StudentDao.class);	
		try {

			studentDao.add(student);
			sqlSession.commit();
			sqlSession.close();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("添加成功");
			return null;
		 } catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping("/edit")
	public String edit(int id,Model model) {
		SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		StudentDao studentDao=sqlSession.getMapper(StudentDao.class);	
		BjDao bjDao=sqlSession.getMapper(BjDao.class);
		try {
			Student student = studentDao.findById(id);
			List<Bj> bjList=bjDao.queryAll();
			sqlSession.close();
			model.addAttribute("student",student);
			model.addAttribute("bjList",bjList);
			return "student/edit";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping("/update")
	public String update(Student student,HttpServletResponse response) {
		SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		StudentDao studentDao=sqlSession.getMapper(StudentDao.class);	
		try {
			studentDao.update(student);
			sqlSession.commit();
			sqlSession.close();
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.print("更新成功");
			return  null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping("/delete")
	public String delete(int id,Model model) {
		SqlSession sqlSession=SqlSessionFactoryUtil.openSession();
		StudentDao studentDao=sqlSession.getMapper(StudentDao.class);	
		try {
			studentDao.delete(id);
			List<Student> studentList = studentDao.queryAll();
			sqlSession.commit();
			sqlSession.close();
			model.addAttribute("studentList", studentList);
			return "student/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
