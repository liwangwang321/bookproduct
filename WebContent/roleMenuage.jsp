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
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bjs/roleMenuage.js"></script>
</head>
<body>
	<input type="hidden" id="ctr" value="${pageContext.request.contextPath }">
	<input type="hidden" id="str"  >
	
	<div id="tb" style="padding: 5px; height: auto;">
        <div style="margin-bottom: 5px;">
            <a  class="easyui-linkbutton" iconCls="icon-add" onclick="obj.add();">添加</a>
            <a  class="easyui-linkbutton" iconCls="icon-edit" onclick="obj.edit();">修改</a>
            <a  class="easyui-linkbutton" iconCls="icon-remove" onclick="obj.del();" >删除</a>
             <a  class="easyui-linkbutton" iconCls="icon-add" onclick="obj.addrole();" >角色授权</a>
        </div>
        <div style="padding:0 0 0 7px;">
	            角色名称：<input type="text" class="textbox"  id="role_name" name = "role_name" style="width:130px;">
	         <!--  用户角色:<input id="cc" class="easyui-combobox" name="role_name"  data-options="valueField:'role_id',textField:'role_name',url:'broleAction.action?methodName=falist'" />  --> 
            <a  class="easyui-linkbutton" iconCls="icon-search" onclick="obj.fasubmit();">查询</a>
          
        </div>
    </div>

<table id="dg"></table> 

	<div id="dd" class="easyui-dialog" title="添加用户信息" style="width:100%;max-width:400px;padding:30px 60px;"
		 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true" >
		 
		<form id="ff" method="post">
		<input type="hidden" name="id" id="role_id" >
			<div style="margin-bottom:20px">
				<input class="easyui-textbox"   name="role_id" style="width:100%" data-options="label:'编号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="role_name"  name="role_name" style="width:100%" data-options="label:'角色名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="role_bak"  name="role_bak" style="width:100%" data-options="label:'备注:',required:true">
			</div>

		</form>
		<div style="text-align:center;padding:5px 0">
			<a  class="easyui-linkbutton" onclick="obj.ok();" style="width:80px" >提交</a>
			<a  class="easyui-linkbutton" onclick="obj.b();" style="width:80px" >清除</a>
		</div>
	</div>
	
	<div id="ddb" class="easyui-dialog" title="添加用户信息" style="width:100%;max-width:400px;padding:30px 60px;"
		 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true" >
		 
		<form id="ffb" method="post">
		<input type="hidden" name="role_id" id="role_id" >
			
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="role_name"  name="role_name" style="width:100%" data-options="label:'角色名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" id="role_bak"  name="role_bak" style="width:100%" data-options="label:'备注:',required:true">
			</div>

		</form>
		<div style="text-align:center;padding:5px 0">
			<a  class="easyui-linkbutton" onclick="obj.okb();" style="width:80px" >修改</a>
		</div>
	</div>
	
	<div id="dtree" class="easyui-dialog" title="添加用户信息" style="width:100%;max-width:400px;padding:30px 60px;"
		 data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true" >
		 
		<ul id="tree"></ul>
		<div style="text-align:center;padding:5px 0">
			<a  class="easyui-linkbutton" onclick="obj.okc();" style="width:80px" >授权</a>
		</div>
	</div>

</body>
</html>