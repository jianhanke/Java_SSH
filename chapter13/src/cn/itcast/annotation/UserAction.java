package cn.itcast.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("userAction")
public class UserAction {
	
	@Resource(name="userService")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService=userService;
	}
	
	public void save() {
		this.userService.save();
		System.out.println("userAction...save...");
	}
	
}
