package cn.itcast.onetomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.itcast.utils.HibernateUtils;

public class OnttoManyTest {

	
	public void test1() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Customer c=new Customer();
		c.setName("张三");

		Order o1=new Order();
		o1.setAddress("22");
		o1.setAddress("北京");
		o1.setPrice(1000d);
		Order o2=new Order();
		o2.setAddress("广州");
		o2.setPrice(5000d);
		
//		o1.setCustomer(c);  //o是订单  c是顾客
		
		c.getOrders().add(o1);  
			
		
		session.save(c);
		session.save(o1);
		session.save(o2);
		
		t.commit();
		session.close();
	}
	       //级联保存update-save 将Customer.hbm.xml设置级联保存，即order也会保存
	public void test2() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Customer customer=new Customer();
		customer.setName("李四");
		
		Order order=new Order();
		order.setAddress("上海");
		order.setPrice(2000d);
		
		customer.getOrders().add(order);
		session.save(customer);
		t.commit();
		session.close();
	}
	@Test    //测试级联updaet-save 测试test2 是否修改order是否能save Customer 
	public void test22() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Order order=new Order();
		order.setAddress("河南");
		
		Customer c=new Customer();
		c.setName("河南小伙");
		
		order.setCustomer(c);
		session.save(order);
		t.commit();
		session.close(); 
		 //经测试会错误, 必须在order也要加级联 
	}
	@Test //一对多级联删除,先将对应的Order中的Cid设置为null,然后才Cutomer删除
	public void test3() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, 3);
		session.delete(c);
		t.commit();
		session.close();
	}
	@Test //级联删除 
	public void test4() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, 2);
		session.delete(c);
		t.commit();
		session.close();
	} 
	@Test //孤儿删除，将解除关系的孤儿删除
	public void test5() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		
		Customer customer=(Customer) session.get(Customer.class, 4);
		Order order=(Order) session.get(Order.class, 6);
		
		customer.getOrders().remove(order);
		t.commit();
		session.close();
		
	}
	
}
