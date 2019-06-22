package com.liwangwang.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 提供了一组获得或关闭数据库对象的方法
 * 
 */
public class DBAccess {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {// 静态块执行一次，加载 驱动一次
		try {
			InputStream is = DBAccess.class
					.getResourceAsStream("config.properties");

			Properties properties = new Properties();
			properties.load(is);

			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("pwd");

			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获得数据连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void close(ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public static void close(Statement stmt) {
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public static void close(Connection conn) {
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}

	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		close(rs);
		close(stmt);
		close(conn);
	}

	public static boolean isOracle() {
		return "oracle.jdbc.driver.OracleDriver".equals(driver);
	}

	public static boolean isSQLServer() {
		return "com.microsoft.sqlserver.jdbc.SQLServerDriver".equals(driver);
	}
	
	public static boolean isMysql() {
		return "com.mysql.jdbc.Driver".equals(driver);
	}

	public static void main(String[] args) {
		Connection conn = DBAccess.getConnection();
		DBAccess.close(conn);
		System.out.println("isOracle：" + isOracle());
		System.out.println("isSQLServer：" + isSQLServer());
		System.out.println("isMysql：" + isMysql());
		System.out.println("数据库连接(关闭)成功");
	}
}
