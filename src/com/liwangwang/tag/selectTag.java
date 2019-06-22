package com.liwangwang.tag;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.beanutils.PropertyUtils;


/**
 * 1.值的传递 ： id name
 * 2.数据源 ： items
 * 3.展示列与数据存储列与实体类的对应关系： textKey textVal
 * 4.数据回显 selectedVal
 * 5.可能下拉框默认值（头标签）headerTextKey  headerTextVal
 * @author Lenovo
 *
 */
public class selectTag extends BodyTagSupport{

	private static final long serialVersionUID = -2985228892464897369L;
	
	private String id;//值的传递 ： id name
	private String name;//值的传递 ： id name
	private List<Object> items = new ArrayList<>();//数据源 ： items
	private String textKey;//展示列与数据存储列与实体类的对应关系： textKey textVal
	private String textVal;//展示列与数据存储列与实体类的对应关系： textKey textVal
	private String selectedVal;//数据回显 selectedVal
	private String headerTextKey;//可能下拉框默认值（头标签）headerTextKey  headerTextVal
	private String headerTextval;//可能下拉框默认值（头标签）headerTextKey  headerTextVal
	
	
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Object> getItems() {
		return items;
	}


	public void setItems(List<Object> items) {
		this.items = items;
	}


	public String getTextKey() {
		return textKey;
	}


	public void setTextKey(String textKey) {
		this.textKey = textKey;
	}


	public String getTextVal() {
		return textVal;
	}


	public void setTextVal(String textVal) {
		this.textVal = textVal;
	}


	public String getSelectedVal() {
		return selectedVal;
	}


	public void setSelectedVal(String selectedVal) {
		this.selectedVal = selectedVal;
	}


	public String getHeaderTextKey() {
		return headerTextKey;
	}


	public void setHeaderTextKey(String headerTextKey) {
		this.headerTextKey = headerTextKey;
	}


	public String getHeaderTextval() {
		return headerTextval;
	}


	public void setHeaderTextval(String headerTextval) {
		this.headerTextval = headerTextval;
	}


	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print(toHtml());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}


	private StringBuffer toHtml() throws Exception {
		StringBuffer sb = new StringBuffer();//一个StringBuffer的类
		
		
		sb.append("<select id='"+id+"' name='"+name+"' >");//开头
		
		if(!(headerTextKey ==null|| headerTextval ==null || "".equals(headerTextKey)||"".equals(headerTextval))) {
			sb.append("<option  value= '"+headerTextKey+"'>");
			sb.append(headerTextval);
			sb.append("</option>");
		}//如果有默认的header就要加上的代码
		Object keyVal;
		Object Val;
		for (Object it : items) {
			keyVal =  PropertyUtils.getProperty(it, textKey);//找到这个对象的属性：id
			keyVal = keyVal+"";
			
			Val =  PropertyUtils.getProperty(it, textVal);//找到这个对象的属性：name
			Val = Val +"";	
			 
			 
			if(keyVal.equals(selectedVal)) {//判断回显的字符串
				sb.append("<option selected  value= '"+keyVal+"'>");
				sb.append(Val);
				sb.append("</option>");
			}
			else {
				sb.append("<option value= '"+keyVal+"'>");
				sb.append(Val);
				sb.append("</option>");
			}
		}
		
		sb.append("</select>");//结尾
		return sb;
	}
	
	
	
	
}
