package cn.itcast.test;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.entity.Book;
import cn.itcast.utils.HibernateUtils;

public class BookTest {
	
	
	public void test1() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Book book =new Book();
		book.setName("thinkings");
		book.setPrice(99d);
		session.save(book);
		t.commit();
		System.out.println(book);
	}
	
	public void test2() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Book b1=(Book)session.get(Book.class,1);
		System.out.println(b1);
		Book b2=(Book) session.get(Book.class, 1);
		System.out.println(b2);
		t.commit();
		session.close();
	}
	
	public void test3() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Book book=new Book();
		book.setId(2);
//		book.setName("精通Hibernate");
//		book.setPrice(65d);
//		session.update(book);
		session.delete(book);
		book.setName("精通Struts");
		t.commit();
	}
	
	
	public void test4() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Book book=(Book) session.get(Book.class, 1);
		book.setName("Java Web");
		session.flush();
		t.commit();
		session.close();
	}
	
	
	public void test5() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Book book=(Book) session.get(Book.class, 2);
		System.out.println(book);
		book.setName("Java基础");
		session.clear();
		t.commit();
		session.close();	
	}
	
	@Test
	public void test6() {
		Session session=HibernateUtils.getSession();
		Transaction t=session.beginTransaction();
		Book book=(Book) session.get(Book.class, 6);
		book.setName("精通Struts");
		session.refresh(book);
		t.commit();
		session.close();
	}
	
	
}
