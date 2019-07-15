package cn.itcast.test;


import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.domain.User;
import cn.itcast.util.HibernateUtils;

public class UserTest {
	
	@Test
	public void test0() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		User user=new User();
		user.setAge(20);
		user.setUsername("Jame");
		user.setVersion(1);
		session.save(user);
		t.commit();
	}

	@Test
	public void test1() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		User user=(User) session.get(User.class, 1);
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getAge());
	}
	@Test
	public void test2() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		User user=(User) session.get(User.class, 1);
		user.setUsername("tom");
		t.commit();
		session.close();
	}
	@Test
	public void test3() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		User user=(User) session.get(User.class, 1);
		user.setAge(30);
		session.save(user);
		t.commit();
		session.close();
	}
}
