package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BjDao;
import dao.StudentDao;
import vo.Bj;
import vo.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentDao studentDao=new StudentDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action=request.getParameter("action");
		if("list".equals(action)){
			this.list(request,response);
		}else if("preadd".equals(action)){
			this.preadd(request,response);
		}
		else if("add".equals(action)){
			this.add(request,response);
		}else if("edit".equals(action)){
			this.edit(request,response);
		}else if("update".equals(action)){
			this.update(request,response);
		}else if("delete".equals(action)){
			this.delete(request,response);
		}


	}
	private void preadd(HttpServletRequest request, HttpServletResponse response) {


		BjDao bjDao=new BjDao();
		List<Bj> bjList;
		try {
			bjList = bjDao.queryAll();
			request.setAttribute("bjList", bjList);
			request.getRequestDispatcher("/student/add.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response){

		try {
			List<Student> studentList=studentDao.queryAll();
			request.setAttribute("studentList",studentList);
			request.getRequestDispatcher("/student/list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out=null;
		try {
			out=response.getWriter();
			Student student=new Student();
			student.setSno(request.getParameter("sno"));
			student.setSname(request.getParameter("sname"));
			student.setSex(request.getParameter("sex"));
			student.setBj(new Bj(Integer.parseInt(request.getParameter("bjid"))));
			studentDao.add(student);
			out.print("添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("数据库操作异常或学号重复！");
			e.printStackTrace();
		}
	}
	private void edit(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out=null;
		try {
			out=response.getWriter();
			Student student=studentDao.findStudentById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("student",student);

			BjDao bjDao=new BjDao();
			List<Bj> bjList=bjDao.queryAll();
			request.setAttribute("bjList", bjList);

			request.getRequestDispatcher("/student/edit.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("数据库操作异常或学号重复！");
			e.printStackTrace();
		}
	}
	private void update(HttpServletRequest request, HttpServletResponse response){
		PrintWriter out=null;
		try {out=response.getWriter();
			Student student=new Student();
			student.setId(Integer.parseInt(request.getParameter("id")));
			student.setSno(request.getParameter("sno"));
			student.setSname(request.getParameter("sname"));
			student.setSex(request.getParameter("sex"));
			student.setBj(new Bj(Integer.parseInt(request.getParameter("bjid"))));
			studentDao.update(student);
			out.print("修改成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.print("数据库操作异常或学号重复！");
			e.printStackTrace();
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response){

		try {
			studentDao.delete(Integer.parseInt(request.getParameter("id")));
			//request.getRequestDispatcher("/studentServlet?action=list").forward(request, response);
			List<Student> studentList=studentDao.queryAll();
			request.setAttribute("studentList",studentList);
			request.getRequestDispatcher("/student/list.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
