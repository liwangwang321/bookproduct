package com.liwangwang.web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liwangwang.dao.BMenuDao;
import com.liwangwang.dao.MenuDao;
import com.liwangwang.entity.TreeNode;
import com.liwangwang.util.ResponseUtil;
import com.zking.framework.ActionSupport;

public class MenuAction extends ActionSupport {
	private MenuDao  menuDao = new MenuDao();
	
	private BMenuDao bmd = new BMenuDao();
	public String treeMenu(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			List<TreeNode> list = this.menuDao.list(req.getParameterMap(), null);
			ObjectMapper om = new ObjectMapper();
			//将list集合转换成json串
			String jsonStr = om.writeValueAsString(list);
			
			ResponseUtil.write(resp, jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "no";
	}
	public String btreeMenu(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<TreeNode> list = bmd.list(req.getParameterMap(), null);
			
			ObjectMapper om = new ObjectMapper();
			//将list集合转换成json串
			String jsonStr = om.writeValueAsString(list);
			
			ResponseUtil.write(resp, jsonStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "no";
	}
	
}
