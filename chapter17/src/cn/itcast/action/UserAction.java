package cn.itcast.action;



import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserAction extends ActionSupport  implements ModelDriven<User> {
	
	private User user=new User();
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService  userService) {
		this.userService=userService;
	}
	
	public String add() {
		this.userService.saveUser(user);
		return "add";
	}
	
}
