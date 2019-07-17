package cn;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect2 {
	
	@Pointcut("execution(* cn.itcast.dao..*.*(..))")
	private void myPointCut() {};
	
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("前置通知 ，目标：");
		System.out.print(joinPoint.getTarget() + ", 方法名称：");
		System.out.println(joinPoint.getSignature().getName());
		
	}
	@AfterReturning(value="myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("后置通知,方法名称：" + joinPoint.getSignature().getName());
	}
	
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoing) throws Throwable {
		System.out.println("前面的");
		Object object=proceedingJoinPoing.proceed();
		System.out.println("后面的");
		return object;
	}
	@AfterThrowing(value="myPointCut()",throwing="e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("异常通知" + "出错了" + e.getMessage());
	}
	@After("myPointCut()")
	public void myAfter() {
		System.out.println("最终通知");
	}
}
