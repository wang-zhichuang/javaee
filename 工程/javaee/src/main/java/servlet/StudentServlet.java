package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import vo.Bj;
import vo.Student;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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

        String action=request.getParameter("action");
        if("list".equals(action)){
            this.list(request,response);
        }else if("add".equals(action)){
            this.add(request,response);
        }else if("edit".equals(action)){
            this.edit(request,response);
        }else if("update".equals(action)){
            this.update(request,response);
        }else if("delete".equals(action)){
            this.delete(request,response);
        }


    }
    private void list(HttpServletRequest request, HttpServletResponse response){
        StudentDao studentDao=new StudentDao();
        try {
            List<Student> studentList = studentDao.queryAll();
            request.setAttribute("studentList",studentList);
            request.getRequestDispatcher("/student/list.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response){
        StudentDao studentDao=new StudentDao();
        try {
            Student student=new Student();
            student.setSname(request.getParameter("student_name"));
            Bj bj = new Bj();
            bj.setBjname(request.getParameter("student_bj_id"));
            bj.setId(Integer.parseInt(request.getParameter("student_bj_id")));
            student.setBj(bj);

            student.setSno(request.getParameter("student_no"));
            student.setSex(request.getParameter("student_sex"));
            studentDao.add(student);
            request.setAttribute("info","添加成功");
            request.getRequestDispatcher("/student/add.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void edit(HttpServletRequest request, HttpServletResponse response){
        StudentDao studentDao=new StudentDao();
        try {
            Student student = studentDao.findStudentById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("student",student);
            request.getRequestDispatcher("/student/edit.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void update(HttpServletRequest request, HttpServletResponse response) {
        StudentDao studentDao=new StudentDao();
        try {
            Student student=new Student();
            student.setId(Integer.parseInt(request.getParameter("student_id")));
            student.setSno(request.getParameter("student_no"));
            student.setSname(request.getParameter("student_name"));
            student.setSex(request.getParameter("student_sex"));

            Bj bj = new Bj();
            bj.setId(Integer.parseInt(request.getParameter("student_bj_id")));
            bj.setBjname(request.getParameter("student_bj_id"));
            student.setBj(bj);

            studentDao.update(student);
            request.setAttribute("info","修改成功");
            request.getRequestDispatcher("/student/edit.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void delete(HttpServletRequest request, HttpServletResponse response){
        StudentDao StudentDao=new StudentDao();
        try {
            StudentDao.delete(Integer.parseInt(request.getParameter("id")));
            request.getRequestDispatcher("/studentServlet?action=list").forward(request, response);
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
