package two_study;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ceshi {
	
	@Test
	public void test1() {
		String xmlPath="two_study/applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		Bean2 bean2=(Bean2) applicationcontext.getBean("bean2");
		System.out.println(bean2);
		Bean2 bean3=(Bean2) applicationcontext.getBean("bean2");
		System.out.println(bean3);
	}
	@Test
	public void test2() {
		String xmlPath="two_study/applicationContext.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		Bean3 bean3=(Bean3) applicationcontext.getBean("bean3");
		System.out.println(bean3);
		Bean3 bean4=(Bean3) applicationcontext.getBean("bean3");
		System.out.println(bean4);
	}
	
}
