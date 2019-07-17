package cn.itcast.cglib;
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.itcast.dao.*;
import cn.itcast.jdk.MyAspect;


public class MyBeanFactory {
	
	public static BookDao getBean() {
		final BookDao bookDao=new BookDao();
		final MyAspect myAspect=new MyAspect();
		
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(bookDao.getClass());
		enhancer.setCallback(new MethodInterceptor() {
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodproxy) throws Throwable {
				myAspect.myBefore();
				Object obj=method.invoke(bookDao,args);
				myAspect.myAfter();
				System.out.println(obj+":");
				return obj;
			}	
		});
		BookDao bookDaoProxy=(BookDao) enhancer.create();
		return bookDaoProxy;
	}
}
