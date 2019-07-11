package cn.itcast.action;

import java.io.File;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SimpleDownLoadAction extends ActionSupport{
	public InputStream getDownloadFile() {
//		String realPath=ServletActionContext.getServletContext().getRealPath("/upload/Struts2.txt");
		return ServletActionContext.getServletContext().getResourceAsStream("/upload/Struts2.txt");
	}
	
	public String execute()throws Exception{
		return SUCCESS;
	}
}

