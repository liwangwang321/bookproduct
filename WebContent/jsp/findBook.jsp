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
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/findBook.js"></script>
<script type="text/javascript">

</script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
  </head>
  
  <body>
	<!--top-->

<input type="hidden" id="ctr" value="${pageContext.request.contextPath }" />
<input type="hidden" id="user" value="${user }" />

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

	<!--con-->
<div class="w960 mt10">
 	<div class="side left" id="ta">
			

			
		</div>
    
	<div class="w740 right">
	 <c:if test="${empty listset }">
	 	<jsp:forward page="bookAction.action?methodName=findBook" />
	 </c:if>
	<c:if test="${not empty pageBean }">
		<z:page pageBean="${pageBean }"></z:page> 
	</c:if>
	
    	<div class="order02 pb10">
    		
    		<c:if test="${not empty bookList }">
	    		<c:forEach items="${bookList }" var="g">
	    			<dl class="findbook">
		            	<dt class="left"><img style="width: 138px;height: 188px" src="imgs/${g.book_image }" /></dt>
		                <dd class="right">
		                	<h4>${g.book_name }</h4>
		                    <p><strong>作者：</strong>${g.book_author }</p>
		                    <p><strong>价格：</strong>￥${g.book_price }</p>
		                    <p><strong>出版社：</strong>${g.publishing }</p>
		                    <p><strong>书籍简介：</strong>${g.book_desc }</p>
		                    <p class="mt10"><a onclick="myshopping(${g.book_id})"><img  src="images/btn_shopping.png" /></a> 
		                    <a onclick="myorder(${g.book_id })" ><img src="images/btn_accounts.png" /></a> </p>
		                </dd>
		                <div class="fixed"></div>
		            </dl>
	    			
	    		</c:forEach>
    		</c:if>
    		<c:if test="${ empty bookList }">
    			<dl class="findbook">
		            	<h2>暂无该类图书</h2>
		                <div class="fixed"></div>
		            </dl>
    		</c:if>
    		
        	
            
        	
            
    	</div> 
	
		<!-- page -->
       
        <!-- end page -->
    
    </div> 
 <div class="fixed"></div>   
</div>
<!--end con-->
	<!--end con-->

	<!--footer-->
	
<div id="footer_wrap">
	<p>Copyright ©2014 飞凡教育，版权所有</p>
</div>

	<!--end footer-->
</body>
</html>
