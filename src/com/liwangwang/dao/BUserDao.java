package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.StringUtils;

public class BUserDao extends JsonBaseDao {
	
	public List<Map<String,Object>> list(Map<String, String[]> pamap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_user where user_id != 1 ";
		String user_name = JsonUtils.getParamVal(pamap, "user_name");
		if(StringUtils.isNotBlank(user_name)) {
			sql+=" and user_name like '%"+user_name+"%' ";
		}
		return super.executeQuery(sql, pageBean);
	}
	public List<Map<String,Object>> adduserlist(Map<String, String[]> pamap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_user where user_id != 1 ";
		String user_name = JsonUtils.getParamVal(pamap, "user_name");
		String user_pwd = JsonUtils.getParamVal(pamap, "user_pwd");
		if(StringUtils.isNotBlank(user_name)) {
			sql+=" and user_name = '"+user_name+"' ";
		}
		if(StringUtils.isNotBlank(user_pwd)) {
			sql+=" and user_pwd = '"+user_pwd+"' ";
		}
		
		return super.executeQuery(sql, pageBean);
	}
	
	
	public List<Map<String,Object>> listmenu(Map<String, String[]> pamap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_easyui_usermenu where true ";
		String uid = JsonUtils.getParamVal(pamap, "uid");
		if(StringUtils.isNotBlank(uid)) {
			sql += " and uid = "+uid;
		}
		return super.executeQuery(sql, pageBean);
	}
	
	public List<Map<String,Object>> list2(Map<String, String[]> pamap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_easyui_user_version2 where true ";
		
		return super.executeQuery(sql, pageBean);
	}
	
	
	public int edit(Map<String, String[]> pamap ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "update t_user set user_name = ?,user_pwd=? where user_id = ?";
		
		return super.executeUpdate(sql,new String[] {"user_name","user_pwd","user_id"}, pamap);
	}
	public int add(Map<String, String[]> pamap ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		
		String sql = "insert into  t_user(user_name,user_pwd,user_type) values(?,?,2) ";
		
		
		return super.executeUpdate(sql,new String[] {"user_name","user_pwd"}, pamap);
	}
	public int del(Map<String, String[]> pamap ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "delete from  t_user where user_id = ?";
		
		return super.executeUpdate(sql,new String[] {"user_id"}, pamap);
	}
	
	
	public List<Map<String,Object>> zhu(List<Map<String,Object>> pamap) throws InstantiationException, IllegalAccessException, SQLException{
		BUserRoleDao burd = new BUserRoleDao();
		BRoleDao brd = new BRoleDao();
		
		List<Map<String,Object>> la = new ArrayList<>();
		Map<String, Object> ma ;
		String role_name ;//角色
		String role_bak;
		for (Map<String, Object> map : pamap) {
			role_name = "" ;
			role_bak = "";
			ma = new HashMap<>();
			
			ma.put("user_id", map.get("user_id"));
			ma.put("user_name", map.get("user_name"));
			ma.put("user_pwd", map.get("user_pwd"));
			ma.put("user_type", map.get("user_type"));
			List<Map<String, Object>> list = burd.list(null, null, map.get("user_id")+"");//找到用户角色表的中间表的角色id
			if(list!=null&&list.size()>0) {
				
			for (Map<String, Object> map2 : list) {//因为一个用户可能有多个角色
				List<Map<String, Object>> list2 = brd.list(null, null, map2.get("role_id")+"");//找到角色表中的角色
				if(list2!=null&&list2.size()>0) {
					
					Map<String, Object> map3 = list2.get(0);//因为角色就一个就没必要遍历
					role_name+= ","+map3.get("role_name");
					role_bak+= ","+ map3.get("role_bak");
				}
			}
			}
			if(!role_name.equals("")&&!role_bak.equals("")) {
				ma.put("role_name",role_name.substring(1));
				ma.put("role_bak", role_bak.substring(1));
			}
			else {
				ma.put("role_name","暂无角色");
				ma.put("role_bak", "");
			}
			
			la.add(ma);
		}
		
		return la;
	}
	
	
	
	
}
