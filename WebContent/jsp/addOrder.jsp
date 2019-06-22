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
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/addOrder.js"></script>


<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
   
  </head>
  
  <body>
	<!--top-->
	
<input type="hidden" id="ctr" value="${pageContext.request.contextPath }" />
<input type="hidden" id="user" value="${user }" />

<div id="top_div">
	
		
		
			
				
					<z:header user="2" userset="${user }"></z:header>	
				
				
			
		
	
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

	<!--con-->
	<div class="w960 mt10">
	 	<div class="side left" id="ta">
			


		</div>
		<div class="w740 right">
			<div class="o-mt">
	        	<h2>订单新增</h2>
	        </div>
	        <div class="order02 pb10">
	        	<form action="orderAction.action?methodName=addorder" method="post">
	        	<table width="738" align="center" cellpadding="0" cellspacing="0">
	        		<input type="hidden" name="user_id" value="${user.user_id }" />
	        		<input type="hidden" name="shoptype" value="${shoptype }" />
	        		<tr class="bd2">
	        			<th width="20%" align="center" class="bd2">收货人</td>
	        			<td width="80%"  align="left" class="bd1 pl9" >
	        				<input type="text" name="consignee" value="" id="consignee" class="input w300"><span class="required">*</span>
	        			</td>
	        		</tr>
	        		<tr class="bd2">
	        			<th width="20%" align="center" class="bd2">收货人电话</td>
	        			<td width="80%"  align="left" class="bd1 pl9" >
	        				<input type="text" name="phone" value="" id="phone" class="input w300"><span class="required">*</span>
	        			</td>
	        		</tr>
	        		<tr class="bd2">
	        			<th width="20%" align="center" class="bd2">收货人邮编</td>
	        			<td width="80%"  align="left" class="bd1 pl9" >
	        				<input type="text" name="postalcode" value="" id="postalcode" class="input w300"><span class="required">*</span>
	        			</td>
	        		</tr>
	        		<tr class="bd2">
	        			<th width="20%" align="center" class="bd2">收货人地址</td>
	        			<td width="80%"  align="left" class="bd1 pl9" >
	        				<input type="text" name="address" value="" id="address" class="input w300"><span class="required">*</span>
	        			</td>
	        		</tr>
	        		
	        		<tr class="bd2">
	        			<th width="20%" align="center" class="bd2">发货方式</td>
	        			<td width="80%"  align="left" class="bd1 pl9">
	        				<select name="send_type" id="send_type" style="width:305px;"><option value="-1">--请选择--</option>
	        					<option value="1">平邮</option>
	        					<option value="2">快递</option></select><span class="required">*</span>
	        			</td>
	        		</tr>
	        	</table>
	        	
	        	<table width="738" border="0" cellspacing="0" cellpadding="0" class="mt10" align="center">
	        		<tr>
	        			<td width="20%" align="center" class="bd2"></td>
	        			<td width="80%" align="left" class="pl9" >
	        				<input type="submit" value="确定" class="btn"/>
	        			</td>
	        		</tr>
        		</table>
        		</form>
       		</div>
		</div>    
	 <div class="fixed"></div>   
	</div>
	<!--end con-->

	<!--footer-->
	
<div id="footer_wrap">
	<p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

	<!--end footer-->
</body>
</html>
