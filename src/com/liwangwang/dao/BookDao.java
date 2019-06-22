package com.liwangwang.dao;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.PinYinUtil;
import com.liwangwang.util.StringUtils;
import com.mysql.jdbc.PingTarget;

import demo.Pinyin4jAppletDemo;
import net.sourceforge.pinyin4j.PinyinHelper;

public class BookDao extends JsonBaseDao{
	
	
	public List<Map<String, Object>> indexlist(Map<String, String[]> mapMap,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_book where book_state = 2 ";
		String book_category_id = JsonUtils.getParamVal(mapMap, "book_category_id");
		String type = JsonUtils.getParamVal(mapMap, "type");
		if(StringUtils.isNotBlank(type)) {
			if("sales_volume".equals(type)) {
				sql = "select * from t_book where book_state = 2  order by sales_volume desc limit 5 ";
			}
			else if("deploy_datetime".equals(type)){
				sql = "select * from t_book where book_state = 2  order by deploy_datetime desc limit 5 ";
			}
		}
		if(StringUtils.isNotBlank(book_category_id)&&StringUtils.isNotBlank(type)) {
			if("sales_volume".equals(type)) {
				sql = "select * from t_book where  book_category_id = "+book_category_id+" and book_state = 2  order by sales_volume desc limit 5 ";
			}
			else if("deploy_datetime".equals(type)){
				sql = "select * from t_book where  book_category_id = "+book_category_id+" and book_state = 2   order by deploy_datetime desc limit 5 ";
			}
		}
		
		
		
		return super.executeQuery(sql, pageBean);
	}
	
	public List<Map<String, Object>> findBook(Map<String, String[]> mapMap,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_book where  book_state = 2  ";
		String book_category_id = JsonUtils.getParamVal(mapMap, "book_category_id");
		String book_id =JsonUtils.getParamVal(mapMap, "book_id");
		String book_name = JsonUtils.getParamVal(mapMap, "book_name");
		
		if(StringUtils.isNotBlank(book_id)) {
			sql += " and  book_id = "+book_id+"";
		}
		if(StringUtils.isNotBlank(book_category_id)) {
			sql += " and  book_category_id = "+book_category_id+"";
		}
		if(StringUtils.isNotBlank(book_name)) {
			sql += " and  book_name like '%"+book_name+"%' ";
		}
		
		return super.executeQuery(sql, pageBean);
	}
	
	public List<Map<String, Object>> listallbook(Map<String, String[]> mapMap,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_book where  true ";
		String book_category_id = JsonUtils.getParamVal(mapMap, "book_category_id");
		String book_id =JsonUtils.getParamVal(mapMap, "book_id");
		String book_name = JsonUtils.getParamVal(mapMap, "book_name");
		
		if(StringUtils.isNotBlank(book_id)) {
			sql += " and  book_id = "+book_id+"";
		}
		if(StringUtils.isNotBlank(book_category_id)) {
			sql += " and  book_category_id = "+book_category_id+"";
		}
		if(StringUtils.isNotBlank(book_name)) {
			sql += " and  book_name like '%"+book_name+"%' ";
		}
		
		return super.executeQuery(sql, pageBean);
	}
	
	public List<Map<String, Object>> listsales(Map<String, String[]> mapMap,String book_id) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_book where  book_state = 2  ";
		
		if(StringUtils.isNotBlank(book_id)) {
			sql += " and  book_id = "+book_id+"";
		}
		
		return super.executeQuery(sql, null);
	}
	
	
	
	public List<Map<String, Object>> listBook(Map<String, String[]> mapMap,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_book where true ";
		String book_state = JsonUtils.getParamVal(mapMap, "book_state");
		String book_name = JsonUtils.getParamVal(mapMap, "book_name");
		if(StringUtils.isNotBlank(book_state)) {
			sql +=" and book_state = "+book_state;
		}
		if(StringUtils.isNotBlank(book_name)) {
			sql +=" and book_name like  '%"+book_name+"%' ";
		}
		
		sql +=" order by sales_volume desc";
		
		
		return super.executeQuery(sql, pageBean);
	}
	
	
	
	
	
	
	public int addBook(Map<String, String[]> Mapmap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String book_name = JsonUtils.getParamVal(Mapmap, "book_name");
		String book_name_pinyin = PinYinUtil.toPinyin(book_name).toLowerCase();
		String sql = "insert into t_book(book_name,book_name_pinyin,book_category_id,book_author,book_price,publishing,book_desc,book_state,sales_volume) values(?,'"+book_name_pinyin+"',?,?,?,?,?,1,0)";
		
		return super.executeUpdate(sql, new String[] {"book_name","book_category_id","book_author","book_price","publishing","book_desc"}, Mapmap);
	}
	
	public int editimage(Map<String, String[]> paMap,String book_image,String book_id) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String date = new Date().toLocaleString();
		String sql = "update t_book set book_image = '"+book_image+"',book_state = 2,deploy_datetime= str_to_date('"+date+"','%Y-%c-%e %H:%i:%S') where book_id = "+book_id;
		
		
		return super.executeUpdate(sql, new String[] {}, paMap);
	}
	
	public int editsales(Map<String, String[]> paMap,String sales_volume,String book_id) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "update t_book set sales_volume = "+sales_volume+" where book_id="+book_id+" ";
		
		return super.executeUpdate(sql, new String[] {}, paMap);
	}
	
	
	public int editbook(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "update t_book set book_name = ? ,book_category_id = ? ,book_author = ? ,book_price=?,publishing= ?, book_desc=? where book_id=? ";
		
		return super.executeUpdate(sql, new String[] {"book_name","book_category_id","book_author","book_price","publishing","book_desc","book_id"}, paMap);
	}
	
	public int delbook(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "delete from t_book where book_id = ? ";
		
		return super.executeUpdate(sql, new String[] {"book_id"}, paMap);
	}
	
	
	public int editstate(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "update t_book set book_state = 3 where book_id = ? ";
		
		return super.executeUpdate(sql, new String[] {"book_id"}, paMap);
	}
	public int editstate2(Map<String, String[]> paMap) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		String sql = "update t_book set book_state = 2 where book_id = ? ";
		
		return super.executeUpdate(sql, new String[] {"book_id"}, paMap);
	}
	
	
	
	
	
	
	
}
