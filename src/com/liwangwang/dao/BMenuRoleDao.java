package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.StringUtils;

public class BMenuRoleDao extends JsonBaseDao {
	//在增加角色表后就要给它增加一个初始的中间表
	public int addmenurole(String role_id ) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException{
		
		String sql = "insert into b_menu_role(role_id,menu_id,rolemenu_state) " + 
				" select '"+role_id+"','000',0  from dual union" + 
				" select '"+role_id+"','001',0  from dual union" + 
				" select '"+role_id+"','002',0  from dual union" + 
				" select '"+role_id+"','003',0  from dual union" + 
				" select '"+role_id+"','001001',0  from dual union" + 
				" select '"+role_id+"','001002',0  from dual union" + 
				" select '"+role_id+"','001003',0  from dual union" + 
				" select '"+role_id+"','002001',0  from dual union" + 
				" select '"+role_id+"','002002',0  from dual union" + 
				" select '"+role_id+"','003001',0  from dual union" + 
				" select '"+role_id+"','003002',0  from dual union" + 
				" select '"+role_id+"','003003',0  from dual ";
		
		
		return super.executeUpdate(sql, new String[] {}, null);
	}
	
	public int delmenurole(Map<String, String[]> pamap) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException{
		String sql = "delete from b_menu_role where role_id = ? ";
		
		return super.executeUpdate(sql, new String[] {"id"}, pamap);
	}
	//查找中间表的状态
	public List<Map<String, Object>> statelist(String role_id,String menu_id) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from b_menu_role where role_id = '"+role_id+"' and menu_id = '"+menu_id+"' ";
		
		return super.executeQuery(sql, null);
	}
	//修改中间表的状态
	public int editstate(String role_id,String menu_id,String state) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException{
		String sql = "update b_menu_role set rolemenu_state = "+state+" where role_id = '"+role_id+"' and menu_id = '"+menu_id+"'  ";
		
		return super.executeUpdate(sql, new String[] {}, null);
	}
	

	
}
