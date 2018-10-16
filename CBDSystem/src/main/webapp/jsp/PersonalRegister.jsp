<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
   <%--  <base href="<%=basePath%>"> --%>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>个人用户注册页面</title>
    
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
  
     
    
 <form action="/CBDSystem/personl.do" method="POST">
       
       请选择角色：1.包租用户，2.抢租用户<br>
        角色编号：&nbsp&nbsp&nbsp<input type="text" name="role"value=${user.role}><br/><br/>
        用户名：&nbsp&nbsp&nbsp&nbsp<input type="text"name="name"value=${user.name}><br/><br/>
        密&nbsp&nbsp码：&nbsp&nbsp&nbsp<input type="text" name="pass"value=${user.pass}><br/><br/>
   	真实姓名：&nbsp&nbsp&nbsp<input type="text" name="realName"value=${user.realName}><br/><br/>
   	电&nbsp&nbsp话：&nbsp&nbsp&nbsp<input type="text" name="tel"value=${user.tel}><br/><br/>
   	地&nbsp&nbsp址：&nbsp&nbsp&nbsp<input type="text" name="address"value=${user.address}><br/><br/>
   	身份证号：&nbsp&nbsp&nbsp<input type="text" name="idcard"value=${user.idcard}><br/><br/>
   	邮&nbsp&nbsp箱：&nbsp&nbsp&nbsp<input type="text" name="email"value=${user.email}><br/><br/>
   	职&nbsp&nbsp业：&nbsp&nbsp&nbsp<input type="text" name="job"value=${user.job}><br/><br/>
   	交易完成次数：&nbsp<input type="text" name="orderCount"value=${user.orderCount}><br/><br/>
   	被投诉次数：&nbsp&nbsp<input type="text" name="complaintCount"value=${user.complaintCount}><br/><br/>
   	<button>获取短信验证码</button>&nbsp<input type="text" name="code"><br/><br/>
   	<input type="submit" value="完成"><br>
   </form>
  	<c:forEach items="${allErrors }" var="obj">
		${obj.defaultMessage }
	</c:forEach>
  </body>
</html>
