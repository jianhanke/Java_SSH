package two.study;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * �����࣬�ڴ˱�д֪ͨ
 * ������xml�����ļ�ȷ��֪ͨ����
 */
public class MyAspect {

	public void myBefore(JoinPoint joinPoint) {
		System.out.print("ǰ��֪ͨ ��Ŀ�꣺");
		System.out.print(joinPoint.getTarget() + ", �������ƣ�");
		System.out.println(joinPoint.getSignature().getName());
		
	}
	
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("����֪ͨ,�������ƣ�" + joinPoint.getSignature().getName());
	}

	public Object myAround(ProceedingJoinPoint proceedingJoinPoing) throws Throwable {
		System.out.println("ǰ���");
		Object object=proceedingJoinPoing.proceed();
		System.out.println("�����");
		return object;
	}

	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�쳣֪ͨ" + "������" + e.getMessage());
	}
	
	public void myAfter() {
		System.out.println("����֪ͨ");
	}
}
