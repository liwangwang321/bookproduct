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
		<!--下面form标签的id属性不能修改，因为在css中使用了一个id选择器-->
		<form id="form">
		<table width="413" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td>
					<input type="text" name="" value="" id="input">
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
	<ul id="menu"></ul>
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
		      	<li>&nbsp;&nbsp;<a href="#1">未发货</a></li>
		      	<li>&nbsp;&nbsp;<a href="#">已发货</a></li>
		      	<li>&nbsp;&nbsp;<a href="#">已签收</a></li>
		      	<div class="fixed"></div>
			</ul>
			<!--end nav-->

		</div>
    
		<div class="w740 right">
			
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
