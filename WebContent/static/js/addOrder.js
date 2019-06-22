$(function(){
	myf();
})


function myf(){
	$.post($("#ctr").val()+"/categoryAction.action?methodName=list",{},function(str){
		var ss = $.parseJSON(str);
		var sb = "";
		sb += "<h3>图书分类</h3>";
		sb += "<ul class=\"classify bgf7e4e4 bdf7e4e4\">";
		sb+="<li> <a  onclick=\"myt('book_category_id')\">全部</a></li>";
		$.each(ss,function(k,g){
			sb+="<li> <a  onclick=\"myt("+g.book_category_id+")\">"+g.book_category_name+"</a></li>";
		})
		
		sb +="<div class=\"fixed\"></div>";
		sb += "</ul>";
		
		$("#ta").html(sb);
		
	})
	
}
function myt(id){
	location.href="bookAction.action?methodName=findBook&book_category_id="+id;
}