<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	var form = $("#updCategoryForm");
	form.off();
	form.on("submit",function(){
		//异步提交
		form.ajaxSubmit(function(){
			form[0].reset();  //表单重置
			alert("修改成功！");
			$(".baseUI li :contains('栏目管理')").trigger("click"); //模拟点击
		});
		return false;  //阻止form的默认行为
	});
});
</script>
<style>
.form{
width:1000px;
height:300px;
border:1px solid #ccc;
text-align:center;
margin:0 auto;
margin-top:30px;
font-size:16px;
border-radius:3px;
background-color:#E1F1FF;
}
#updCategoryForm{
margin-top:60px;
}
h1{
  margin:0 0 5px 15px; 
}
input{
 width:200px;
 height:30px;
 margin:10px;
}
.submit{
 width:60px;
 height:25px;
 background-color:#38C9F5;
 margin-left:230px;
}
</style>
</head>
<body>

<h1>修改栏目</h1><hr>
<div class="form">
<form action="updCategory.action" method="post" id="updCategoryForm">	
    <input type="hidden" name="id" value="${category.id}"/>
	栏目名称：<input type="text" name="name" value="${category.name}"/><br/>
	 栏目编号：<input type="text" name="code" value="${category.code}"/><br/>
	<input type="submit" value="提交" class="submit" />
</form>
</div>
</body>
</html>