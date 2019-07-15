package cn.itcast.cglib;

import org.junit.Test;

import cn.itcast.dao.BookDao;

public class TestCGLIB {

	@Test
	public void demo01() {
		BookDao bookDao=MyBeanFactory.getBean();
		bookDao.save();
		bookDao.delete();
		bookDao.update();
		bookDao.find();
	}
}
