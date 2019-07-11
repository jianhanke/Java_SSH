package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport {
	public String execute()throws Exception {
		ValueStack valuestack=ActionContext.getContext().getValueStack();
		System.out.println(valuestack);
		return SUCCESS;
	}
}
