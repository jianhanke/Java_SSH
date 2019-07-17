package two.study;

import org.springframework.stereotype.Repository;

@Repository("userDao2")
public class UserDaoImpl implements UserDao {
	
	
	
	public void save() {
		System.out.println("µÚÒ»¸ösave");
	}
}
