package cn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/applicationcontext.xml")
public class Ceshi {
	
	@Autowired
	private UserDao userDao;
	
	@Test
	public void test4() {
		userDao.save();
	}

	
}
