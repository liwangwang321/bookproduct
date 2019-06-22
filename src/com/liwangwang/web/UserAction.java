package com.liwangwang.web;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liwangwang.dao.CategoryDao;
import com.liwangwang.dao.UserDao;
import com.zking.framework.ActionSupport;

public class UserAction extends ActionSupport{
	
	private UserDao ud = new UserDao();
	//登陆，判断是什么身份
	public String login(HttpServletRequest req,HttpServletResponse resp) {
			
			try {
				
				List<Map<String, Object>> user = ud.getUser(req.getParameterMap(), null);
				if(user!=null&&user.size()>0) {
					req.setAttribute("ser", 0);
					if(user.size()==1) {
						Map<String, Object> uMap = user.get(0);
						HttpSession session = req.getSession();
						session.setAttribute("user", uMap);
						Object type = uMap.get("user_type");
						type = type+"";
						
						if("1".equals(type)) {
							CategoryDao cd = new CategoryDao();
							List<Map<String, Object>> clist = cd.list(req.getParameterMap(), null);
							session.setAttribute("book_category", clist);
							
							return "addBook";
						}
						else if("2".equals(type)) {
							return "index";
						}
						
					}
					
				}
				else {
					req.setAttribute("ser", 1);
				}
				
			}  catch (Exception e) {
				e.printStackTrace();
			}
		
		return "login";
	}
	//注册
	public String register(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			int add = ud.add(req.getParameterMap());
			if(add>0) {
				req.setAttribute("ser", 2);
				return "login";
			}
			else {
				req.setAttribute("Reser", 1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "register";
	}
	
	//注销，清理页面中的所有session域
	public String exit(HttpServletRequest req,HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		session.setAttribute("user", null);
		session.setAttribute("shoplist", null);
		session.setAttribute("myshoplist", null);
		return "index";
	}
	
	//进入到贴吧系统
	public String center(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			String user_id = req.getParameter("user_id");
			req.setAttribute("user_id", user_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return "bindex";
	}
	
	
	
}
