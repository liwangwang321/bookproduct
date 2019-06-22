$(function(){
	myf();
	ma(null,"sales_volume");
	mb(null,"deploy_datetime");
})

function myf(){
	$.post($("#ctr").val()+"/categoryAction.action?methodName=list",{},function(str){
		var ss = $.parseJSON(str);
		var sb = "";
		sb += "<h3>图书分类</h3>";
		sb += "<ul class=\"classify bgf7e4e4 bdf7e4e4\">";
		sb+="<li> <a  onclick=\"myt(null)\">全部</a></li>";
		$.each(ss,function(k,g){
			sb+="<li> <a  onclick=\"myt("+g.book_category_id+")\">"+g.book_category_name+"</a></li>";
		})
		
		sb +="<div class=\"fixed\"></div>";
		sb += "</ul>";
		
		$("#ta").html(sb);
		
	})
	
}

function myt(id){
	ma(id,"sales_volume");
	mb(id,"deploy_datetime");
}

function ma(id,type){
	$.post($("#ctr").val()+"/bookAction.action?methodName=indexlist",{book_category_id:id,type:type},function(str){
		var ss = $.parseJSON(str);
		var sb = "";
		sb += "<h2>";
		sb += "<cite class=\"left\">热销图书</cite>";
		sb += "<div class=\"fixed\"></div> ";
		sb += "</h2>";
		sb += "<ul class=\"arivals\">";
		var i = 0;
		$.each(ss,function(k,g){
			i++;
			sb += "<li>";
			sb += "<a onclick=\"myfind('"+g.book_name+"')\"><img src=\"imgs/"+g.book_image+"\" /></a><p >"+g.book_name+"</p><p class=\"red\">￥"+g.book_price+"</p>";
			sb += "</li>";
		})
		if(i==0){
			sb+="<h2>暂无该类图书</h2>";
		}
		sb += "<div class=\"fixed\"></div> ";
		sb += "</ul>";
		
		$("#tc").html(sb);
    
		
	})
	
	
}

function myfind(name){
	$("#input").val(name);
	$("#form").submit();
	
	
}

function mb(id,type){
	
	$.post($("#ctr").val()+"/bookAction.action?methodName=indexlist",{book_category_id:id,type:type},function(str){
		var ss = $.parseJSON(str);
		var sb = "";
		sb += "<h2>";
		sb += "<cite class=\"left\">新书上架</cite>";
		sb += "<div class=\"fixed\"></div> ";
		sb += "</h2>";
		sb += "<ul class=\"arivals\">";
		var i = 0;
		$.each(ss,function(k,g){
			i++;
			sb += "<li>";
			sb += "<a onclick=\"myfind('"+g.book_name+"')\"><img src=\"imgs/"+g.book_image+"\" /></a><p >"+g.book_name+"</p><p class=\"red\">￥"+g.book_price+"</p>";
			sb += "</li>";
		})
		if(i==0){
			sb+="<h2>暂无该类图书</h2>";
		}
		sb += "<div class=\"fixed\"></div> ";
		sb += "</ul>";
		
		$("#tb").html(sb);
    
		
	})
}





