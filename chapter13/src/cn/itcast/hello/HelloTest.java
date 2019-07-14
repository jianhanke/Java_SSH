package cn.itcast.hello;




import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
	@Test
	public void hello() {
		String xmlPath="cn/itcast/hello/beans4.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		System.out.println(applicationcontext.getBean("hello"));
		System.out.println(applicationcontext.getBean("hello"));
		
	}
}
