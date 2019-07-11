package cn.itcast.test;

import java.util.List;

import org.bouncycastle.asn1.isismtt.x509.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.domain.Customer;
	
	
public class CriterTest {	
		
	@Test
	public void qbcTest() {
		
		Configuration config=new Configuration().configure();
		SessionFactory sessionFactoyry=config.buildSessionFactory();
		Session session=sessionFactoyry.openSession();
		Transaction t=session.beginTransaction();
		Criteria criteria=session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("name","2"));
		List<Customer>list=criteria.list();
		for(Customer c:list) {
			System.out.println(c);
		}
		
	
	}
	
}
