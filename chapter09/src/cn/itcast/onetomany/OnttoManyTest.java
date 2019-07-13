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
		c.setName("����");

		Order o1=new Order();
		o1.setAddress("22");
		o1.setAddress("����");
		o1.setPrice(1000d);
		Order o2=new Order();
		o2.setAddress("����");
		o2.setPrice(5000d);
		
//		o1.setCustomer(c);  //o�Ƕ���  c�ǹ˿�
		
		c.getOrders().add(o1);  
			
		
		session.save(c);
		session.save(o1);
		session.save(o2);
		
		t.commit();
		session.close();
	}
	       //��������update-save ��Customer.hbm.xml���ü������棬��orderҲ�ᱣ��
	public void test2() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Customer customer=new Customer();
		customer.setName("����");
		
		Order order=new Order();
		order.setAddress("�Ϻ�");
		order.setPrice(2000d);
		
		customer.getOrders().add(order);
		session.save(customer);
		t.commit();
		session.close();
	}
	@Test    //���Լ���updaet-save ����test2 �Ƿ��޸�order�Ƿ���save Customer 
	public void test22() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Order order=new Order();
		order.setAddress("����");
		
		Customer c=new Customer();
		c.setName("����С��");
		
		order.setCustomer(c);
		session.save(order);
		t.commit();
		session.close(); 
		 //�����Ի����, ������orderҲҪ�Ӽ��� 
	}
	@Test //һ�Զ༶��ɾ��,�Ƚ���Ӧ��Order�е�Cid����Ϊnull,Ȼ���Cutomerɾ��
	public void test3() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, 3);
		session.delete(c);
		t.commit();
		session.close();
	}
	@Test //����ɾ�� 
	public void test4() {
		Session session=HibernateUtils.getSession();
		Transaction t =session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, 2);
		session.delete(c);
		t.commit();
		session.close();
	} 
	@Test //�¶�ɾ�����������ϵ�Ĺ¶�ɾ��
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
