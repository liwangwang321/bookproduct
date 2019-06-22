$(function(){
	$('#tt').tree({    
	    url:$("#ctr").val()+'/menuAction.action?methodName=treeMenu&user_id='+$("#user_id").val(), 
	    onClick :function(node){
	    	var content = '<iframe scrolling="no" frameborder="0" src="'+node.attributes.menu_url+'" width="99%" height="99%"></iframe>';
	    	if($('#menuTabs').tabs('exists',node.text)){
	    		$('#menuTabs').tabs('select',node.text)
	    	}else{
	    		$('#menuTabs').tabs('add',{    
		    	    title:node.text,    
		    	    content:content,    
		    	    closable:true,    
		    	    tools:[{    
		    	        iconCls:'icon-mini-refresh',    
		    	        handler:function(){    
		    	            alert('refresh');    
		    	        }    
		    	    }]    
		    	}); 
	    	}
	    	
	    }	
	   
	}); 

})