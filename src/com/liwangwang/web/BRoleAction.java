package com.liwangwang.web;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liwangwang.dao.BMenuRoleDao;
import com.liwangwang.dao.BRoleDao;
import com.liwangwang.util.ResponseUtil;
import com.zking.framework.ActionSupport;

public class BRoleAction extends ActionSupport{
	private BRoleDao brd = new BRoleDao();
	private BMenuRoleDao bmrd = new BMenuRoleDao();
	
	public String falist(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			List<Map<String, Object>> falist = brd.falist(req.getParameterMap(), null);
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(falist));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "no";
	}
	public String list(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			List<Map<String, Object>> falist = brd.lists(req.getParameterMap(), null);
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(falist));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "no";
	}
	//增加角色表，同时也要增加角色菜单表
	public String addrole(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			int addrole = brd.addrole(req.getParameterMap());
			if(addrole>0) {
				bmrd.addmenurole(req.getParameter("role_id"));//增加角色菜单表
			
			}
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(addrole));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "no";
	}
	//删除角色表，
	public String delrole(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			int delrole = brd.delrole(req.getParameterMap());
			if(delrole>0) {
				 bmrd.delmenurole(req.getParameterMap());//删除角色中间表中的
			}
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(delrole));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "no";
	}
	
	//修改角色表，
		public String editrole(HttpServletRequest req,HttpServletResponse resp) {
			
			try {
				int editrole = brd.editrole(req.getParameterMap());
				ObjectMapper om = new ObjectMapper();
				ResponseUtil.write(resp, om.writeValueAsString(editrole));
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return "no";
		}
	
	
	
}
