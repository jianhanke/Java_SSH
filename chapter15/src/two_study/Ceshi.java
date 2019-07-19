package two_study;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ceshi {
	
	@Test
	public void test1() {
		String xmlPath="two_study/jdbcTemplateBeans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDaoImpl");	
		User user=userDao.findUserById(2);
		System.out.println(user);
	}
	
}
