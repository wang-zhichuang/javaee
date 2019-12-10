package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import dao.BjDao;
import dao.StudentDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.Bj;
import vo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/student")
public class StudentController {
    StudentDao studentDao = new StudentDao();

    @RequestMapping("/preadd")
    public void preadd(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html;charset=UTF-8");

        BjDao bjDao=new BjDao();
        List<Bj> bjList;
        try {
            bjList = bjDao.queryAll();
            request.setAttribute("bjList", bjList);
            request.getRequestDispatcher("/WEB-INF/student/add.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");

        try {
            List<Student> studentList=studentDao.queryAll();
            request.setAttribute("studentList",studentList);
            request.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

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
    @RequestMapping("/edit")
    public void edit(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

        try {
            out=response.getWriter();
            Student student=studentDao.findStudentById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("student",student);

            BjDao bjDao=new BjDao();
            List<Bj> bjList=bjDao.queryAll();
            request.setAttribute("bjList", bjList);

            request.getRequestDispatcher("/WEB-INF/student/edit.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            out.print("数据库操作异常或学号重复！");
            e.printStackTrace();
        }
    }

    @RequestMapping("/update")
    public void update(HttpServletRequest request, HttpServletResponse response){
        PrintWriter out=null;
        response.setContentType("text/html;charset=UTF-8");

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
    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");

        try {
            studentDao.delete(Integer.parseInt(request.getParameter("id")));
            //request.getRequestDispatcher("/studentServlet?action=list").forward(request, response);
            List<Student> studentList=studentDao.queryAll();
            request.setAttribute("studentList",studentList);
            request.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
