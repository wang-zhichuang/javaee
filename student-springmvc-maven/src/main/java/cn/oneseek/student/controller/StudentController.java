package cn.oneseek.student.controller;

import cn.oneseek.student.dao.BjMapper;
import cn.oneseek.student.dao.StudentMapper;
import cn.oneseek.student.entity.Bj;
import cn.oneseek.student.entity.Student;
import cn.oneseek.student.util.SqlSessionFactoryUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController  {

//	StudentDao studentDao = new StudentDao();
//	BjDao bjDao=new BjDao();
//	Reader reader;
//
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

	private SqlSession session= SqlSessionFactoryUtil.openSession();
	private StudentMapper studentDao = session.getMapper(StudentMapper.class);
	private BjMapper bjDao = session.getMapper(BjMapper.class);

	@RequestMapping("/list")
	public String list(Model model) {

//        List<Student> studentList = session.selectList("cn.oneseek.student.dao.StudentMapper.queryAll");
		try {
			List<Student> studentList = studentDao.queryAllWithBj();
			model.addAttribute("studentList",studentList);
			System.out.println(studentList);
			return "student/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/preadd")
	public String preadd(Model model) {

		try {

//			List<Bj> bjList=bjDao.queryAll();
			List<Bj> bjList = session.selectList("cn.oneseek.student.dao.BjMapper.queryAll");

			model.addAttribute("bjList",bjList);
			return "student/add";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/add")
	public String add(Student student,HttpServletResponse response) {

		try {

			studentDao.add(student);
//			session.insert("cn.oneseek.student.dao.StudentMapper.insertSelective",student);

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

		try {
//			Student student = studentDao.findStudentById(id);
			Student student = studentDao.selectByPrimaryKey(id);
			List<Bj> bjList=bjDao.queryAll();

//			Student student = session.selectOne("cn.oneseek.student.dao.StudentMapper.selectByPrimaryKey",id);
//			List<Bj> bjList = session.selectList("cn.oneseek.student.dao.BjMapper.queryAll");

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

		try {
//			studentDao.update(student);
			session.update("cn.oneseek.student.dao.StudentMapper.updateByPrimaryKeySelective",student);

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

		try {
			studentDao.deleteByPrimaryKey(id);
			List<Student> studentList = studentDao.queryAllWithBj();
//			session.delete("cn.oneseek.student.dao.BjMapper.deleteByPrimaryKey",id);
//			List<Student> studentList = session.selectList("cn.oneseek.student.dao.StudentMapper.queryAll");

			model.addAttribute("studentList", studentList);
			return "student/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
