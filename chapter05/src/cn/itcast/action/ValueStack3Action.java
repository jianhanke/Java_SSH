package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.domain.Product;

public class ValueStack3Action extends ActionSupport implements ModelDriven<Product> {
	private Product p3=new Product();
	
	@Override
	public Product getModel() {
		return p3;
	}
	
	public String execute()throws Exception{
		return SUCCESS;
	}
}
