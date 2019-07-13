package cn.itcast.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestApp {
	
	@Test
	public void demo01(){
		String xmlPath="applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao=(UserDao) applicationcontext.getBean("userDao");
		userDao.save();
	}
	@Test
	public void demo02() {
		String xmlPath="applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserService userService=(UserService) applicationcontext.getBean("userService");
		userService.addUser();
	}
}
