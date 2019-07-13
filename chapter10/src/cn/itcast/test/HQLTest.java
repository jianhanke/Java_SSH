package cn.itcast.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import cn.itcast.domain.*;

public class HQLTest {
	
	@Test      //HQL����
	public void aliasTest() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		String hql="from Customer as c where c.name='Jack'";
		Query query=session.createQuery(hql);
		List<Customer> list=query.list();
		for(Customer c:list) {
			System.out.println(c);
		}
	}
	@Test  //ͶӰ��ѯ
	public void portionQueryTest() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		String hql="select c.name,c.age from Customer as c";
		Query query=session.createQuery(hql);
		List<Object> list=query.list();
		Iterator iter=list.iterator();
		while(iter.hasNext()) {
		    Object[] object=(Object[]) iter.next();
		    System.out.println(object);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test //��̬��ѯ,����ѯ���һ���µĶ���
	public void dynamicQueryTest() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		String hql="select new Customer(c.name,c.age) from Customer as c";
		Query query=session.createQuery(hql);
		List<Customer>cs=query.list();
		for(Customer c:cs) {
			System.out.println(c.getName()+":"+c.getAge());
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	@Test //������λ�ò�ѯ  ? ����λ��,��0��ʼ
	public void paramQueryTest1() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		String hql="from Customer where name like ?";
		Query query=session.createQuery(hql);
		query.setParameter(0,"%jo%");
		List<Customer>list=query.list();
		for(Customer c:list) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	@Test //���ղ������ֲ�ѯ : ��������
	public void paramQueryTest2() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		
		String hql="from Customer where  id=:id ";
		Query query=session.createQuery(hql);
		query.setInteger("id", 2);
		List<Customer>list=query.list();
		for(Customer c:list) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	@Test //��ҳ��ѯ,�����±��0��ʼ
	public void queryPageTest() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		String hql="from Customer";
		Query query=session.createQuery(hql);
		query.setFirstResult(2);
		query.setMaxResults(3);
		List<Customer>list=query.list();
		for(Customer c:list) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
	}
	
	
}
