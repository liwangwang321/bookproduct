package com.liwangwang.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonBaseDao extends BaseDao<Map<String,Object>> {
	public List<Map<String,Object>> executeQuery(String sql, PageBean pageBean) throws SQLException, InstantiationException, IllegalAccessException{
		return super.executeQuery(sql, pageBean, new Callback<Map<String,Object>>() {
			@Override
			public List<Map<String,Object>> foreach(ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException {
				/*
				 * 1、创建一个实体类的实例
				 * 2、给创建的实例属性赋值
				 * 3、将添加完类容的实体类添加到list集合中
				 */
//				list.add(new Book(rs.getInt("bid"), rs.getString("bname"), rs.getFloat("price")));
				List<Map<String,Object>> list = new ArrayList<>();
//				获取源数据
				ResultSetMetaData md = rs.getMetaData();
				int count = md.getColumnCount();
				Map<String,Object> map = null;
				while(rs.next()) {
					map = new HashMap<>();
					for (int i = 1; i <= count; i++) {
						map.put(md.getColumnName(i), rs.getObject(i));
					}
					list.add(map);
				}
				return list;
			}
		});
	}
	
	/**
	 * 
	 * @param sql
	 * @param attrs	map中的key
	 * @param paMap	jsp向后台传递的参数集合
	 * @return
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public int executeUpdate(String sql, String[] attrs, Map<String,String[]> paMap) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Connection con = DBAccess.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		for (int i = 0; i < attrs.length; i++) {
			pst.setObject(i+1, JsonUtils.getParamVal(paMap, attrs[i]));
		}
		return pst.executeUpdate();
	}
}
