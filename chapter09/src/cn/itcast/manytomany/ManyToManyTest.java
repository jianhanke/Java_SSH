package cn.itcast.manytomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import cn.itcast.utils.HibernateUtils;
public class ManyToManyTest {
	@Test
	public void test1() {
		Session session = HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		
		Student s1 = new Student();
		s1.setSname("����");
		Student s2 = new Student();
		s2.setSname("����");

		Course c1 = new Course();
	    c1.setCname("Java");
		Course c2 = new Course();
		c2.setCname("PHP");
		
		s1.getCourses().add(c1);
		s2.getCourses().add(c1);
		s1.getCourses().add(c2);
		s2.getCourses().add(c2);
		
		c1.getStudents().add(s1);
		c2.getStudents().add(s1);
		c1.getStudents().add(s2);
		c2.getStudents().add(s2);

		// 4.�洢
		session.save(c1);
		session.save(c2);
		session.save(s1);
		session.save(s2);
		
		t.commit();
		session.close();
	}
	
	@Test //��Զ��ϵ����������
	public void test2() {
		Session session = HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Course course=new Course();
		course.setCname("PHP");
		
		Student student=new Student();
		student.setSname("����");
		student.getCourses().add(course);
		session.save(student);
		t.commit();
		session.close();
	}
	
	@Test //��Զ��ϵ����ɾ��
	public void test3() {
		Session session = HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Student student= (Student) session.get(Student.class, 1);
		session.delete(student);
		t.commit();
		session.close();
		
	}

}
