package cn.itcast.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public void save() {
		this.userDao.save();
		System.out.println("userservice...save....");
		
	}
	
}
