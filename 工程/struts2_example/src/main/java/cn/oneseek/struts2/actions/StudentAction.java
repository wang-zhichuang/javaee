package cn.oneseek.struts2.actions;

import cn.oneseek.struts2.dao.BjDao;
import cn.oneseek.struts2.dao.StudentDao;
import cn.oneseek.struts2.vo.Bj;
import cn.oneseek.struts2.vo.Student;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Namespace(value = "/student")
public class StudentAction {
    String sno,sname,sex,bjid,id;
    StudentDao studentDao=new StudentDao();

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBjid() {
        return bjid;
    }

    public void setBjid(String bjid) {
        this.bjid = bjid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Action(value = "/student/list", results = {
            @Result(name = "success",
                    location = "/student/list.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String list(){
        try {
            List<Student> studentList=studentDao.queryAll();
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("studentList",studentList);
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }
    @Action(value = "/student/preadd", results = {
            @Result(name = "success",
                    location = "/student/add.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String preadd() {
        BjDao bjDao=new BjDao();
        List<Bj> bjList;
        try {
            bjList = bjDao.queryAll();
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("bjList", bjList);
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }
    @Action(value = "/student/add", results = {
            @Result(name = "success",
                    location = "/student/add.jsp"),
    })
    public String add(){
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            Student student=new Student();
            student.setSno(sno);
            student.setSname(sname);
            student.setSex(sex);
            student.setBj(new Bj(Integer.parseInt(bjid)));
            studentDao.add(student);
            request.setAttribute("info","添加成功");
            BjDao bjDao=new BjDao();
            List<Bj> bjList = bjDao.queryAll();
            request.setAttribute("bjList", bjList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            request.setAttribute("info","数据库操作异常或学号重复！");
            e.printStackTrace();
        }
        return "success";
    }

    @Action(value = "/student/edit", results = {
            @Result(name = "success",
                    location = "/student/edit.jsp"),
    })
    public String edit(){
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            Student student=studentDao.findStudentById(Integer.parseInt(id));
            request.setAttribute("student",student);

            BjDao bjDao=new BjDao();
            List<Bj> bjList=bjDao.queryAll();
            request.setAttribute("bjList", bjList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            request.setAttribute("info","数据库操作异常或学号重复！");
            e.printStackTrace();
        }
        return "success";
    }

    @Action(value = "/student/update", results = {
            @Result(name = "success",
                    location = "/student/edit.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String update(){
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            Student student=new Student();
            student.setId(Integer.parseInt(id));
            student.setSno(sno);
            student.setSname(sname);
            student.setSex(sex);
            student.setBj(new Bj(Integer.parseInt(bjid)));
            studentDao.update(student);
            request.setAttribute("info","修改成功");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            request.setAttribute("info","数据库操作异常或学号重复！");
            e.printStackTrace();
        }
        return "success";
    }

    @Action(value = "/student/delete", results = {
            @Result(name = "success",
                    location = "/student/list.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String delete(){
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            studentDao.delete(Integer.parseInt(id));
            //request.getRequestDispatcher("/studentServlet?action=list").forward(request, response);
            List<Student> studentList=studentDao.queryAll();
            request.setAttribute("studentList",studentList);
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }
}
