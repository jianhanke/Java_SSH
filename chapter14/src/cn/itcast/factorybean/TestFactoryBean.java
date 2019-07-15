package cn.itcast.factorybean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.dao.UserDao;

public class TestFactoryBean {
	
	@Test
	public void demo01() {
		String xmlPath="cn/itcast/factorybean/applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDaoProxy");
		userDao.save();
		userDao.update();
		userDao.delete();
		userDao.find();
		
	}
}
