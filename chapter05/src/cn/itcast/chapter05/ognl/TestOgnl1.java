package cn.itcast.chapter05.ognl;

import ognl.Ognl;
import ognl.OgnlException;

public class TestOgnl1 {

	public static void main(String[] args) throws OgnlException {
		
		User user=new User();
		user.setUsername("itcast");
		System.out.println("username="+Ognl.getValue("getUsername()", user) );
		
		Group g=new Group();
		g.setName("С������");
		user.setGroup(g);
		System.out.println("groupName="+Ognl.getValue("getGroup().getName()", user));

	}

}
