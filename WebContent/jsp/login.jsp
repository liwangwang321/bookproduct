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
<script type="text/javascript">
	$(function(){
		
		if($("#sd").val()==1){
			alert("登录失败");
		}
		if($("#sd").val()==2){
			alert("注册成功");
		}
		
	})

</script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
    

   
  </head>
  
  <body>
	<!--top-->
	
<input type="hidden" id="sd" value="${ser }" />

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
	<div class="logoin_wrap mt30">
		<h2>用户登陆</h2>
		<div id="table">
			<form action="userAction.action?methodName=login" method="post"  >
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr><td height="30px"></td></tr>
			</table>
			<table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="44%" align="right" valign="middle" class="f14">用户名：</td>
					<td width="56%" align="left" valign="middle">
						<input type="text" name="name" value="" id="name" class="input w180">
					</td>
				</tr>
			</table>
			<table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="44%" align="right" valign="middle" class="f14">密&nbsp;&nbsp;码：</td>
					<td width="56%" align="left" valign="middle">
						<input type="password" name="pwd" value="" id="pwd" class="input w180">
					</td>
				</tr>
			</table>
			
			<table width="100%" height="35" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td width="44%" align="right" valign="middle" class="f14"></td>
					<td width="56%" align="left" valign="middle">
						<!-- 图片按钮，与type=submit按钮的效果是一样，也可以用来提交表单 -->
						<input type="image" src="images/admin_dl.png" />
					</td>
				</tr>
			</table>
			
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr><td>&nbsp;</td></tr>
			</table>
			</form>
	    </div>
	</div>
	<!--end content-->
	
	<!--footer-->
	
<div id="footer_wrap">
	<p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

	<!--end footer-->
</body>
</html>
