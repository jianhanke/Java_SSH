package cn.itcast.test;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import cn.itcast.domain.Customer;
/**
 *  ������
 */
public class CustomerTest {
	/**
	 *  1.��Ӳ���
	 */
	@Test
	public void insertTest() {
		
		Configuration config = new Configuration().configure();//Ĭ��ȥ��·���ĸ�Ŀ¼�²�������Ϊhibernate.cfg.xml���ļ�
		// 2.��ȡSessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory();
		// 3.�õ�һ��Session
		Session session = sessionFactory.openSession();
		// 4.��������
		 Transaction t = session.beginTransaction();
		session.beginTransaction();
		// 5.����
		// 5.1����һ������
		Customer c = new Customer();
		c.setName("����");
		c.setAge(20);
		c.setCity("�Ϻ�");
		c.setSex("��");
		// 5.2�����ݴ洢������
		session.save(c);
		// 6.�ύ����
		 t.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}
	@Test
	public void updateTest() {
		Configuration config =new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		Customer c=new Customer();
		c.setId(1);
		
		c.setCity("��22dd");
		session.update(c);
		t.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void findByIdTest() {
		Configuration configure=new Configuration().configure();
		SessionFactory sessionFactory=configure.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class,10);
		System.out.println("����:"+c.getName());
		System.out.println("����:"+c.getAge());
		System.out.println("�Ա�:"+c.getSex());
		System.out.println("����:"+c.getCity());
	}
	@Test
	public void deleteByIdTest() {
		Configuration configure=new Configuration().configure();
		SessionFactory sessionFactory =configure.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, 2);
		session.delete(c);
		t.commit();
		session.close();
	    sessionFactory.close();
	}
	

}
