package controller;


import dao.CourseDao;
import entity.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@Controller

public class MainController {

    @RequestMapping("/courseQuery")
    public void query(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        CourseDao courseDao = new CourseDao();

        request.setCharacterEncoding("UTF-8");
        String condition=" where 1=1 ";
        String kcm=request.getParameter("kcm");
        if(kcm!=null&&!"".equals(kcm.trim())) {
            condition+= " and kcm like '%"+kcm+"%' ";
        }

        String sksj=request.getParameter("sksj");
        if(sksj!=null&&!"".equals(sksj.trim())) {
            condition+= " and sksj like '%"+sksj+"%' ";
        }
        String skdd=request.getParameter("skdd");
        if(skdd!=null&&!"".equals(skdd.trim())) {
            condition+= " and skdd like '%"+skdd+"%' ";
        }
        String rkjs1=request.getParameter("rkjs1");
        if(rkjs1!=null&&!"".equals(rkjs1.trim())) {
            condition+= " and rkjs1 like '%"+rkjs1+"%' ";
        }

        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        } catch (NumberFormatException e) {

        }
        int pageSize = 10;
        try {
            int recordCount=courseDao.recordCount(condition);
            int pageCount=recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1;
            List<Course> courseList=courseDao.queryByPageNo(condition, pageNo, pageSize);
            request.setAttribute("recordCount",recordCount);

            request.setAttribute("pageCount",pageCount);
            request.setAttribute("pageNo", pageNo);
            request.setAttribute("courseList",courseList);
            request.getRequestDispatcher("/courseList.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
