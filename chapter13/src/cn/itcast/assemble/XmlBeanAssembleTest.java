package cn.itcast.assemble;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanAssembleTest {

	@Test
	public void xmlAssembleTest() {
		String xmlPath="cn/itcast/assemble/beans5.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(applicationcontext.getBean("user1"));
		System.out.println(applicationcontext.getBean("user1"));
		System.out.println(applicationcontext.getBean("user2"));
		System.out.println(applicationcontext.getBean("user2"));
	}
	
}

