package two.study;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void addUser() {
		System.out.println(userDao);
		userDao.save();
		System.out.println("UserService");
	}
}
