package i18n.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute(){
		if(getUsername().equals("ckg")&& getPassword().equals("0304180216")){
			
			//调包范围资源文件
			ActionContext.getContext().put("tip", this.getText("succTip"));
			return SUCCESS;
		}
		ActionContext.getContext().put("tip", this.getText("failTip"));
		return ERROR;
	}

}
