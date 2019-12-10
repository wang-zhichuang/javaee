package controller;

import dao.CourseMapper;
import entity.Course;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.SqlSessionFactoryUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class MainController {

    @RequestMapping("/courseQuery")
    public void query(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        SqlSession session= SqlSessionFactoryUtil.openSession();

        CourseMapper  courseDao = session.getMapper(CourseMapper.class);

        request.setCharacterEncoding("UTF-8");

//        String condition=" where 1=1 ";
        String kcm=request.getParameter("kcm");
//        if(kcm!=null&&!"".equals(kcm.trim())) {
//            condition+= " and kcm like '%"+kcm+"%' ";
//        }
//
        String sksj=request.getParameter("sksj");
//        if(sksj!=null&&!"".equals(sksj.trim())) {
//            condition+= " and sksj like '%"+sksj+"%' ";
//        }
        String skdd=request.getParameter("skdd");
//        if(skdd!=null&&!"".equals(skdd.trim())) {
//            condition+= " and skdd like '%"+skdd+"%' ";
//        }
        String rkjs1=request.getParameter("rkjs1");
//        if(rkjs1!=null&&!"".equals(rkjs1.trim())) {
//            condition+= " and rkjs1 like '%"+rkjs1+"%' ";
//        }

        int pageNo = 1;
        try {
            pageNo = Integer.parseInt(request.getParameter("pageNo"));
        } catch (NumberFormatException e) {

        }
        int pageSize = 10;
        try {
            Map map = new HashMap<>();
            int recordCount=courseDao.recordCount(map);
            int pageCount=recordCount%pageSize==0?recordCount/pageSize:recordCount/pageSize+1;

//            Map<String,String> map = new HashMap<>();
//            map.put("condition",condition);

            int startPage = pageSize*(pageNo-1);
            System.out.println(startPage);
            map.put("startPage",startPage);
            map.put("pageSize",pageSize);
            map.put("kcm",kcm);
            map.put("sksj",sksj);
            map.put("skdd",skdd);
            map.put("rkjs1",rkjs1);

            List<Course> courseList=courseDao.queryByPageNo(map);
            request.setAttribute("recordCount",recordCount);

            request.setAttribute("pageCount",pageCount);
            request.setAttribute("pageNo", pageNo);
            request.setAttribute("courseList",courseList);
            request.getRequestDispatcher("/courseList.jsp").forward(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        session.close();
    }
}
