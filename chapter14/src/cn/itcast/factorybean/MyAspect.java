package cn.itcast.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor{
	
	public Object invoke(MethodInvocation mi)throws Throwable{
		System.out.println("方法执行前");
		Object obj=mi.proceed();
		System.out.println("方法执行后");
		return obj;
	}


	
}
