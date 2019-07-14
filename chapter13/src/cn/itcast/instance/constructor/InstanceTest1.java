package cn.itcast.instance.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest1 {
	
	@Test
	public void demo01() {
		String xmlPath="cn/itcast/instance/constructor/beans1.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(applicationcontext.getBean("bean1"));
		System.out.println(applicationcontext.getBean("bean1"));
	}
}
