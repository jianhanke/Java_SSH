package cn.itcast.action;


import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class AwareAction extends ActionSupport implements ServletRequestAware{
	HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest reqeust) {
		this.request=request;
		
	}
	
	
	@Override
	public String execute() throws Exception{
		this.request.setAttribute("message","API");
		return SUCCESS;
	}

	
}
