package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.StringUtils;

public class UserDao extends JsonBaseDao{
	
	public List<Map<String, Object>> getUser(Map<String, String[]> mapMap,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_user where true";
		String name = JsonUtils.getParamVal(mapMap, "name");
		String pwd = JsonUtils.getParamVal(mapMap, "pwd");
		if(StringUtils.isNotBlank(name)) {
			sql+=" and user_name = '"+name+"'";
		}
		if(StringUtils.isNotBlank(pwd)) {
			sql+=" and user_pwd = '"+pwd+"'";
		}
		return super.executeQuery(sql, pageBean);
	}
	
	public int add(Map<String, String[]> mapMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException{
		String sql = "insert into t_user(user_name,user_pwd,user_type) values(?,?,2)";
	
		return super.executeUpdate(sql, new String[] {"name","pwd"}, mapMap);
	}
	
}
