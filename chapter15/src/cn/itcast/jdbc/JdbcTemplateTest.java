package cn.itcast.jdbc;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import two_study.User;
import two_study.UserDao;

public class JdbcTemplateTest {
	
	@Test
	public void createTableTest() {
	String xmlPath="cn/itcast/jdbc/JdbcTemplateBeans.xml";
	ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
	JdbcTemplate jdTemplate=(JdbcTemplate) applicationcontext.getBean("jdbcTemplate");
	jdTemplate.execute("create table t_user("+
						"userid int primary key auto_increment,"+
			            "username varchar(50),"+
						"password varchar(32))"
			);
	}						
	
	@Test
	public void addUserTest() {
		String xmlPath="cn/itcast/jdbc/JdbcTemplateBeans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDao");
		User user=new User();
		user.setUsername("jack");
		user.setPassword("1234");
		int flag=userDao.addUser(user);
		if(flag==1) {
			System.out.println("添加用户成功");
		}else {
			System.out.println("添加用户失败");
		}
		
	}
	@Test
	public void updateUserTest() {
		String xmlPath="cn/itcast/jdbc/JdbcTemplateBeans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDao");
		User user=new User();
		user.setUserid(1);
		user.setUsername("tom");
		user.setPassword("1234");
		int flag=userDao.updateUser(user);
		if(flag==1) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	@Test
	public void deleteUserTest() {
		String xmlPath="cn/itcast/jdbc/JdbcTemplateBeans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDao");
		int flag=userDao.deleteUserById(1);
		if(flag==1) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	@Test
	public void findUserByIdTest() {
		String xmlPath="cn/itcast/jdbc/JdbcTemplateBeans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDao");	
		User user=userDao.findUserById(2);
		System.out.println(user);

	}
	@Test
	public void findAllUserTest() {
		String xmlPath="cn/itcast/jdbc/JdbcTemplateBeans.xml";
		ApplicationContext applicationcontext=new ClassPathXmlApplicationContext(xmlPath);
		UserDao userDao=(UserDao) applicationcontext.getBean("userDao");
		List<User>list=userDao.findAllUser();
		for(User u:list) {
			System.out.println(u);
		}
	}
	
	
	
	
}
