package two.study;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("userAction")
public class UserAction {
	@Resource(name="userService")
	private UserService userService2;
	
	public void setUserService(UserService userService ) {
		this.userService2=userService;
	}
	public void save() {
		userService2.save();
		System.out.println("ÈýÈý");
	}
}
