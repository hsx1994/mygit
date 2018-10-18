<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/public/jquery.1.9.1.js"></script>

  </head>
  
  <body>
    <form>
    	<input type="text" name="loginname" id="loginname"><br/>
    	<input type="password" name="passworde" id="password"><br/>
    	<input type="button" value="登录" onclick="login()">
    </form>
  </body>
  <script type="text/javascript">
  	function login(){
  		$.ajax({
  			url:"login.do",
  			type:"post",
  			async:true,
  			data:{
  				"name":$("#loginname").val(),
  				"password":$("#password").val()
  			},
  			dataType:"json",
  			success:function(data){
  				if(data.result==true){
  					alert("登录成功");
  				}
  			}
  		})
  		
  	}
  </script>
</html>
