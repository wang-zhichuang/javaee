package actions;

import com.opensymphony.xwork2.ActionContext;
import dao.BjDao;
import vo.Bj;

import java.util.List;

public class BjAction {


    public String list(){

        BjDao bjDao=new BjDao();

        List<Bj> bjList= null;
        try {
            bjList = bjDao.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ActionContext.getContext().put("bjList", bjList);

        return "success";

    }
}
