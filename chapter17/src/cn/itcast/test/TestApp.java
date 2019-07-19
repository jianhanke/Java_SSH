package cn.itcast.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class TestApp {
	
	
	@Test
	public void demo01() {
		User user=new User();
		user.setUsername("jack");
		user.setPassword("1234");
		String xmlPath="applicationContext.xml";
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext(xmlPath);
		UserService userService=applicationContext.getBean("userService",UserService.class);
		userService.saveUser(user);
	}
}
