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
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bjs/userMenuage.js"></script>

</head>
<body>

	<input type="hidden" id="ctr" value="${pageContext.request.contextPath }">
	<input type="hidden" id="str"  >
	
	<div id="tb" style="padding: 5px; height: auto;">
        <div style="margin-bottom: 5px;">
            <a  class="easyui-linkbutton" iconCls="icon-add" onclick="obj.add();">添加</a>
            <a  class="easyui-linkbutton" iconCls="icon-edit" onclick="obj.edit();">修改</a>
            <a  class="easyui-linkbutton" iconCls="icon-remove" onclick="obj.del();" >删除</a>
             <a  class="easyui-linkbutton" iconCls="icon-add" onclick="obj.addrole();" >增添角色</a>
        </div>
        <div style="padding:0 0 0 7px;">
	            用户名：<input type="text" class="textbox"  id="user_name" name = "user_name" style="width:130px;">
	         <!--  用户角色:<input id="cc" class="easyui-combobox" name="role_name"  data-options="valueField:'role_id',textField:'role_name',url:'broleAction.action?methodName=falist'" />  --> 
            <a  class="easyui-linkbutton" iconCls="icon-search" onclick="obj.fasubmit();">查询</a>
          
        </div>
    </div>
 
	<table id="dg"></table> 
	

	
	<div id="dd" class="easyui-dialog" title="添加用户信息" style="width:100%;max-width:400px;padding:30px 60px;"
	 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true" >
	 
		<form id="ff" method="post">
		<input type="hidden" name="user_id" id="user_id" >
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="user_name" style="width:100%" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="user_pwd" style="width:100%" data-options="label:'密码:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input id="role_id" class="easyui-combobox"  name="role_name" data-options="valueField:'role_id',textField:'role_name',url:'broleAction.action?methodName=falist'" />  	
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a  class="easyui-linkbutton" onclick="obj.ok();" style="width:80px" >提交</a>
			<a  class="easyui-linkbutton" onclick="obj.b();" style="width:80px" >清除</a>
		</div>
	</div>
	<div id="ddb" class="easyui-dialog" title="增添角色" style="width:100%;max-width:400px;padding:30px 60px;"
	 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true" >
	 
		<form id="ffb" method="post">
		<input type="hidden" name="user_id" id="user_id" >
			
			<div style="margin-bottom:20px">
				<input id="role_id" class="easyui-combobox"  name="role_name" data-options="valueField:'role_id',textField:'role_name',url:'broleAction.action?methodName=falist'" />  	
			</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a  class="easyui-linkbutton" onclick="obj.okb();" style="width:80px" >提交</a>
			<a  class="easyui-linkbutton" onclick="obj.b();" style="width:80px" >清除</a>
		</div>
	</div>

	

</body>
</html>