package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.StringUtils;

public class BUserRoleDao extends JsonBaseDao{
	
	public List<Map<String,Object>> list(Map<String, String[]> pamap ,PageBean pageBean,String user_id) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from b_user_role where user_id = "+user_id+" ";
		String role_id = JsonUtils.getParamVal(pamap, "role_name");
		if(StringUtils.isNotBlank(role_id)) {
			sql+=" and role_id = '"+role_id+"' ";
		}
		return super.executeQuery(sql, pageBean);
	}
	
	
	
	public int add(String user_id,String role_id ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		
		String sql = "insert into  b_user_role(user_id,role_id) values("+user_id+",'"+role_id+"') ";
		
		return super.executeUpdate(sql,new String[] {}, null);
	}
	public int del(Map<String, String[]> pamap ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "delete from  b_user_role where user_id = ?";
		
		return super.executeUpdate(sql,new String[] {"user_id"}, pamap);
	}
	

}
