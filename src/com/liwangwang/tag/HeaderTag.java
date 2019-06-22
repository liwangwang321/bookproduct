package com.liwangwang.tag;

import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class HeaderTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	private String user;
	private Map<String,Object> userset;
	

	public Map<String, Object> getUserset() {
		return userset;
	}
	public void setUserset(Map<String, Object> userset) {
		this.userset = userset;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print(toHtml());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	private String toHtml() {
		StringBuffer sb = new StringBuffer();
		int u = Integer.parseInt(user);
		if(u==1) {
			
			sb.append("<p class=\"left\">您好admin，欢迎来到飞凡网上书店 ！</p>");
			sb.append("<p class=\"right\"> <a href=\"userAction.action?methodName=center&user_id="+userset.get("user_id")+"\">贴吧</a> | <a>"+userset.get("user_name")+"</a>  | <a href=\"userAction.action?methodName=exit\">退出系统</a> </p>");
		}
		if(u==2) {
		
			sb.append("<p class=\"left\">您好，欢迎来到飞凡网上书店 ！</p>");
			if(userset!=null) {
				sb.append("<p class=\"right\">  <a href=\"userAction.action?methodName=center&user_id="+userset.get("user_id")+"\">贴吧</a> | <a>"+userset.get("user_name")+"</a>| <a href='userAction.action?methodName=exit' >注销</a> | <a href=\"shoppingCar.jsp\">我的购物车</a>  | <a href=\"listMyOrder1.jsp\">我的订单</a> | <a href=\"index.jsp\">网站首页</a></p>");
			}
			else {
				sb.append("<p class=\"right\"><a href=\"login.jsp\">登陆</a> | <a href=\"register.jsp\">注册</a> | <a href=\"shoppingCar.jsp\">我的购物车</a> | <a href=\"index.jsp\">网站首页</a></p>");
			}
		
		}
		
		
		return sb.toString();
	}
	
	
	

}
