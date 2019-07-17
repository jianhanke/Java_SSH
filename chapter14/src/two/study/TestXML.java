package cn.itcast.aspectj.xml;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.itcast.dao.UserDao;
public class TestXML {
	@Test
	public void demo01() {
		String xmlPath = "cn/itcast/aspectj/xml/applicationContext.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		// 1 ��spring�����������
		UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		// 2 ִ�з���
		userDao.save();
	
	}
}
