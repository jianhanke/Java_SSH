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
	
	@Test      //HQL检索
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
	@Test  //投影查询
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
	
	@Test //动态查询,将查询组成一个新的对象
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
	@Test //按参数位置查询  ? 代表位置,从0开始
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
	@Test //按照参数名字查询 : 代表名字
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
	@Test //分页查询,索引下标从0开始
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
