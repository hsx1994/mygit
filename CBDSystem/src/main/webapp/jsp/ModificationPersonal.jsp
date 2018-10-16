<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人信息页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	电&nbsp&nbsp话：&nbsp&nbsp&nbsp<input type="text" name="tel"value=${user.tel}><br>
   	地&nbsp&nbsp址：&nbsp&nbsp&nbsp<input type="text" name="address"value=${user.address}><br>
   	邮&nbsp&nbsp箱：&nbsp&nbsp&nbsp<input type="text" name="email"value=${user.email}><br>
   	职&nbsp&nbsp业：&nbsp&nbsp&nbsp<input type="text" name="job"value=${user.job}><br>
   	
   		<a href=""> <input type="submit" value="完成"></a><br>
  </body>
</html>
