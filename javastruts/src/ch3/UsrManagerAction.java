package ch3;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class UsrManagerAction extends ActionSupport {
    public String findAll() throws Exception{
        UsrDao dao = new UsrDao();
        List<User> list=dao.findAllUser();
        ActionContext.getContext().put("allUser",list);
        return "anli_showuser";
    }
}
