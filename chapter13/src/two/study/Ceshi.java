package two.study;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ceshi {
	
	@Test
	public void test1() {
		String xmlPath="two/study/applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserAction userAction=(UserAction) applicationcontext.getBean("userAction");
		userAction.save();
	}
}
