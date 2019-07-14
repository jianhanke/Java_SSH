package cn.itcast.instance.static_factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class InstanceTest2 {
	

	
	@Test
	public void demo2() {
		String xmlPath="cn/itcast/instance/static_factory/bean2.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(applicationcontext.getBean("bean2"));
		System.out.println(applicationcontext.getBean("bean2"));
	
	}
	
	
	
}
