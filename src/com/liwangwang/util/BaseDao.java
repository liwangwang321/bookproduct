package com.liwangwang.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 通用的查询方法 23种设计模式之策略模式 
 * 作用：在方法或类中已经完成了对应的功能，然后在调用方去根据自己的需求去处理结果。 使得代码更加灵活。
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class BaseDao<T> {
	// $.ajax
	protected interface Callback<T> {
		public List<T> foreach(ResultSet rs) throws SQLException, InstantiationException, IllegalAccessException;
	}

	public List<T> executeQuery(String sql, PageBean pageBean, Callback<T> callback)
			throws SQLException, InstantiationException, IllegalAccessException {
		if (pageBean != null && pageBean.isPagination()) {
			Connection con = DBAccess.getConnection();
			String countSql = getCountSql(sql);
			PreparedStatement countPst = con.prepareStatement(countSql);
			ResultSet countRs = countPst.executeQuery();
			if (countRs.next()) {
				pageBean.setTotal(countRs.getObject(1).toString());
			}
			DBAccess.close(null, countPst, countRs);

			String pageSql = getPageSql(sql, pageBean);
			PreparedStatement pagePst = con.prepareStatement(pageSql);
			ResultSet pageRs = pagePst.executeQuery();
			try {
				return callback.foreach(pageRs);
			}  finally {
				DBAccess.close(con);
			}
		} else {
			Connection con = DBAccess.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			try {
				return callback.foreach(rs);
			} finally {
				DBAccess.close(con);
			}
		}

	}

	/**
	 * 将原生态的sql语句转换成查对应的当页记录数sql语句
	 * 
	 * @param sql
	 * @param pageBean
	 * @return
	 */
	private String getPageSql(String sql, PageBean pageBean) {
		return sql + " limit " + pageBean.getStartIndex() + "," + pageBean.getRows();
	}

	/**
	 * 将原生态的sql语句转换成查总记录输的sql语句
	 * 
	 * @param sql
	 * @return
	 */
	private String getCountSql(String sql) {
		return "select count(1) from (" + sql + " ) t";
	}
}
