package cn.itcast.jdk;

import org.junit.Test;

import cn.itcast.dao.UserDao;

public class TestJDK {
	
	@Test
	public void demo01() {
		UserDao userDao=MyBeanFactory.getBean();
		userDao.save();
		userDao.update();
		userDao.delete();
		userDao.find();
	}
}
