package cn.itcast.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.itcast.service.AccountService;

public class Test {
	public static void main(String[] args) {
		
		String xmlPath = "applicationContextxml2.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
		AccountService accountService = (AccountService) applicationContext.getBean("accountService");
		accountService.transfer("jack", "rose", 100);
		System.out.println("ok");	

	}
	
}
