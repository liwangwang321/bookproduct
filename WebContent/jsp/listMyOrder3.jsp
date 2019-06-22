<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="z" uri="/zking" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>飞凡网上书店</title>
    




<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.3.1.js"></script> 
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
    

  </head>
  <body>
	<!--top-->
	


<div id="top_div">
	
		
		
			
				
		<z:header user="2"  userset="${user }"></z:header>	
				
				
			
		
	
	<div class="fixed"></div>
</div>
   
<div id="header_div">
	<div id="search">
		<!--下面form标签的id属性不能修改，因为在css中使用了一个id选择器-->
		<form id="form" action="bookAction.action?methodName=findBook" method="post">
		<table width="413" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<input type="text" name="book_name" value="" id="input">
				</td>
				<td>
					<input type="image" name="imageField" src="images/btn_search.png" />
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>

<!--nav-->
<div id="nav">
	<ul id="menu">
		<li><a href="${pageContext.request.contextPath }/jsp/index.jsp">首页</a></li>
		<li><a href="${pageContext.request.contextPath }/jsp/findBook.jsp">书城</a></li>
		<li><a href="${pageContext.request.contextPath }/jsp/shoppingCar.jsp">购物车<span class="badge" id="sb">${shoplist.size() }</span></a></li>
	</ul>
</div>
<!--end nav-->

	<!--end top-->

	<!--content-->
	<div class="w960 mt10">
		<div class="breadcrumb"></div>
	</div>

	<div class="w960">
		<div class="side left">
			

						<!--nav-->
			<h4>我的订单</h4>        
		    <ul class="classify E6">
		      	<li>&nbsp;&nbsp;<a href="listMyOrder1.jsp">未发货</a></li>
		      	<li>&nbsp;&nbsp;<a href="listMyOrder2.jsp" >已发货</a></li>
		      	<li>&nbsp;&nbsp;<a href="listMyOrder3.jsp" style="font-size: 15px;color: red ">已签收</a></li>
		      	<div class="fixed"></div>
			</ul>
			<!--end nav-->

		</div>
    
		<div class="w740 right">
			<div class="o-mt">
	        	<h2>已签收订单</h2>
	        </div>
			  <input type="hidden" id="user" value="${user }" />
			 <c:if test="${empty listmyorderset }">
			 	<jsp:forward page="orderAction.action?methodName=listMyorder&order_state=3&user_id=${user.user_id }" />
			 </c:if>
			        
	        <div class="order02">
	        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	              <tr>
	                <th width="10%" class="bd2">下单日期</th>
	                <th width="15%" class="bd2">收货人</th>
	                <th width="15%" class="bd2">收货人电话</th>
	                <th width="15%" class="bd2">收货人邮编</th>
	                <th width="15%" class="bd2">收货人地址</th>
	                <th width="10%" class="bd2">发货方式</th>
	                <th width="10%" class="bd2">订单总价</th>
	                <th width="10%" class="bd2">状态</th>
	              </tr>
	              
	              
	              <c:if test="${not empty listmyorder }">
	              	<c:forEach items="${listmyorder }" var="g">
		              <tr>
		                <td width="10%" class="text">${g.order_datetime}</td>
		                <td width="15%" class="text">${g.consignee }</td>
		                <td width="15%" class="text">${g.phone }</td>
		                <td width="15%" class="text">${g.postalcode }</td>
		                <td width="15%" class="text">${g.address }</td>
		                <td width="10%" class="text">
		                	<c:if test="${g.send_type==1 }">
		                		平邮
		                	</c:if>
		                	<c:if test="${g.send_type==2 }">
		                		快递
		                	</c:if>
		                </td>
		                <td width="10%" class="text">￥${g.order_price }</td>
		                <td width="10%" class="text">
		                	<a >完成</a>
		                </td>
		              </tr>
	              		
	              	</c:forEach>
	              </c:if>
	               <c:if test="${empty listmyorder}">
	              	 <tr>
		                <td>暂无订单</td>
		               
		              </tr>
	              </c:if>
	              
	              
	            </table>
	        </div>
	        
	        <!-- page -->
	   	  		<z:page pageBean="${pageBean }"></z:page>
	        <!-- end page -->
	    </div>
 		<div class="fixed"></div>   
	</div>
	<!--end content-->

	<!--footer-->
	
<div id="footer_wrap">
	<p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

	<!--end footer-->
</body>
</html>
