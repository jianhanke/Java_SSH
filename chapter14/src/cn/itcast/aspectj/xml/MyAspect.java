package cn.itcast.aspectj.xml;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/*
 * �����࣬�ڴ˱�д֪ͨ
 * ������xml�����ļ�ȷ��֪ͨ����
 */
public class MyAspect {
	// ǰ��֪ͨ
	public void myBefore(JoinPoint joinPoint) {
		System.out.print("ǰ��֪ͨ ��Ŀ�꣺");
		System.out.print(joinPoint.getTarget() + ", �������ƣ�");
		System.out.println(joinPoint.getSignature().getName());
	}
	// ����֪ͨ
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.print("����֪ͨ,�������ƣ�" + joinPoint.getSignature().getName());
	}

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
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�쳣֪ͨ" + "������" + e.getMessage());
	}
	// ����֪ͨ
	public void myAfter() {
		System.out.println("����֪ͨ");
	}
}
