package com.liwangwang.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liwangwang.dao.BMenuDao;
import com.liwangwang.dao.BMenuRoleDao;
import com.liwangwang.util.ResponseUtil;
import com.zking.framework.ActionSupport;

public class BMenuRoleAction extends ActionSupport {
	private BMenuRoleDao bmrd = new BMenuRoleDao();
	private BMenuDao bmd = new  BMenuDao();
	
	
	//修改角色表，
		public String editstate(HttpServletRequest req,HttpServletResponse resp) {
			
			try {
				int state = 0;
				String menu_pid = null;
				String role_id = req.getParameter("role_id");
				String menu_id =  req.getParameter("menu_id");
				if(req.getParameter("checked").equals("false")) {
					state = 1;
				}
				//以下是用来判断该menu_id的父id ，其下所有的子id状态是否为0,或者1
				int editstate = bmrd.editstate(role_id, menu_id, state+"");
				List<Map<String, Object>> listpid = bmd.listpid(menu_id);//找其父ID
				if(listpid!=null) {
					Map<String, Object> map = listpid.get(0);
					menu_pid = (String)map.get("menu_pid");
				}
				//由单个的父id，查询多个子id
				if(menu_pid!=null) {
					boolean fa=false;//用来判断他下面所有是否全部选中
					boolean fb=false;
					List<Map<String, Object>> listmenu_id = bmd.listmenu_id(menu_pid);//找其下面所有子ID
					for (Map<String, Object> map : listmenu_id) {
						List<Map<String, Object>> statelist = bmrd.statelist(role_id, map.get("menu_id")+"");
						Map<String, Object> map2 = statelist.get(0);//获取其所有子ID的状态
						
						if((int)map2.get("rolemenu_state")==0) {//这代表有一个状态为可用的就不修改它的父ID为不可用
							fa=true;
						}
						if((int)map2.get("rolemenu_state")==1) {
							fb=true;
						}
						
						if(fa==false) {
							bmrd.editstate(role_id, menu_pid, 1+"");
							
						}
						if(fb==false) {
							bmrd.editstate(role_id, menu_pid, 0+"");
						}
						
					}
					
					
					
				}
				
				
				ObjectMapper om = new ObjectMapper();
				ResponseUtil.write(resp, om.writeValueAsString(editstate));
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return "no";
		}
}
