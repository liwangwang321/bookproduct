<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="z" uri="/zking" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>飞凡网上书店</title>
    




<link href="css/main.css" rel="stylesheet" type="text/css" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
    

  </head>
  <body>
	<!--top-->
	
 
 
<div id="top_div">
	
		
		
			
				
				<z:header user="1"  userset="${user }"></z:header>	
				
				
			
		
	
	<div class="fixed"></div>
</div>
   
<div id="header_div">
	<div id="search">
		<!--form的id与下面文本框的id不能修改，因为使用了id选择器定义样式-->
		
	</div>
</div>
 
<!--nav-->
<div id="nav">
	<ul id="menu"></ul>
</div>
<!--end nav-->

	<!--content-->
	<div class="w960 mt10">
		<div class="breadcrumb"></div>
	</div>

	<div class="w960">
		<div class="side left">
			

			<!--nav-->
			<h4>书籍管理</h4>   
	      	<ul class="classify E6">
		      	<li>&nbsp;&nbsp;<a href="addBook.jsp">新&nbsp;&nbsp;增</a></li>
		      	<li>&nbsp;&nbsp;<a href="listBook1.jsp" >未上架</a></li>
		      	<li>&nbsp;&nbsp;<a href="listBook2.jsp">已上架</a></li>
		      	<li>&nbsp;&nbsp;<a href="listBook3.jsp">已下架</a></li>
		      	<div class="fixed"></div>
			</ul>
			<h4>订单管理</h4>        
		    <ul class="classify E6">
		      	<li>&nbsp;&nbsp;<a href="listOrder1.jsp">未发货</a></li>
		      	<li>&nbsp;&nbsp;<a href="listOrder2.jsp">已发货</a></li>
		      	<li>&nbsp;&nbsp;<a href="listOrder3.jsp"  style="font-size: 15px;color: red">已签收</a></li>
		      	<div class="fixed"></div>
			</ul>
			<!--end nav-->

		</div>
    
		<div class="w740 right">
			<div class="o-mt">
	        	<h2>已签收订单</h2>
	        </div>
	        <div class="order01">
	        	<form name="" method="post" action="orderAction.action?methodName=listorder&order_state=3">
	        	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" >
	        		<tr>
	        			<td width="15%" align="right">收货人电话：</td>
	        			<td width="15%">
	        				<input type="text" name="phone" value="" class="w110 input">
	        			</td>
	        			<td width="15%" align="right"></td>
	        			<td width="15%">
	        				<input type="image" name="imageField2" src="images/btn_cx.png" />
	        			</td>
	        			<td width="15%" align="right"></td>
        				<td width="25%"></td>
              		</tr>
			  	</table>
			 	</form>
	        </div>
	        
	       	        <input type="hidden" id="user" value="${user }" />
			 <c:if test="${empty listorderset }">
			 	<jsp:forward page="orderAction.action?methodName=listorder&order_state=3" />
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
	              
	              
	              <c:if test="${not empty listorder }">
	              	<c:forEach items="${listorder }" var="g">
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
		                	<p >已完成交易</p>
		                </td>
		              </tr>
	              		
	              	</c:forEach>
	              </c:if>
	              <c:if test="${empty listorder}">
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
