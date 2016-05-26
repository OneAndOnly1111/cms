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
	var form = $("#updArticleForm");
	form.off();
	form.on("submit",function(){
		//异步提交
		form.ajaxSubmit(function(){
			form[0].reset();  //表单重置
			alert("修改成功！");
			$(".baseUI li :contains('信息管理')").trigger("click"); //模拟点击
		});
		return false;  //阻止form的默认行为
	});
	
	document.getElementById("select").value="${article.c_id}";
    document.getElementById("textarea").value="${article.content}";

});
</script>
<style>
.form{
width:1000px;
height:400px;
border:1px solid #ccc;
margin:0 auto;
margin-top:30px;
font-size:16px;
border-radius:3px;
background-color:#E1F1FF;
}
h1{
  margin:0 0 5px 15px; 
}
#addArticleForm{
margin:10px 0 0 10px;
}
input{
 width:200px;
 height:30px;
 margin:10px;
}
select{
 margin:10px 0;
}
textarea{
 margin-top:10px;
}
.submit{
 width:60px;
 height:25px;
 background-color:#38C9F5;
 margin-left:450px;
 margin-top:20px;
}
</style>
</head>
<body>

<h1>修改信息</h1><hr>
<div class="form">
<form action="updArticle.action" method="post" id="updArticleForm">	
  <input type="hidden" name="id" value="${article.id}"/>
	信息标题：<input type="text" name="title" value="${article.title}"/><br/>
	 信息作者：<input type="text" name="author" value=" ${article.author}"/><br/>
	 所属栏目：<select name="c_id" id="select">
	          <option  value="">-----请选择------</option>
	          <c:forEach items="${categoryList}" var="c">
	              <option value="${c.id}">${c.name}</option>
	          </c:forEach>
	        </select><br/>
	信息内容： <textarea rows="8" cols="50" name="content" id="textarea"></textarea><br/>
	<input type="submit" value="提交" class="submit" />
</form>
</div>
</body>
</html>