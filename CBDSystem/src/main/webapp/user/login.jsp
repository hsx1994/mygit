<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录界面</title>
<link href="" rel="stylesheet" type="text/css" />
</head>
<body>
	<span style="color: red;">${errorMsg}</span>
	<form id="form1" action="/CBDSystem/login.do" method="post">
		
		<span><a href="register.jsp">用户注册</a></span> <br/><br/>
		
		<span class="left login-text">用户名：</span>
		<span style="left"> 
			<input id="Text1" type="text" class="txt" name="name" value="${user.userName }"/>
		</span>
		<br/><br/>
		
		<span class="left login-text">密&nbsp;&nbsp; 码：</span> 
		<span style="left"> 
			<input id="Text2" type="password" class="txt" name="password" />
		</span>
		<br/><br/>
		
		<span class="left login-text">验证码：</span> 
		<span style="left">
				<input id="Text3" type="text" class="txt" name="checkcode" style="width: 90px" />
		</span>
        <br/>

        
        <input type="submit"  value="登录">
         <br/>
        <br/>
        <br/>
        <br/>
        <span>CBD停车场系统</span>
	</form>
</body>
</html>

