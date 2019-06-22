package com.liwangwang.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liwangwang.dao.CategoryDao;
import com.liwangwang.util.ResponseUtil;
import com.zking.framework.ActionSupport;

public class CategoryAction extends ActionSupport{
	
	private CategoryDao cd = new CategoryDao();
	
	public String list(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			List<Map<String, Object>> list = cd.list(req.getParameterMap(), null);
			HttpSession session = req.getSession();
			session.setAttribute("book_category", list);
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(list));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "no";
	}
	
}
