package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.PageBean;

public class OrderItemDao extends JsonBaseDao{
	
	public List<Map<String, Object>> list(Map<String, String[]> Mapmap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException {
		String sql = "select * from t_order_item";
		
		return super.executeQuery(sql, pageBean);
	}
	
	public int addOrderItem(Map<String, String[]> Mapmap,String order_id,String book_id,String quantity ) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException {
		
		String sql = "insert into t_order_item(order_id,book_id,quantity) values("+order_id+","+book_id+","+quantity+")";
		
		
		return super.executeUpdate(sql, new String[] {}, Mapmap);
	}
	
	
}
