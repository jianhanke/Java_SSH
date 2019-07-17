package two.study;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 切面类，在此编写通知
 * 可以在xml配置文件确定通知类型
 */
public class MyAspect {

	public void myBefore(JoinPoint joinPoint) {
		System.out.print("前置通知 ，目标：");
		System.out.print(joinPoint.getTarget() + ", 方法名称：");
		System.out.println(joinPoint.getSignature().getName());
		
	}
	
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("后置通知,方法名称：" + joinPoint.getSignature().getName());
	}

	public Object myAround(ProceedingJoinPoint proceedingJoinPoing) throws Throwable {
		System.out.println("前面的");
		Object object=proceedingJoinPoing.proceed();
		System.out.println("后面的");
		return object;
	}

	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("异常通知" + "出错了" + e.getMessage());
	}
	
	public void myAfter() {
		System.out.println("最终通知");
	}
}
