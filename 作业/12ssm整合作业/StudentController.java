package controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.BjDao;
import dao.StudentDao;
import service.BjService;
import service.StudentService;
import vo.Bj;
import vo.Student;



@Controller
@RequestMapping("/student")
public class StudentController  {
    @Resource(name="studentService")
    StudentService studentService;

    @Resource(name = "bjService")
    BjService bjService;

	@RequestMapping("/list")
	public String list(Model model) {

		try {
			List<Student> studentList = studentService.queryAll();
			model.addAttribute("studentList",studentList);
			return "student/list";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@RequestMapping("/preadd")
	public String preadd(Model model) {

		try {

			List<Bj> bjList=bjService.queryAll();
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

			studentService.add(student);

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
			Student student = studentService.findById(id);
			List<Bj> bjList=bjService.queryAll();
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
			studentService.update(student);

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
			studentService.delete(id);
			List<Student> studentList = studentService.queryAll();
			model.addAttribute("studentList", studentList);
			return "student/list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
