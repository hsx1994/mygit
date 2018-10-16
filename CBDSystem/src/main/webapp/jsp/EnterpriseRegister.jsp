<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>企业用户注册页面</title>
    
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
     <form action="personl.do" method="POST">
         用户名：&nbsp&nbsp&nbsp&nbsp<input type="text"name="name"value=${user.name}><br>
         密&nbsp&nbsp码：&nbsp&nbsp&nbsp<input type="text" name="pass"value=${user.pass}><br>
   	 企业名：&nbsp&nbsp&nbsp&nbsp<input type="text" name="comName"value=${user.comName}><br>
   	 电&nbsp&nbsp话：&nbsp&nbsp&nbsp<input type="text" name="tel"value=${user.tel}><br>
   	 楼层号：&nbsp&nbsp&nbsp<input type="text" name="address"value=${user.address}><br>
   	 联系人姓名：&nbsp&nbsp<input type="text" name="contact"value=${user."contact"}><br>
   	
   	  <button>获取短信验证码</button>&nbsp<input type="text" name="code"><br>
   	  <input type="submit" value="完成"><br>
   </form>
  
  </body>
</html>
