package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.StringUtils;

public class BRoleDao extends JsonBaseDao {
	
	public List<Map<String,Object>> list(Map<String, String[]> pamap ,PageBean pageBean,String role_id) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from b_role where role_id = '"+role_id+"' ";
		
		return super.executeQuery(sql, pageBean);
	}
	public List<Map<String,Object>> lists(Map<String, String[]> pamap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from b_role where true ";
		String role_name = JsonUtils.getParamVal(pamap, "role_name");
		if(StringUtils.isNotBlank(role_name)) {
			sql +=" and role_name like '%"+role_name+"%' ";
		}
		
		return super.executeQuery(sql, pageBean);
	}
	
	public List<Map<String,Object>> falist(Map<String, String[]> pamap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from b_role where true";
		
		return super.executeQuery(sql, pageBean);
	}
	
	public int addrole(Map<String, String[]> pamap) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException{
		String sql = "insert into b_role(role_id,role_name,role_bak) values(?,?,?)";
		
		return super.executeUpdate(sql, new String[] {"role_id","role_name","role_bak"}, pamap);
	}
	public int delrole(Map<String, String[]> pamap) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException{
		String sql = "delete from b_role where role_id = ? ";
		
		return super.executeUpdate(sql, new String[] {"id"}, pamap);
	}
	public int editrole(Map<String, String[]> pamap) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException{
		String sql = "update b_role set role_name =? ,role_bak=? where role_id = ?";
		
		return super.executeUpdate(sql, new String[] {"role_name","role_bak","role_id"}, pamap);
	}
	
	
}
