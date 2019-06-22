package com.liwangwang.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liwangwang.dao.BUserRoleDao;
import com.liwangwang.util.ResponseUtil;
import com.zking.framework.ActionSupport;

public class BUserRoleAction extends ActionSupport{
	private BUserRoleDao burd = new BUserRoleDao();
	
	public String adduserrole(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			List<Map<String, Object>> list = burd.list(req.getParameterMap(), null, req.getParameter("user_id"));
			String add="";
			if(list.size()==0) {
				 add = burd.add(req.getParameter("user_id"), req.getParameter("role_name"))+"";
			}
			else {
				add="-1";
			}
			ResponseUtil.write(resp, add);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "no";
	}
	
	
}
