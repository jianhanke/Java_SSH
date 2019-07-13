package cn.itcast.test;

import java.util.List;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.*;

public class QBCTest {
	
	@Test   //组合查询
	public void qbcTest1() {
	Configuration config=new Configuration().configure();
	SessionFactory sessionFactory=config.buildSessionFactory();
	Session session=sessionFactory.openSession();
	Transaction t=session.beginTransaction();
	
	Criteria criteria=session.createCriteria(Customer.class);
	Criterion criterion=Restrictions.or(Restrictions.eq("id",1),Restrictions.eq("name","joy"));
	criteria.add(criterion);
	List<Customer>cs=criteria.list();
	for(Customer c:cs) {
		System.out.println(c);
	}
	t.commit();
	session.close();
	sessionFactory.close();
	}
	@Test //分组查询
	public void qbcTest2() {
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		Criteria criteria=session.createCriteria(Customer.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(3);
		List<Customer>cs=criteria.list();
		for(Customer c:cs) {
			System.out.println(c);
		}
		t.commit();
		session.close();
		sessionFactory.close();
		
		
	}
}
