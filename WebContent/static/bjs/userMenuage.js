$(function(){
	myf("");
	
	function myf(data){
		$('#dg').datagrid({    
		    url:$("#ctr").val()+'/buserAction.action?methodName=list&user_name='+data+'', 
		    fitColumns:true,
		    fit:true,
		    singleSelect:true,
		    columns:[[    
		        {field:'user_id',title:'编号',width:100},    
		        {field:'user_name',title:'用户名',width:100},    
		        {field:'user_pwd',title:'密码',width:100},    
		        {field:'role_name',title:'角色',width:100},
		        {field:'role_bak',title:'备注',width:100}
		    ]],
		    toolbar: "#tb",
		    
		});
		
	}
	
	
//	$('#dd').dialog({
//		buttons:[{
//			text:'保存',
//			handler:function(){
//				ok();  
//			}
//		},{
//			text:'关闭',
//			handler:function(){}
//		}]
//	})
	
	//一个隐形对象
	obj = {
		
		
		add: function (){
			$('#ff').form('clear');
			$('#str').val('adduser');
			$('#dd').dialog('open');
			
		},
		del: function(){
			
			var row = $('#dg').datagrid('getSelected');
			if(row!=null){
				if(confirm("你是否确定要删除")==1){
					$('#str').val('deluser');
					$("#user_id").val(row.user_id);
					obj.ok();
					
				}
			}
			else{
				alert("请选择一个要删除的");
			}
			
		},
		edit: function(){
			var row = $('#dg').datagrid('getSelected');
			if(row!=null){
				$('#ff').form('clear');
				$("#str").val('edituser');
				$('#dd').dialog('open');
				$('#ff').form('load',row);
				
			}
			else{
				alert("请选择一个要修改的");
			}
			
			
		},
		fasubmit: function(){
			var d = $("#user_name").val();
			myf(d);
			$("#user_name").val("");
			
		},
		ok: function(){
			$('#ff').form('submit',{    
			    url:$("#ctr").val()+'/buserAction.action?methodName='+$("#str").val(),    
			    onSubmit: function(){ 
			    	
			    },    
			    success:function(data){    
			        if(data>>0){
			        	$('#dd').dialog('close');
			        	$('#dg').datagrid('reload');
			        	alert('编辑成功');
			        	$('#ff').form('clear');
			        	
			        }
			        else{
			        	alert('编辑失败');
			        }
			    }    
			}); 
		},
		okb: function(){
			$('#ffb').form('submit',{    
			    url:$("#ctr").val()+'/buserroleAction.action?methodName=adduserrole',    
			    onSubmit: function(){ 
			    	
			    },    
			    success:function(data){    
			        if(data>0){
			        	$('#ddb').dialog('close');
			        	$('#dg').datagrid('reload');
			        	alert('编辑成功');
			        	$('#ffb').form('clear');
			        	
			        }
			        else if(data==-1){
			        	$('#ddb').dialog('close');
			        	$('#dg').datagrid('reload');
			        	alert('该用户已有该角色');
			        }
			        else{
			        	$('#ddb').dialog('close');
			        	$('#dg').datagrid('reload');
			        	alert("编辑失败");
			        }
			    }    
			}); 
		},
		b: function(){
			$("#ff").form('clear');
		},
		addrole: function(){
			var row = $('#dg').datagrid('getSelected');
			if(row!=null){
				
				$('#ffb').form('clear');
				$("#ffb").form('load',row);
				$("#ddb").dialog('open');
				
			}
			else{
				alert("请选择一个用户来为其增添角色");
			}
			
			
			
			
		}
		
		
		
	};
	

	


})