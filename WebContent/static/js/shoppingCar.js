$(function(){
	myf();
	myshop();
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

function myshop(){
	$.post($("#ctr").val()+"/bookAction.action?methodName=shoplist",{},function(str){
		var ss = $.parseJSON(str);
		var sb = "";
      
		sb +="<tr>";
		sb +=" <th width=\"20%\" class=\"bd2\">书名</th>";
		sb +="<th width=\"20%\" class=\"bd2\">单价</th>";
		sb +=" <th width=\"20%\" class=\"bd2\">数量</th>";
		sb +="<th width=\"20%\" class=\"bd2\">小计</th>";
		sb +="<th width=\"20%\" class=\"bd2\">操作</th>";
		sb +="</tr>";
        var i = 0;
        var countprice = 0;
		$.each(ss,function(k,g){
			i++;
			countprice += g.book_price*g.count;
			sb +=" <tr>";
			sb +=" <td width=\"20%\" class=\"text\">"+g.book_name+"</td>";
			sb +=" <td width=\"20%\" class=\"text\">"+g.book_price+"</td>";
			sb +=" <td width=\"20%\" class=\"text\">";
			sb +=" <input class=\"input\" style=\"width: 50px;text-align: center;\" type=\"text\" id=\"a"+g.book_id+"\" value=\""+g.count+"\">";
			sb +=" <td width=\"20%\" class=\"text\">"+g.book_price*g.count+"</td>";
			sb +=" <td width=\"20%\" class=\"text\">";
			sb +=" <a  onclick=\"shopdel("+g.book_id+")\">删除</a>";
			sb +=" <a  onclick=\"shopedit("+g.book_id+")\">更新</a>";
			sb +=" </td>";
			sb +="</tr>";
		})
		if(i==0){
			sb+="<tr>";
			sb+="<td colspan=\"5\">";
			sb+="购物车内还没有你心爱的东西";
			sb+="</td>";
			sb+="</tr>";
		}
		var st = "";
		st+="<tr bgcolor=\"#fefcea\">";
		st+="<td width=\"80%\" align=\"right\"><strong>订单总价：</strong></td>";
		st+="<td width=\"20%\" align=\"left\"><strong><span class=\"STYLE1\">"+countprice+"</span></strong></td>";
		st+="</tr>";
		
 		
		
		$("#tab").html(sb);
		$("#tabs").html(st);
		
		
	})
	
	
}


function myt(id){
	location.href="bookAction.action?methodName=findBook&book_category_id="+id;
}

function shopdel(id){
	$.post($("#ctr").val()+"/bookAction.action?methodName=shopdel",{book_id:id},function(str){
		myshop();
		alert("删除成功");
		
		
	})
}
function shopedit(id){
	var val = $("#a"+id+"").val();
	$.post($("#ctr").val()+"/bookAction.action?methodName=shopedit",{book_id:id,value:val},function(str){
		myshop();
		alert("修改成功");
		
	})
}












