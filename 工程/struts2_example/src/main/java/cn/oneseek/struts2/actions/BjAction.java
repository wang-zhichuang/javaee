package cn.oneseek.struts2.actions;

import cn.oneseek.struts2.dao.BjDao;
import cn.oneseek.struts2.vo.Bj;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Namespace("/bj")
public class BjAction {
    String bjname,id;
    String ss;

    public String getSs() {
        return ss;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    public String getBjname() {
        return bjname;
    }

    public void setBjname(String bjname) {
        this.bjname = bjname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Action(value = "/bj/list",results = {
            @Result(name = "success",
                    location = "/bj/list.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String list(){

        BjDao bjDao=new BjDao();
        try {
            List<Bj> bjList=bjDao.queryAll();

            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("bjList", bjList);
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }

    }
    @Action(value = "/bj/add",results = {
            @Result(name = "success", location = "/bj/add.jsp"),
            @Result(name = "error", location = "error.jsp")
    })
    public String add(){
        BjDao bjDao=new BjDao();
        try {
            Bj bj=new Bj();
            bj.setBjname(bjname);
            bjDao.add(bj);
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("info","添加成功");
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }

    @Action(value = "/bj/edit",results = {
            @Result(name = "success",
                    location = "/bj/edit.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String edit(){
        BjDao bjDao=new BjDao();
        try {
            Bj bj=bjDao.findBjById(Integer.parseInt(id));
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("bj",bj);
            return "success";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }

    @Action(value = "/bj/update",results = {
            @Result(name = "success",
                    location = "/bj/edit.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String update(){
        BjDao bjDao=new BjDao();
        HttpServletRequest request = ServletActionContext.getRequest();

        try {
            Bj bj=new Bj();
            bj.setId(Integer.parseInt(id));
            bj.setBjname(bjname);
            bjDao.update(bj);
            request.setAttribute("info","修改成功");
        } catch (Exception e) {
            request.setAttribute("info","数据库操作异常或班级号重复！");
            e.printStackTrace();
        }
        return "success";

    }

    @Action(value = "/bj/delete",results = {
            @Result(name = "success",
                    location = "/bj/list.jsp"),
            @Result(name = "error", location = "error.jsp"),
    })
    public String delete(){
        BjDao bjDao=new BjDao();
        HttpServletRequest request = ServletActionContext.getRequest();
        try {
            bjDao.delete(Integer.parseInt(id));
            List<Bj> bjList=bjDao.queryAll();
            request.setAttribute("bjList",bjList);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "success";
    }
    @Action("/ss")
    public void ss(){
        System.out.println(ss);

    }
}
