package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;

public class LoginAction2 extends ActionSupport implements ModelDriven<User> {
	private User user=new User();
	
	@Override
	public User getModel() {
		return user;
	}
	
	public String execute()throws Exception{
		return "success";
		
	}
	
}
