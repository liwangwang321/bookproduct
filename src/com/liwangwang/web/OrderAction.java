package com.liwangwang.web;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liwangwang.dao.BookDao;
import com.liwangwang.dao.OrderDao;
import com.liwangwang.dao.OrderItemDao;
import com.liwangwang.util.PageBean;
import com.zking.framework.ActionSupport;

public class OrderAction extends ActionSupport{
	private OrderDao od = new OrderDao();
	
	public String addorder(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			HttpSession session = req.getSession();
			OrderItemDao oid = new OrderItemDao();//订单项的实列
			BookDao bd = new BookDao();
			String shopname;
			if(req.getParameter("shoptype").equals("1")) {
				shopname = "myshoplist";
			}
			else {
				shopname="shoplist";
			}
			
			List<Map<String, Object>> shops = (List<Map<String, Object>>) session.getAttribute(shopname);//存储着的集合
			List<Map<String, Object>> list = od.list(new HashMap() , null);
			int order_id = list.size()+1;//订单的id
			int countprice = 0;//一个订单的总价
			int sales = 0;//销量
			for (Map<String, Object> map : shops) {//算出总价
				countprice+= (float)map.get("book_price")*(int)map.get("count");
			}
			int oi = od.addOrder(req.getParameterMap(), countprice+"",order_id+"");//形成订单
			if(oi>0) {
				
				for (Map<String, Object> map : shops) {
					List<Map<String, Object>> listsales = bd.listsales(req.getParameterMap(), (long)map.get("book_id")+"");
					sales = (int)listsales.get(0).get("sales_volume");
					sales = sales+(int)map.get("count");
					bd.editsales(req.getParameterMap(), sales+"",(long)map.get("book_id")+"");//在完成一个订单的时候进行对书本销量的增加
					oid.addOrderItem(req.getParameterMap(), order_id+"", (long)map.get("book_id")+"", (int)map.get("count")+"");//增加订单详细表
				}
				
				session.setAttribute(shopname, null);
			}
			else {
				System.out.println("失败");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "shopping";
	}
	
public String listMyorder(HttpServletRequest req,HttpServletResponse resp) {
		try {
			PageBean pageBean = new PageBean();
			pageBean.setRows(5);
			pageBean.setRequest(req);
			List<Map<String, Object>> list = od.list(req.getParameterMap(), pageBean);
			String order_state = req.getParameter("order_state");
			req.setAttribute("listmyorderset", "listmyorderset");
			req.setAttribute("pageBean", pageBean);
			req.setAttribute("listmyorder", list);
			if("1".equals(order_state)) {
				return "listMyOrder1";
			}
			else if("2".equals(order_state)) {
				return "listMyOrder2";
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "listMyOrder3";
	}
//查找后台所需的一些订单信息
public String listorder(HttpServletRequest req,HttpServletResponse resp) {
	try {
		PageBean pageBean = new PageBean();
		pageBean.setRows(5);
		pageBean.setRequest(req);
		List<Map<String, Object>> list = od.list(req.getParameterMap(), pageBean);
		String order_state = req.getParameter("order_state");
		req.setAttribute("listorderset", "listorderset");
		req.setAttribute("pageBean", pageBean);
		req.setAttribute("listorder", list);
		if("1".equals(order_state)) {
			return "listOrder1";
		}
		else if("2".equals(order_state)) {
			return "listOrder2";
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listOrder3";
}

//发货，修改订单状态，从1变为2
public String editstate(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		int editstate = od.editstate(req.getParameterMap());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listOrder1";
}
//签收，修改订单状态，从2变为3
public String editstate2(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		int editstate = od.editstate2(req.getParameterMap());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listMyOrder2";
}
//撤单，删除订单
public String delorder(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		int editstate = od.delorder(req.getParameterMap());
		int delorderitem = od.delorderitem(req.getParameterMap());
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listMyOrder2";
}

	
	
}
