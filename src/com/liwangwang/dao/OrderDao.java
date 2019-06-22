package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;


import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.StringUtils;

public class OrderDao extends JsonBaseDao{
	
	public List<Map<String, Object>> list(Map<String, String[]> Mapmap ,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException {
		String sql = "select * from t_order where true ";
		String order_state = JsonUtils.getParamVal(Mapmap, "order_state");
		String user_id = JsonUtils.getParamVal(Mapmap, "user_id");
		String phone = JsonUtils.getParamVal(Mapmap, "phone");
		
		if(StringUtils.isNotBlank(order_state)) {
			sql+=" and order_state = "+order_state+" ";
		}
		if(StringUtils.isNotBlank(user_id)) {
			sql +=" and user_id = "+user_id;
		}
		if(StringUtils.isNotBlank(phone)) {
			sql +=" and phone like '%"+phone+"%' ";
		}
		
		return super.executeQuery(sql, pageBean);
	}
	
	public int addOrder(Map<String, String[]> paMap,String countprice,String order_id ) throws InstantiationException, IllegalAccessException, SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException {
		String date = new Date().toLocaleString();
		String sql = "insert into t_order(order_id,user_id,order_datetime,consignee,phone,postalcode,address,send_type,order_price,order_state) values("+order_id+",?,str_to_date('"+date+"','%Y-%c-%e %H:%i:%S'),?,?,?,?,?,"+countprice+",1)";
		
		
		return super.executeUpdate(sql, new String[] {"user_id","consignee","phone","postalcode","address","send_type"}, paMap);
	}
	
	public int editstate(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "update t_order set order_state = 2 where order_id = ?";
		
		return super.executeUpdate(sql, new String[] {"order_id"}, paMap);
	}
	public int editstate2(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "update t_order set order_state = 3 where order_id = ?";
		
		return super.executeUpdate(sql, new String[] {"order_id"}, paMap);
	}
	public int delorder(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "delete from t_order where order_id = ?";
		
		return super.executeUpdate(sql, new String[] {"order_id"}, paMap);
	}
	public int delorderitem(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "delete from t_order_item where order_id = ?";
		
		return super.executeUpdate(sql, new String[] {"order_id"}, paMap);
	}
	

}
