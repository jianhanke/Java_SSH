package cn.itcast.instance.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanceTest3 {
	
	@Test
	public void demo3() {
	String xmlPath="cn/itcast/instance/factory/bean3.xml";
	ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
	System.out.println(applicationcontext.getBean("bean3"));
	System.out.println(applicationcontext.getBean("bean3"));
	}
}
