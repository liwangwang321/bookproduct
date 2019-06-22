package com.liwangwang.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liwangwang.util.BaseDao.Callback;

public class EntityBaseDao<T> extends BaseDao<T> {
	public List<T> executeQuery(String sql, PageBean pageBean, Class clz) throws SQLException, InstantiationException, IllegalAccessException{
		return super.executeQuery(sql, pageBean, new Callback<T>() {
			@Override
			public List<T> foreach(ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException {
				/*
				 * 1、创建一个实体类的实例
				 * 2、给创建的实例属性赋值
				 * 3、将添加完类容的实体类添加到list集合中
				 */
//				list.add(new Book(rs.getInt("bid"), rs.getString("bname"), rs.getFloat("price")));
				List<T> list = new ArrayList<>();
				while(rs.next()) {
					T t = (T) clz.newInstance();
					Field[] fields = clz.getDeclaredFields();
					for (Field field : fields) {
						field.setAccessible(true);
						field.set(t, rs.getObject(field.getName()));
					}
					list.add(t);
				}
				return list;
			}
		});
	}
	
	/**
	 * 通用的增删改方法
	 * @param sql	增删改的sql语句
	 * @param attrs	？所代表的实体类的属性
	 * @param t		实体类的实例
	 * @return
	 * @throws SQLException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public int executeUpdate(String sql, String[] attrs, T t) throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Connection con = DBAccess.getConnection();
		PreparedStatement pst = con.prepareStatement(sql);
		for (int i = 0; i < attrs.length; i++) {
			Field field = t.getClass().getDeclaredField(attrs[i]);
			field.setAccessible(true);
			pst.setObject(i+1, field.get(t));
		}
		return pst.executeUpdate();
	}
}
