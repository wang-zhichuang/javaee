package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.BjDao;
import dao.StudentDao;
import vo.Bj;
import vo.Student;

/**
 * Servlet implementation class StudentServlet
 */

@Namespace(value = "/student")
@Result(name = "error", location = "/error.jsp")
public class StudentAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	StudentDao studentDao = new StudentDao();

	Student student;
	int id;
	List<Student> studentList;
	List<Bj> bjList;
	String info;
	BjDao bjDao=new BjDao();

	public StudentAction() {
		
		
	}
    public void out(String message) {
    	HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out=response.getWriter();
			out.print(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Bj> getBjList() {
		return bjList;
	}
	public void setBjList(List<Bj> bjList) {
		this.bjList = bjList;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	

	@Action(value = "list", results = { @Result(name = "success", location = "/student/list.jsp") })
	public String list() {

		try {
			studentList = studentDao.queryAll();
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	@Action(value = "preadd", results = { @Result(name = "success", location = "/student/add.jsp") })
	public String preadd() {

		try {

			bjList=bjDao.queryAll();			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@Action(value = "add", results = { @Result(name = "success", location = "/student/add.jsp") })
	public String add() {

		try {

			studentDao.add(student);
			
			this.out("添加成功");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@Action(value = "edit", results = { @Result(name = "success", location = "/student/edit.jsp") })
	public String edit() {

		try {
			student = studentDao.findStudentById(id);
			bjList=bjDao.queryAll();	
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	@Action(value = "update", results = { @Result(name = "success", location = "/student/edit.jsp") })
	public String update() {

		try {
			studentDao.update(student);
			this.out("修改成功");
			return  null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	@Action(value = "delete", results = { @Result(name = "success", location = "/student/list.jsp") })
	public String delete() {

		try {
			studentDao.delete(id);
			studentList = studentDao.queryAll();
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

}
