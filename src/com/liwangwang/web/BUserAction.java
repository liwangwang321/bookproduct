package com.liwangwang.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liwangwang.dao.BUserDao;
import com.liwangwang.dao.BUserRoleDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.ResponseUtil;
import com.liwangwang.util.StringUtils;
import com.zking.framework.ActionSupport;

public class BUserAction extends ActionSupport {
	
	private BUserDao bud = new BUserDao();
	private 	BUserRoleDao burd = new BUserRoleDao();//准备增加用户角色表
	
	public String list(HttpServletRequest req,HttpServletResponse resp) {
		try {
			
			PageBean pageBean = new PageBean();//分页
			pageBean.setRequest(req);
			
			List<Map<String, Object>> listmenu = bud.list(req.getParameterMap(), pageBean);//获取所信息
			List<Map<String, Object>> zhu = bud.zhu(listmenu);
			Map<String, Object> ma = new HashMap<>();
			ma.put("total", pageBean.getTotal());
			ma.put("rows", zhu);//符合json文件的格式
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(ma));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return "no";
}
	public String edituser(HttpServletRequest req,HttpServletResponse resp) {
		try {
			int edit = bud.edit(req.getParameterMap());
			burd.del(req.getParameterMap());
			burd.add(req.getParameter("user_id"), req.getParameter("role_name"));
			
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(edit));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return "no";
}
	//增加用户表，同时也增加用户角色表
	public String adduser(HttpServletRequest req,HttpServletResponse resp) {
		try {
			int edit = bud.add(req.getParameterMap());
		
			if(edit>0) {
				if(StringUtils.isNotBlank(JsonUtils.getParamVal(req.getParameterMap(), "role_name"))) {
					
					List<Map<String, Object>> list = bud.adduserlist(req.getParameterMap(), null);//根据之前传过来的参数进行查询
					Map<String, Object> map = list.get(0);
					//获取到刚刚增加的用户id 
					 int add= burd.add(map.get("user_id")+"", req.getParameter("role_name"));//增加用户角色表
				}
			}
			
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(edit));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return "no";
}
	public String deluser(HttpServletRequest req,HttpServletResponse resp) {
		try {
			int edit = bud.del(req.getParameterMap());
				
			int del = burd.del(req.getParameterMap());
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(edit));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	return "no";
}
	
	
	
}
