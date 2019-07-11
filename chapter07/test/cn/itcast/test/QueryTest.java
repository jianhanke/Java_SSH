package cn.itcast.test;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import cn.itcast.domain.*;

public class QueryTest {
	
	@Test
	public void findAll_hqlTxest() {
		Configuration configure=new Configuration().configure();
		SessionFactory sessionFactory=configure.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction t=session.beginTransaction();
		String hql="from Customer";
		Query query=session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(2);
		List<Customer>list=query.list();
		t.commit();
		for(Customer c:list) {
			System.out.println(c);
		}
		
	
	     
	     
	   
	     
	     
	     
	}
	
}
