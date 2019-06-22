package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.PageBean;

public class CategoryDao extends JsonBaseDao{
	
	public List<Map<String, Object>> list(Map<String, String[]> mapMap,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from t_book_category where true";
		return super.executeQuery(sql, pageBean);
	}

}
