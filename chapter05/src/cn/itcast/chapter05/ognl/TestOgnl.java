package cn.itcast.chapter05.ognl;

import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

public class TestOgnl {
	
	public static void main(String[] args) throws Exception {
		
	
	User user=new User();
	Group g=new Group();
	Branch b=new Branch();
	
	b.setBranchId("BRANCHID");
	g.setBranch(b);
	user.setGroup(g);
	
	System.out.println("��Java����������"+user.getGroup().getBranch().getBranchId());
	System.out.println("��OGNL���ʽ������"+Ognl.getValue("group.branch.branchId", user) );
	
	user.setUsername("itcast");
	Map context=new HashMap();
	context.put("u", user);
	System.out.println("��ȡContext�����ݽ��Ϊ-"+Ognl.getValue("#u.username",context,user));
	
	}
}
