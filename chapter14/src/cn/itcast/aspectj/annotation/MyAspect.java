package cn.itcast.aspectj.annotation;
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
/*
 * �����࣬�ڴ˱�д֪ͨ
 * ����ע��ʵ��AOP���
 */
@Aspect
@Component
public class MyAspect {
	
	@Pointcut("execution(* cn.itcast.dao..*.*(..))")
	private void myPointCut() {}

	// ǰ��֪ͨ
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("ǰ��֪ͨ �� Ŀ�꣺");
		System.out.print(joinPoint.getTarget() + ", �������ƣ�");
		System.out.println(joinPoint.getSignature().getName());
	}

	// ����֪ͨ
	@AfterReturning(value = "myPointCut()")
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("����֪ͨ" + joinPoint.getSignature().getName());
	}

	// ����֪ͨ
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		// ��ʼ
		System.out.println("���ƿ�ʼ");
		// ִ�е�ǰĿ�귽��
		Object obj = proceedingJoinPoint.proceed();
		// ����
		System.out.println("���ƽ���");
		return obj;
	}

	// �쳣֪ͨ
	@AfterThrowing(value = "myPointCut()", throwing = "e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�쳣֪ͨ��������" + e.getMessage());
	}

	// ����֪ͨ
	@After("myPointCut()")
	public void myAfter() {
		System.out.println("����֪ͨ");
	}
}
