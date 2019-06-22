$(function(){
	myf("");
	
	
	
	function myf(role_name){
		$('#dg').datagrid({    
		    url:$("#ctr").val()+'/broleAction.action?methodName=list&role_name='+role_name+'', 
		    fitColumns:true,
		    fit:true,
		    singleSelect:true,
		    columns:[[    
		        {field:'role_id',title:'角色编号',width:100},    
		        {field:'role_name',title:'角色名',width:100},    
		        {field:'role_bak',title:'备注',width:100},    
		    ]],
		    toolbar: "#tb",
		    
		});
		
	}
	
	
	obj = {
			add: function (){
				$('#ff').form('clear');
				$('#str').val('addrole');
				$('#dd').dialog('open');
				
			},
			del: function(){
				
				var row = $('#dg').datagrid('getSelected');
				if(row!=null){
					if(confirm("你是否确定要删除")==1){
						$('#str').val('delrole');
						$('#role_id').val(row.role_id);
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
					
					$('#ffb').form('clear');
					$("#str").val('editrole');
					
					$('#ddb').dialog('open');
					$('#ffb').form('load',row);
				}
				else{
					alert("请选择一个要修改的");
				}
				
				
			},
			fasubmit: function(){
				var d = $("#role_name").val();
				myf(d);
				$("#role_name").val("");
				
			},
			ok: function(){
				$('#ff').form('submit',{    
				    url:$("#ctr").val()+'/broleAction.action?methodName='+$("#str").val(),    
				    onSubmit: function(){ 
				    	
				    },    
				    success:function(data){    
				        if(data>0){
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
			okb:function(){
				$('#ffb').form('submit',{    
				    url:$("#ctr").val()+'/broleAction.action?methodName='+$("#str").val(),    
				    onSubmit: function(){ 
				    	
				    },    
				    success:function(data){    
				        if(data>0){
				        	$('#ddb').dialog('close');
				        	$('#dg').datagrid('reload');
				        	alert('编辑成功');
				        	$('#ffb').form('clear');
				        	
				        }
				        else{
				        	alert('编辑失败');
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
					
					
					$('#dtree').dialog('open');
					obj.treesubmit(row.role_id);
				}
				else{
					alert("请选择一个要进行授权的");
				}
				
				
			},
			treesubmit: function(role_id){
				
				$('#tree').tree({    
				    url:'menuAction.action?methodName=btreeMenu&role_id='+role_id, 
				    checkbox:true,
				    onlyLeafCheck:true,
				    onCheck:function (node,checked){
				    	$.post('bmenuroleAction.action?methodName=editstate',{"role_id":role_id,"menu_id":node.id,"checked":checked},function(str){
				    		if(str>0){
				    			
				    		}
				    		else{
				    			alert("修改失败");
				    		}
				    	})
				    	
				    	
				    },
				}); 
				
			},
			okc: function(){
				
				$('#dtree').dialog('close');
				
				
			}
			
			
	}
	
	
	
	
})