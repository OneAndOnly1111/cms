<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
$(function(){
	$(".upd").off(); //解绑
	$(".upd").on("click",function(){
		var id = $(this).attr("val");		
		$(".right").load("toUpdArticle.action",{id:id}); //点击修改请求toUpdArticle.action
	})
	
	var url="delArticle.action";
	var cc=$(".baseUI li:contains('信息管理')");
	$(".del").off();  //解绑
	$(".del").on("click",function(){
		var id = $(this).attr("val");
		var flag = confirm("确认删除吗？");
		if(flag){
			$.post(url,{id:id},function(){
				//模拟点击
			  cc.trigger("click");
			})
		}
	});
});
</script>
<style>
h1{
  margin:0 0 5px 15px;
}
table{
   margin:10px ;
   width:1150px;;
   border:"1 solid #ccc"; 
   border-collapse: collapse;
   font-size:14px;
}
th{
   background-color:#E1F1FF;
}
th,td{
   text-align:left;
   height:30px;
   border:1px solid #ccc;
   padding:5px;
}
</style>
</head>
<body>
<h1>信息管理</h1><hr>
<table>
    <tr>
       <th>编号</th>
       <th>信息标题</th>
       <th>信息作者</th>
       <th>所属栏目</th>
       <th>信息内容</th>
       <th>操作</th>    
    </tr>
    <c:forEach items="${articleList}" var="c">
       <tr>
          <td><input type="checkbox" value="${c.id}"/></td>
          <td>${c.title}</td>
          <td>${c.author}</td>
          <td>${c.c_id}</td>
          <td>${c.content}</td> 
          <td>
            <a href="javascript:void(0);" val="${c.id}" class="del">删除</a>
            <a href="javascript:void(0);" val="${c.id}" class="upd">修改</a>
         </td> 
       </tr>
    </c:forEach>
</table>
</body>
</html>