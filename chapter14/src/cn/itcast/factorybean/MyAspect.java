package cn.itcast.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;

public class MyAspect implements MethodInterceptor{
	
	
	public Object invoke(MethodInvocation mi)throws Throwable{
		System.out.println("����ִ��ǰ");
		Object obj=mi.proceed();
		System.out.println("����ִ�к�");
		return obj;
	}


	
}
