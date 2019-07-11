package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.*;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID=1L;
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	
	public String execute()throws Exception{
		ActionContext actionContext=ActionContext.getContext();
		if("tom".equals(user.getUsername())&&"123".equals(user.getPassword())) {
			actionContext.getSession().put("user",user);
			return SUCCESS;
		}else{
			actionContext.put("msg", "�û��������벻��ȷ");
			return INPUT;
		}
	}
	
}
