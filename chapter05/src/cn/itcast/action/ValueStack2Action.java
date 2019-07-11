package cn.itcast.action;

import com.opensymphony.xwork2.ActionSupport;

import cn.itcast.domain.Product;

public class ValueStack2Action extends ActionSupport{
	private Product p3;

	public Product getP3() {
		return p3;
	}

	public void setP3(Product p3) {
		this.p3 = p3;
	}
	@Override
	public String execute()throws Exception {
		return SUCCESS;
	}
	
}
