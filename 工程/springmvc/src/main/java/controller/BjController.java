package controller;

import dao.BjDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import vo.Bj;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
@RequestMapping("bj")
public class BjController {

    private static final long serialVersionUID = 1L;
    BjDao bjDao=new BjDao();

    @RequestMapping("/list")
    public void list(HttpServletRequest request, HttpServletResponse response){

        try {
            List<Bj> bjList=bjDao.queryAll();
            request.setAttribute("bjList",bjList);
            request.getRequestDispatcher("/WEB-INF/bj/list.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        try {
            out=response.getWriter();
            Bj bj=new Bj();
            bj.setBjname(request.getParameter("bjname"));
            bjDao.add(bj);
            request.setAttribute("info","添加成功");
            request.getRequestDispatcher("/WEB-INF/bj/add.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            out.print("数据库操作异常或班级名称重复！");
            e.printStackTrace();
        }
    }

    @RequestMapping("/edit")
    public void edit(HttpServletRequest request, HttpServletResponse response){

        try {
            Bj bj=bjDao.findBjById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("bj",bj);
            request.getRequestDispatcher("/WEB-INF/bj/edit.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/update")
    public void update(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        try {
            out=response.getWriter();
            Bj bj=new Bj();
            bj.setId(Integer.parseInt(request.getParameter("id")));
            bj.setBjname(request.getParameter("bjname"));
            bjDao.update(bj);
            request.setAttribute("info","修改成功");
            request.getRequestDispatcher("/WEB-INF/bj/edit.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            out.print("数据库操作异常或班级名称重复！");
            e.printStackTrace();
        }
    }

    @RequestMapping("/delete")
    public void delete(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        try {
            out=response.getWriter();
            int id=Integer.parseInt(request.getParameter("id"));
            bjDao.delete(id);
            //response.sendRedirect(request.getContextPath()+"/bjServlet?action=list");
            List<Bj> bjList=bjDao.queryAll();
            request.setAttribute("bjList",bjList);
            request.getRequestDispatcher("/WEB-INF/bj/list.jsp").forward(request, response);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            out.print("数据库操作异常或班级还有学生记录不能删除！");
            e.printStackTrace();
        }
    }

    @RequestMapping("/add_jsp")
    public void add_jsp(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/WEB-INF/bj/add.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
