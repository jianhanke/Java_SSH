package cn.itcast.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class MessageAction extends ActionSupport{

	public String execute() throws Exception{
		ServletActionContext.getRequest().setAttribute("message","ͨ��ServletActionContext��ֱ�ӷ���Servlet API");
		return SUCCESS;
	}
}
