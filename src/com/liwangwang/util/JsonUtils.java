package com.liwangwang.util;

import java.util.Arrays;
import java.util.Map;

/**
 * 专门用来处理json数据的工具包
 * @author Administrator
 *
 */
public class JsonUtils {
	/**
	 * 从paramMap拿到咱们所需要用到的查询维度，用于sql语句拼接
	 * @param paramMap	获取从jsp页面传递到后台的参数集合（req.getParamterMap）
	 * @param key
	 * @return
	 */
	public static String getParamVal(Map<String,String[]> paramMap, String key) {
		if(paramMap != null && paramMap.size()>0) {
			String[] vals = paramMap.get(key);
			if(vals != null && vals.length > 0) {
				String val = Arrays.toString(vals);
				return val.substring(1, val.length()-1);
			}
			return "";
		}
		return "";
	}
}
