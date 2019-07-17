package two.study;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ceshi {
	
	@Test
	public void test1() {
		String xmlPath="two/study/applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDaoImpl");
		UserDao userDao2=(UserDao) applicationcontext.getBean("userDaoImpl");
		userDao.save();
	}
	@Test
	public void test2() {
		String xmlPath="two/study/applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserService userService=(UserService) applicationcontext.getBean("userServiceImpl");
		UserDao userDao=(UserDao) applicationcontext.getBean("userDaoImpl");
		userService.addUser();
	}
	
}
