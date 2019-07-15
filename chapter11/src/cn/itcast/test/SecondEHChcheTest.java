package cn.itcast.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.util.HibernateUtils;

public class SecondEHChcheTest {
	
	@Test
	public void testCache() {
		Session session1=HibernateUtils.getSession();
		Transaction t=session1.beginTransaction();
		
		User user1=(User) session1.get(User.class, 1);
		User user2=(User) session1.get(User.class, 1);
		System.out.println(user1==user2);
		t.commit();
		session1.close();
		
		Session session2=HibernateUtils.getSession();
		Transaction t2=session2.beginTransaction();
		User user3=(User) session2.get(User.class, 1);
		System.out.println(user1==user3);
		User user4=(User) session2.get(User.class, 1);
		System.out.println(user3==user4);
		t2.commit();
		session2.close();
		
		
	}
}
