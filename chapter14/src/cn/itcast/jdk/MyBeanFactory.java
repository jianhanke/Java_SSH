package cn.itcast.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoImpl;

public class MyBeanFactory {

	
	public static UserDao getBean() {
		final UserDao userDao=new UserDaoImpl();
		final MyAspect myAspect=new MyAspect();
		
		return (UserDao) Proxy.newProxyInstance(MyBeanFactory.class.getClassLoader(), new Class[] {UserDao.class}, 
				
				new InvocationHandler() {
			public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
				myAspect.myBefore();
				Object obj=method.invoke(userDao, args);
				myAspect.myAfter();;
				return obj;
			}
		}); 
		
			
	}
}
