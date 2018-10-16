<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <meta charset="UTF-8">
    <base href="<%=basePath%>">
    
    <title>分页注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/public/jquery.1.9.1.js"></script>
  </head>
  
  <body>
  
  	欢迎注册
    <br>
   <%--  <br>
  	用户名：<input type="text" id="username" name="username"value="${user.name}"><br>
  	密&nbsp码：<input type="text" id="password" name="password"value="${user.pass}"> --%>
    <br>
   	 点击前往完善信息：<br>
	<a href="jsp/PersonalRegister.jsp"> <button type="submit" >个人用户注册</button> </a><br>
	
	  <a href="jsp/EnterpriseRegister.jsp"> <button type="submit">企业用户注册</button> </a>
	  
	<!-- <script>
		function send(){
			$.ajax({
				url:"/CBDSystem1/personl.do",
				type:"post",
				async:true,
				data:"name=xiaowang&pwd=123",
				success:function(){
					alert();
				}
			});
		}
		
		function send1(){
			
			var jsonobj = {"name":"xiaowang","pwd":999};
			$.ajax({
				url:"/SpringMVC05/test/reg2.do",
				type:"post",
				async:true,
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(jsonobj),
				success:function(message){
					console.info(message);
				}
			});
		}
	</script> -->
	  </body>
</html>
