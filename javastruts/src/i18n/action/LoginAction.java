package i18n.action;

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
		if(getUsername().equals("ascent")&& getPassword().equals("ascent")){
			ActionContext.getContext().getSession().put("user", this.getUsername());
			return SUCCESS;
		}
		return INPUT;
	}
	//完成输入校验需要重写的validate方法（读取资源文件getText(String str)）
	public void validate(){
                        //调用getText方法取出国际化信息
		if(getUsername()==null||"".equals(this.getUsername().trim())){
			this.addFieldError("username", this.getText("username.required"));
		}
		if(this.getPassword()==null||"".equals(this.getPassword().trim())){
			this.addFieldError("password", this.getText("password.required"));
		}
	}
	
}
