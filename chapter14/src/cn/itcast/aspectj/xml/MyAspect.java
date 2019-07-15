package cn.itcast.aspectj.xml;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * 切面类，在此编写通知
 * 可以在xml配置文件确定通知类型
 */
public class MyAspect {
	// 前置通知
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("前置通知 ，目标：");
		System.out.print(joinPoint.getTarget() + ", 方法名称：");
		System.out.println(joinPoint.getSignature().getName());
	}
	// 后置通知
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("后置通知,方法名称：" + joinPoint.getSignature().getName());
	}

	public Object myAround(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		// 开始
		System.out.println("环绕开始");
		// 执行当前目标方法
		Object obj = proceedingJoinPoint.proceed();
		// 结束
		System.out.println("环绕结束");
		return obj;
	}
	// 异常通知
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("异常通知" + "出错了" + e.getMessage());
	}
	// 最终通知
	public void myAfter() {
		System.out.println("最终通知");
	}
}
