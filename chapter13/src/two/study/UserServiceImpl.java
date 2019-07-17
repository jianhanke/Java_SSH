package two.study;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao2")
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public void save() {
		userDao.save();
		System.out.println("第二个个");
	}
}
