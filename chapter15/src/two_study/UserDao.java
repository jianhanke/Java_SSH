package two_study;

import java.util.List;

public interface UserDao {
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUserById(int id);
	public User findUserById(int i);
	public List<User> findAllUser();
}
