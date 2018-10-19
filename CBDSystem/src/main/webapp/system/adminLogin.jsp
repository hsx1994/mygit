<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理登录界面</title>
<link href="/CBDSystem/static/css/alogin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<span style="color: red;">${errorMsg}</span>
	<form id="form1" action="/CBDSystem/admin/login.do" method="post">
		<div class="Main">
			<ul>
				<li class="top"></li>
				<li class="top2"></li>
				<li class="topA"></li>
				<li class="topB"><span><img
						src="/CBDSystem/static/images/login/logo.gif" alt="" style="" /></span></li>
				<li class="topC"></li>
				<li class="topD">
					<ul class="login">
						<li><span class="left login-text">用户名：</span> <span
							style="left"> <input id="Text1" type="text" class="txt"
								name="name" />

						</span></li>
						<li><span class="left login-text">密&nbsp;&nbsp; 码：</span> <span
							style="left"> <input id="Text2" type="password"
								class="txt" name="password" />
						</span></li>
						<li><span class="left login-text">验证码：</span> <span
							style="left"> <input id="Text3" type="text" class="txt"
								name="checkcode" style="width: 90px" />
						</span></li>

					</ul>
				</li>
				<li class="topE"></li>
				<li class="middle_A"></li>
				<li class="middle_B"></li>
				<li class="middle_C"><span class="btn"><input name=""
						type="image" src="/CBDSystem/static/images/login/btnlogin.gif" /></span></li>
				<li class="middle_D"></li>
				<li class="bottom_A"></li>
				<li class="bottom_B">网站后台管理系统</li>
			</ul>
		</div>
	</form>
</body>
</html>