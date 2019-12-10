package action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import dao.BjDao;
import vo.Bj;


@Namespace(value="/bj")
@Result(name="error",location="/error.jsp")
public class BjAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
    BjDao bjDao=new BjDao();
    List<Bj> bjList;
    String info;
    Bj bj;
    int id;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bj getBj() {
		return bj;
	}

	public void setBj(Bj bj) {
		this.bj = bj;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Bj> getBjList() {
		return bjList;
	}

	public void setBjList(List<Bj> bjList) {
		this.bjList = bjList;
	}

	public BjAction() {
		
        super();
        
    }

	@Action(value="list",results={
	@Result(name="success",location="/bj/list.jsp")	
	})
	public String list() {		
		
			try {
				bjList=bjDao.queryAll();
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
			
		
	}
	@Action(value="add",results={
		@Result(name="success",location="/bj/add.jsp")		
	}) 
	public String add(){
	
		try {
			bjDao.add(bj);
			info="添加成功";
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@Action(value="edit",results={
			@Result(name="success",location="/bj/edit.jsp")			
		}) 
	public String edit(){
		
		try {
			bj=bjDao.findBjById(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	@Action(value="update",results={
			@Result(name="success",location="/bj/edit.jsp")			
	}) 
	public String update(){		
		try {			
			
			bjDao.update(bj);
			info="修改成功";
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	@Action(value="delete",results={
		@Result(name="success",location="/bj/list.action" ,type="redirect")			 
	}) 
	public String delete(){
		try {
			bjDao.delete(id);	
			return "success";		
					
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	

}
