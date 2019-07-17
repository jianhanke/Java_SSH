package two.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.itcast.dao.UserDao;
public class TestXML {
	
	
	public static void main(String[] args) {
		String xmlPath = "two/study/applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		
		userDao.save();
	
	}
}
