<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/js/easyui5/themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/static/js/easyui5/themes/icon.css">   
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/easyui5/jquery.min.js"></script>   
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/easyui5/jquery.easyui.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bjs/index.js"></script>


</head>
<body class="easyui-layout">
	<input type="hidden" id="ctr" value="${pageContext.request.contextPath }">
<input type="hidden" id="user_id" value="${user_id }" >
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">
		欢迎使用本系统
		<ul id="tt"></ul>
	</div>
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	<div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
	<div data-options="region:'center',title:'Center'">
	<div id="menuTabs" class="easyui-tabs" style="width:100%;height:100%;">   
    <div title="Tab1" style="padding:20px;display:none;">   
        欢迎使用    
    </div>   
</div>  
	</div>
</body>
</html>