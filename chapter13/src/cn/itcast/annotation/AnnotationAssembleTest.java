package cn.itcast.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAssembleTest {
	
	@Test
	public void annotation() {
	String xmlPath="cn/itcast/annotation/beans6.xml";
	ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
	UserAction userAction=(UserAction) applicationcontext.getBean("userAction");
	System.out.println(userAction);
	userAction.save();
	}
}
